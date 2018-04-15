package org.catchme.net;

import android.util.Log;


import org.catchme.net.models.Message;
import org.catchme.net.models.SendingMessage;
import org.catchme.net.models.Token;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.catchme.net.models.Account;
import org.catchme.net.models.Chat;

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
    public Token token;

    public Token getToken() {
        return token;
    }

    private API() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://ksftx.pythonanywhere.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ServerApiInterface.class);
    }

    public API(String name, String password) {
        this();
        getToken(name, password);
    }

    public API(Token token) {
        this();
        this.token = token;
    }

    private void getToken(String name, String password) {
        final Account account = new Account(name, password);
        try {
            Response<Token> response = service.
                    getToken("application/json", account).execute();

            token = new Token(response.body().getToken());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Chat> getChatList() {
        final List<Chat> chats = new ArrayList<>();
        try {
            Response<List<Chat>> response = service
                    .getChats(token.getToken())
                    .execute();
            chats.addAll(response.body());
            Log.d("Response", chats.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return chats;
    }

    public List<Message> getChatMessages(Integer chatId) {
        final List<Message> messages = new ArrayList<>();
        service.getMessages(chatId, token.getToken()).enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                messages.clear();
                messages.addAll(response.body());
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                Log.d("Exception", t.toString());
            }
        });

        return messages;
    }

    public void sendMessage(Integer chatId, String message) {
        final SendingMessage sm = new SendingMessage(chatId, message);
        String conType = "application/json";
        service.sendMessage(conType, token.getToken(), sm).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Log.d("sm", "Message sent");
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {

            }
        });
    }
}

