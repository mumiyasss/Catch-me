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

import retrofit2.Call;
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
                .baseUrl("http://ksftx.pythonanywhere.com/")
                .build();
        service = retrofit.create(ServerApiInterface.class);
        //List<Chat> chat = service.getChats();
        //Log.d("CHAT", chat.toString());
    }
/*
    public void login(View view) {
        this.account = new Account(
                ((EditText) findViewById(R.id.name)).getText().toString(),
                ((EditText) findViewById(R.id.password)).getText().toString()
        );

        String token = service.getToken(this.account).toString();
        Log.d("logic", "onLogin");
        System.out.println("logic" + "onLogin");
    }*/
}
