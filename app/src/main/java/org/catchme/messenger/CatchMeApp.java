package org.catchme.messenger;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import org.catchme.net.API;
import org.catchme.net.models.Token;
import org.catchme.ui.ChatListActivity;
import org.catchme.ui.LoginActivity;

public class CatchMeApp extends Application {
    private static API api;
    private static CatchMeApp instance;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;


    }

    public static void setApi(API api) {
        CatchMeApp.api = api;
    }

    // TODO: как гарантировать что getAPI не даст null
    // Решение мб через чтение базы данных?
    public API getApi() {
        return api;
    }

    public static CatchMeApp getInstance() {
        return instance;
    }
}
