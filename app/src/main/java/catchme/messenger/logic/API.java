package catchme.messenger.logic;

import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    void getToken(String name, String password) {
        Account account = new Account(name, password);

        service.getToken("application/json", account).enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                token = response.body();
                Log.d("Response", token.toString());
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Log.d("Exception", t.toString());
            }
        });
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
        final List<Message> messages = new ArrayList<>();

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

        return messages;
    }

}