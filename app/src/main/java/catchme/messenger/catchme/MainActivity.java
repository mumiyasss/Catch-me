package catchme.messenger.catchme;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.orm.SugarContext;

import catchme.messenger.logic.*;
import catchme.messenger.logic.models.Token;

public class MainActivity extends AppCompatActivity {

    Button dima, lesya, logicButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        SugarContext.init(this);

        Intent intent;
        try {
            Token token = Token.findById(Token.class, 1);
//            Log.d("TokenLog", token.toString());
            intent = new Intent(this, ChatListActivity.class);
        } catch (Exception e) {
            intent = new Intent(this, LoginActivity.class);
        }
        startActivity(intent);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        try {
            Token.findById(Token.class, 1)
                    .save();
        } catch (Exception e) {}
        SugarContext.terminate();
    }
}
