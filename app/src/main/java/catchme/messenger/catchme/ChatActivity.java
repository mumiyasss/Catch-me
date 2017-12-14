package catchme.messenger.catchme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    static ArrayList<String> messages = new ArrayList<>();
    static ArrayList<String> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //messages.add("hello");
        //users.add("Kolyan");
        //messages.add("its meee");
        //users.add("Dimon");
        MessagesAdapter adapter = new MessagesAdapter(this, users, messages);
        ListView lv = (ListView) findViewById(R.id.chatListView);
        lv.setAdapter(adapter);

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

    public void send(View view) {
        EditText messageField = findViewById(R.id.messageField);
        String s = messageField.getText().toString().trim();

        if (!s.equals("")) {
            messages.add(s);
            users.add("me");
            messageField.setText("");
            MessagesAdapter adapter = new MessagesAdapter(this, users, messages);
            ListView lv = (ListView) findViewById(R.id.chatListView);
            lv.setAdapter(adapter);
        }
    }


}
