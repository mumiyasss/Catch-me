package catchme.messenger.catchme;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.orm.SugarContext;

import java.util.Iterator;

import catchme.messenger.logic.*;
import catchme.messenger.logic.models.Token;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        SugarContext.init(this);

        Intent intent;
        //try {
            //Token token = Token.first(Token.class);
            //Log.d("TokenLog", "Token is in db: " + token.toString());
            intent = new Intent(this, ChatListActivity.class);
        //} catch (Exception e) {
            //Log.d("TokenLog", "Token not found (in db).");
          //  intent = new Intent(this, LoginActivity.class);
        //}
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity", "MainActivity destroyed.");
        SugarContext.terminate();
    }
}
