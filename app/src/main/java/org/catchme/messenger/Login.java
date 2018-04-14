package org.catchme.messenger;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import org.catchme.net.API;
import org.catchme.ui.ChatListActivity;
import org.catchme.ui.LoginActivity;

import java.util.concurrent.ExecutionException;

public class Login extends AsyncTask<Void, Void, Boolean> {
    private String name;
    private String password;
    private Context context;

    public boolean attemptLogin(Context context, String name, String password) {
        // TODO: CODE_STATUS
        try {
            this.context = context;
            this.name = name;
            this.password = password;
            execute();
            return get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        CatchMeApp app = (CatchMeApp) context.getApplicationContext();
        app.setApi(new API(name, password));
        return null != app.getApi();
    }

}