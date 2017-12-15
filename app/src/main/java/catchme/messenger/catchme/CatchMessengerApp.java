package catchme.messenger.catchme;

import android.app.Application;

import catchme.messenger.logic.API;
import catchme.messenger.logic.models.Token;

/**
 * Created by kolya on 15.12.17.
 */

public class CatchMessengerApp extends Application {
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyLCJ1c2VybmFtZSI6ImRpbWEiLCJleHAiOjE1MjE5NjkzNjYsImVtYWlsIjoiZGltYUBnbWFpbC5jb20ifQ.SEIzNqFEh_AQOvI5k4ZxhZXIqespskkxocYVPJg3a28";
    public API api;
}
