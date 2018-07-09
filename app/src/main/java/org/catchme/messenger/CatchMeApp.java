package org.catchme.messenger;

import android.app.Application;

import org.catchme.net.API;

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
