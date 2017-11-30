package catchme.messenger.logic;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import retrofit2.Response;
import retrofit2.Retrofit;

import catchme.messenger.catchme.R;


// TEMPORARILY CLASS
public class LogicTest extends AppCompatActivity {

    Retrofit retrofit;

    ServerApiInterface service;

    Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic_test);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://ksftx.pythonanywhere.com/api/")
                .build();
        service = retrofit.create(ServerApiInterface.class);
    }

    public void refresh() {
        account.setToken(
                service.getToken(account)
        );
        Log.d("logic", "refresh");
        System.out.println("logic" + "refresh");
    }

    /**
     * METHODS TO USE
     *///:~
    // !!! NOT RELATED TO LogicTest CLASS !!!
    // MUST BE LOGIN ACTIVITY's MEMBERS
    public void login(Account account) {
        // TODO get user data from context
        this.account = account;

        String token = service.getToken(this.account);
        Log.d("logic", "onLogin");
        System.out.println("logic" + "onLogin");
    }

    public void signup(Account account) {
        // TODO get user data from context
        this.account = account;
        final Account newAccount = account;

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                service.register(newAccount);
            }
        });
        thread.start();

        this.login(this.account);
        Log.d("logic", "onSignup");
        System.out.println("logic" + "onSignup");
    }

    public void logout() {
        // TODO deside if we need it
        // deleting account from device
//        java.util.List<Account> allAccount = Account.listAll(Account.class);
//        Account.deleteAll(Account.class);
        // clearing messages cache
//        java.util.List<Message> messagesCache = Message.listAll(Message.class);
//        Message.deleteAll(Message.class);
        Log.d("logic", "onLogout");
        System.out.println("logic" + "logout");
    }

    /* METHODS RELATED TO MESSAGES *///:~
    public String getMessages(Account account, Integer chatId) throws IOException {
        Response response
                = service.getMessages(chatId, account.getToken()).execute();
        return response.body().toString();
    }

    public void sendMessage(final Message message) {
        final Account account = this.account;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                service.sendMessage(account.getToken(), message);
            }
        });
        thread.start();
    }




}
