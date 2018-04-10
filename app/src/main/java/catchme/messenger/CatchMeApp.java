package catchme.messenger;

import android.app.Application;
import android.content.Intent;

import catchme.net.API;
import catchme.ui.LoginActivity;


public class CatchMeApp extends Application {
    private API api;

    public API getApi() {
        return api;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Intent intent;
        intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
