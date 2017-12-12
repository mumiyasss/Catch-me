package catchme.messenger.logic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import catchme.messenger.catchme.R;
import catchme.messenger.logic.models.Account;
import catchme.messenger.logic.models.Chat;
import catchme.messenger.logic.models.Token;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LogicTest extends AppCompatActivity implements View.OnClickListener {

    Button getTok, getChats;
    API api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic_test);

        getTok = findViewById(R.id.getTok);
        getChats = findViewById(R.id.getChats);
        getTok.setOnClickListener(this);
        getChats.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.getTok:
                String name = ((EditText) findViewById(R.id.name)).getText().toString();
                String password = ((EditText) findViewById(R.id.password)).getText().toString();
                api = new API(name, password);
                break;
            case R.id.getChats:
                api.getChatList();
                //api.getChatMessages(1);
                break;
        }
    }


}
