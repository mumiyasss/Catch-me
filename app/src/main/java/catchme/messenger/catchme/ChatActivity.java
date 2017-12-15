package catchme.messenger.catchme;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import catchme.messenger.logic.API;
import catchme.messenger.logic.models.Chat;
import catchme.messenger.logic.models.Message;

import static java.lang.Thread.sleep;

public class ChatActivity extends AppCompatActivity {
    List<Message> newMessages = new ArrayList<>();

    Context context;
    Intent intent = getIntent();




    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyLCJ1c2VybmFtZSI6ImRpbWEiLCJleHAiOjE1MjE5NjkzNjYsImVtYWlsIjoiZGltYUBnbWFpbC5jb20ifQ.SEIzNqFEh_AQOvI5k4ZxhZXIqespskkxocYVPJg3a28";
    API api = new API(token);

    final Integer CHAT_ID = intent.getIntExtra("chat_id", 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        Intent intent = getIntent();

        //messages.add("hello");
        //users.add("Kolyan");
        //messages.add("its meee");
        //users.add("Dimon");

        messagesUpdater();

    }

    void messagesUpdater() {
        Thread mesUpdThread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {

                    newMessages.clear();
                    newMessages.addAll(api.getChatMessages(CHAT_ID));
                    //Log.d("Updater", newMessages.toString());
                    MessagesAdapter adapter = new MessagesAdapter(context, newMessages);
                    ListView lv = (ListView) findViewById(R.id.chatListView);
                    lv.setAdapter(adapter);
                    try {
                        sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        mesUpdThread.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chat_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, ChatMenuActivity.class);
        this.startActivity(intent);
        return true;
    }


//    public void send(View view) {
//        EditText messageField = findViewById(R.id.messageField);
//        String s = messageField.getText().toString().trim();
//
//        if (!s.equals("")) {
//            messages.add(s);
//            users.add("me");
//            messageField.setText("");
//            MessagesAdapter adapter = new MessagesAdapter(this, users, messages);
//            ListView lv = (ListView) findViewById(R.id.chatListView);
//            lv.setAdapter(adapter);
//
//        }
//    }

}
