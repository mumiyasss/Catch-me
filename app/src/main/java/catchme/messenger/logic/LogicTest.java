package catchme.messenger.logic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import catchme.messenger.catchme.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ServerApiInterface.class);
    }

    List<Chat> getChatList() {
        final List<Chat> chats = new ArrayList<>();

        service.getChats().enqueue(new Callback<List<Chat>>() {
            @Override
            public void onResponse(Call<List<Chat>> call, Response<List<Chat>> response) {
                Toast.makeText(LogicTest.this, "Chat list loaded", Toast.LENGTH_LONG).show();
                chats.addAll(response.body());
                Log.d("Response", chats.toString());
            }

            @Override
            public void onFailure(Call<List<Chat>> call, Throwable t) {
                Toast.makeText(LogicTest.this, "We've got a problem", Toast.LENGTH_LONG).show();
                Log.d("Exception", t.toString());
            }
        });

        return chats;
    }

    public void getAccount(View view) {
        this.account = new Account(
                ((EditText) findViewById(R.id.name)).getText().toString(),
                ((EditText) findViewById(R.id.password)).getText().toString()
        );
        Log.d("method call", "getAccount");
        getToken();
        Log.d("method call", "getToken");
    }

    void getToken() {
         service.getToken(account).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(LogicTest.this, "We have a response", Toast.LENGTH_LONG).show();
                account.setToken(response.toString());
                Log.d("Response", account.toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(LogicTest.this, "We've got a problem", Toast.LENGTH_LONG).show();
                Log.d("Exception", t.toString());
            }
        });
    }

    List<Message> getChat(Integer chatId) {
        final List<Message> messages = new ArrayList<>();

        service.getMessages(chatId, account.getToken()).enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                Toast.makeText(LogicTest.this, "Messages loaded from chat", Toast.LENGTH_LONG).show();
                messages.addAll(response.body());
                Log.d("Response", messages.toString());
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                Toast.makeText(LogicTest.this, "Failure", Toast.LENGTH_LONG).show();
                Log.d("Exception", t.toString());
            }
        });

        return messages;
    }

}
