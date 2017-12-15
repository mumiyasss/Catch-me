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

public class MainActivity extends AppCompatActivity/* implements View.OnClickListener */ {

    Button dima, lesya, logicButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
//        dima = findViewById(R.id.dima);
//        lesya = findViewById(R.id.lesya);
//        logicButton = findViewById(R.id.logic);
//
//
//        logicButton.setOnClickListener(this);
//        dima.setOnClickListener(this);
//        lesya.setOnClickListener(this);

        SugarContext.init(this);

        Intent intent;
        try {
            Token token = Token.findById(Token.class, 1);
//            Log.d("token", token.toString());
//            Toast.makeText(this, "TOKEN is in DB, goto chatListAct", Toast.LENGTH_LONG).show();
             intent = new Intent(this, ChatListActivity.class);
        } catch (Exception e) {
//            Log.d("token", "no token detected");
//            Toast.makeText(this, "DB has no TOKEN, goto logintAct", Toast.LENGTH_LONG).show();
            intent = new Intent(this, LogicTest.class);
        }
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        try {
            Token.findById(Token.class, 1)
                    .save();
        } catch (Exception e) {}
=======


        dima = findViewById(R.id.dima);
        lesya = findViewById(R.id.lesya);
        logicButton = findViewById(R.id.logic);
>>>>>>> 8c8bc3ee7622039134030a0c17c451b7d88142de

//        SugarContext.terminate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

<<<<<<< HEAD
        try {
            Token.findById(Token.class, 1)
                    .save();
        } catch (Exception e) {}
        SugarContext.terminate();
=======
        logicButton.setOnClickListener(this);
        dima.setOnClickListener(this);
        lesya.setOnClickListener(this);

        try {
            TokenSaver ts = TokenSaver.findById(TokenSaver.class, 1);
            API api = new API(ts.getToken());
        } catch (Exception e) {
            e.printStackTrace();
        }
>>>>>>> 8c8bc3ee7622039134030a0c17c451b7d88142de
    }


    /*
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.logic:
                Intent logicIntent = new Intent(this, catchme.messenger.logic.LogicTest.class);
                startActivity(logicIntent);
                break;
            case R.id.dima:
                Intent logicIntentMain = new Intent(this, catchme.messenger.logic.STUDY.class);
                startActivity(logicIntentMain);
                break;
            case R.id.lesya:
                Intent uiIntentMain = new Intent(this, LoginActivity.class);
                startActivity(uiIntentMain);
                break;
        }
    }
    */

}
