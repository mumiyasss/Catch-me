package org.catchme.ui;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.catchme.messenger.CatchMeApp;
import org.catchme.messenger.R;
import org.catchme.net.API;
import org.catchme.net.models.Token;


public class LaunchActivity extends AppCompatActivity {
    SharedPreferences sPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sPref = getSharedPreferences("Token", MODE_PRIVATE);
        String token = sPref.getString("TOKEN", "NO_TOKEN");

        if(token.equals("NO_TOKEN")) {
            Intent intent;
            intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else {
            // TODO: обернуть в try/catch
            CatchMeApp.getInstance().setApi(new API(new Token(token)));
            Intent intent;
            intent = new Intent(this, ChatListActivity.class);
            startActivity(intent);
        }
    }

}
