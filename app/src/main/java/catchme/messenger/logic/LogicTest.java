package catchme.messenger.logic;


import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

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
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://ksftx.pythonanywhere.com/")
                .build();
        service = retrofit.create(ServerApiInterface.class);
    }

    public void btnPressed (View view) {
        EditText nameField = findViewById(R.id.name);
        String name = nameField.getText().toString();

        EditText emailField = findViewById(R.id.email);
        String email = emailField.getText().toString();

        EditText passwordField = findViewById(R.id.password);
        String pasword = passwordField.getText().toString();

        EditText messageField = findViewById(R.id.message);
        String message = messageField.getText().toString();
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
    // !!! NOT RELATED TO logic.LogicTest CLASS !!!
    // MUST BE LOGIN ACTIVITY's MEMBERS
    public void login(View view) {
        this.account = new Account(
                ((EditText) findViewById(R.id.name)).getText().toString(),
                ((EditText) findViewById(R.id.password)).getText().toString()
//                ((EditText) findViewById(R.id.email)).getText().toString()
        );

        String token = service.getToken(this.account);
        Log.d("logic", "onLogin");
        System.out.println("logic" + "onLogin");
    }

    public void signup(View view) {
        this.account = new Account(
                ((EditText) findViewById(R.id.name)).getText().toString(),
                ((EditText) findViewById(R.id.password)).getText().toString()
//                ((EditText) findViewById(R.id.email)).getText().toString()
        );

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                service.register(account);
            }
        });
        thread.start();

        this.login(view);
        Log.d("logic", "onSignup");
        System.out.println("logic" + "onSignup");
    }

    public void logout(View view) {
        Log.d("logic", "onLogout");
        System.out.println("logic" + "logout");
    }

    /* METHODS RELATED TO MESSAGES *///:~
    public String getMessages(Integer chatId) throws IOException {
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
