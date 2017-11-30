package catchme.messenger.logic;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import catchme.messenger.catchme.R;



// TEMPORARILY CLASS
public class LogicTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic_test);
    }

    public void btnPressed (View view) {
        EditText nameField = findViewById(R.id.name);
        String name = nameField.getText().toString();

        EditText emailField = findViewById(R.id.email);
        String email = emailField.getText().toString();

        EditText passwordField = findViewById(R.id.password);
        String pasword = passwordField.getText().toString();

        EditText messageField = findViewById(R.id.message);
        String message = messageField.getText().toString();


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
