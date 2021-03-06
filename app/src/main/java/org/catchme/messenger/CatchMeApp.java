package org.catchme.messenger;

import android.app.Application;
import android.content.Intent;

import org.catchme.net.API;
import org.catchme.ui.LoginActivity;


public class CatchMeApp extends Application {
    private static API api;


    public static void setApi(API api) {
        CatchMeApp.api = api;
    }

    // TODO: как гарантировать что getAPI не даст null
    // Решение мб через чтение базы данных?
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
