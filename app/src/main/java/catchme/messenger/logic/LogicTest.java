package catchme.messenger.logic;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.orm.SugarContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import catchme.messenger.catchme.R;
import catchme.messenger.logic.models.Token;

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

        SugarContext.init(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SugarContext.terminate();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.getTok:
                String name = ((EditText) findViewById(R.id.name)).getText().toString();
                String password = ((EditText) findViewById(R.id.password)).getText().toString();
                api = new API(name, password);
//
//                final Token token = api.getToken();
//                Thread tokenSaverThread = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        token.save();
//                    }
//                });
//                tokenSaverThread.start();

                api.saveToken(this);

                break;
            case R.id.getChats:
                api.getChatMessages(1);
                break;
        }
    }
}
