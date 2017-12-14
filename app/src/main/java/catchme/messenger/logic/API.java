package catchme.messenger.logic;

import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import catchme.messenger.catchme.R;
import catchme.messenger.logic.models.Account;
import catchme.messenger.logic.models.Chat;
import catchme.messenger.logic.models.Message;
import catchme.messenger.logic.models.Token;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kolya on 12.12.17.
 */

public class API {
    Retrofit retrofit;
    ServerApiInterface service;
    Token token;

    public API(String name, String password) {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://ksftx.pythonanywhere.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ServerApiInterface.class);

        getToken(name, password);
    }

    public API(String token) {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://ksftx.pythonanywhere.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ServerApiInterface.class);

        this.token = new Token(token);
    }

    void showToken() {
        Log.d("IN MAIN Thread", token.toString());
    }
    void showChats() {
        Log.d("IN MAIN Thread", chats.toString());
    }


    void getToken(String name, String password) {
        final Account account = new Account(name, password);

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<Token> response = service.getToken("application/json", account).execute();
                    token = new Token(response.body().getToken());
                    Log.d("Response", token.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        th.setName("Get token thread");
        th.start();
        try {
            th.join();
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread " + th.getName() + " interrupted!");
        }
    }

    List<Chat> chats = new ArrayList<>();
    List<Chat> getSyncChatList() {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<List<Chat>> response = service.getChats().execute();
                    chats = response.body();
                    Log.d("Response", chats.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        th.setName("Get Chat List");
        th.start();
        try {
            th.join();
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread " + th.getName() + " interrupted!");
        }
        return chats;
    }

    List<Message> messages;
    void getSyncMessages(final Integer chatId ) {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<List<Message>> response = service.getMessages(chatId, token.getToken()).execute();
                    Log.d("RES", response.toString());
                    //messages.addAll(response.body());
                    //Log.d("Response", messages.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        th.setName("Get messages List");
        th.start();
        try {
            th.join();
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread " + th.getName() + " interrupted!");
        }
        Log.d("IN MAIN Thread", messages.toString());
    }

    List<Chat> getChatList() {
        final List<Chat> chats = new ArrayList<>();

        service.getChats().enqueue(new Callback<List<Chat>>() {
            @Override
            public void onResponse(Call<List<Chat>> call, Response<List<Chat>> response) {

                chats.addAll(response.body());
                Log.d("Response", chats.toString());
            }

            @Override
            public void onFailure(Call<List<Chat>> call, Throwable t) {
                Log.d("Exception", t.toString());
            }
        });

        return chats;
    }

    List<Message> getChatMessages(Integer chatId) {
        messages = new ArrayList<>();

        service.getMessages(chatId, token.getToken()).enqueue(new Callback<List<Message>>() {
            @Override

            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                messages.addAll(response.body());
                Log.d("Response", messages.toString());
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                Log.d("Exception", t.toString());
            }

        });

        Log.d("Log", "getChatMessages() successful call");

        return messages;
    }
}