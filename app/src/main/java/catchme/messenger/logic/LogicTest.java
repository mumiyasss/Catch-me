package catchme.messenger.logic;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import catchme.messenger.catchme.R;



// TEMPORARILY CLASS
public class LogicTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic_test);
    }

    /** METHODS TO USE *///:~
    // !!! NOT RELATED TO LogicTest CLASS !!!
    // MUST BE LOGIN ACTIVITY's MEMBERS
    public void onLogin(Context context) {


//        Account account = new Account("DEFAULT_LOGIN");


        // SAVING TO DATABASE
//        account.save();

//        startActivity(new Intent(context, ChatActiviry.class));
    }

    public void onSignup(Context context) {

        // there must be registration or smth

        this.onLogin(context);
    }

    public void onLogout() {

        // deleting account from device
//        java.util.List<Account> allAccount = Account.listAll(Account.class);
//        Account.deleteAll(Account.class);

        // clearing messages cache
//        java.util.List<Message> messagesCache = Message.listAll(Message.class);
//        Message.deleteAll(Message.class);
    }


    /* METHODS RELATED TO MESSAGES *///:~



}
