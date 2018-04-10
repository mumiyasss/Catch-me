package catchme.messenger.messenger;

import android.app.Application;
import android.content.Intent;

import catchme.messenger.net.API;
import catchme.messenger.ui.LoginActivity;


public class CatchMessengerApp extends Application {
    private API api;

    @Override
    public void onCreate() {
        super.onCreate();

        Intent intent;
        intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
