package catchmemessemger.itis.kpfu.ru.logic;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import catchmemessemger.itis.kpfu.ru.catchme.R;

public class LogicTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic_test);
    }



    /* TODO LIST *///:
    /*  get user's login & password
     *  get user's name
     *  NET stuff
     *  VALIDATION stuff
     *  ChatActivity class
     *  start chat activity
     */
    /** METHODS TO USE *///:~
    // !!! NOT RELATED TO LogicTest CLASS !!!
    // MUST BE LOGIN ACTIVITY's MEMBERS
    public void onLogin(Context context) {

        // TODO get user's login & password

        Account account = new Account("DEFAULT_LOGIN");

        // TODO get user's name
        User user = new User("DEFAULT_NAME", account);

        // TODO NET stuff

        // TODO VALIDATION stuff

        // SAVING TO DATABASE
        account.save();

        // TODO ChatActivity class
//        startActivity(new Intent(context, ChatActiviry.class));
    }

    public void onSignup(Context context) {
        // TODO get user's login & password

        // there must be registration or smth

        this.onLogin(context);

        // TODO KOLYA HOW TO DETECT NEW ENTRY TO DISCUSS
    }

    public void onLogout() {
        // TODO NET STUFF

        // deleting account from device
//        java.util.List<Account> allAccount = Account.listAll(Account.class);
        Account.deleteAll(Account.class);

        // clearing messages cache
//        java.util.List<Message> messagesCache = Message.listAll(Message.class);
        Message.deleteAll(Message.class);
    }


    /* METHODS RELATED TO MESSAGES *///:~



}
