package catchme.messenger.logic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import catchme.messenger.catchme.MainActivity;
import catchme.messenger.catchme.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class STUDY extends AppCompatActivity {
    Retrofit retrofit;
    ServerApiInterface service;
    List<Chat> chats;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://ksftx.pythonanywhere.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ServerApiInterface.class);

        chats = new ArrayList<>();


        // Ассинхронный запрос
        service.getChats().enqueue(new Callback<List<Chat>>() {
            @Override
            public void onResponse(Call<List<Chat>> call, Response<List<Chat>> response) {
                Toast.makeText(STUDY.this, "We have a response", Toast.LENGTH_LONG).show();
                chats.addAll(response.body());
                Log.d("Response", chats.toString());
            }

            @Override
            public void onFailure(Call<List<Chat>> call, Throwable t) {
                Toast.makeText(STUDY.this, "Failure", Toast.LENGTH_LONG).show();
            }

        });
    }
}
