package catchme.messenger.catchme;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import catchme.messenger.logic.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button dima, lesya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dima = findViewById(R.id.dima);
        lesya = findViewById(R.id.lesya);

        dima.setOnClickListener(this);
        lesya.setOnClickListener(this);
    }


    public void onClick(View view) {
        switch (view.getId()) {
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

}
