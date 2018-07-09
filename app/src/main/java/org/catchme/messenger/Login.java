package org.catchme.messenger;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import org.catchme.net.API;

import java.util.concurrent.ExecutionException;

import static android.content.Context.MODE_PRIVATE;

public class Login extends AsyncTask<Void, Void, Boolean> {
    private String name;
    private String password;
    private CatchMeApp app;
    private Context context;

    /**
     *
     * @param context
     * @param name
     * @param password
     * @return false if failed, else true;
     */
    public boolean attemptLogin(Context context, String name, String password) {
        // TODO: CODE_STATUS
        try {
            this.name = name;
            this.password = password;
            this.context = context;
            this.app = (CatchMeApp) context.getApplicationContext();
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
        app.setApi(new API(name, password));
        if( app.getApi() != null) {
            writeTokenToSPref();
            return true;
        } else return  false;
    }

    private void writeTokenToSPref() {
        SharedPreferences sPref;
        sPref = context.getSharedPreferences("Token", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("TOKEN", (app.getApi().getToken()).getToken());
        ed.commit();
    }

}