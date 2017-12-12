package catchme.messenger.catchme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class ChatActivity extends AppCompatActivity {
    static String [] messages = new String[10];
    static String [] users = new String[10];
    static int size = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        messages[0] = "hello";
        users[0] = "Kolyan";
        messages[1] = "its meee";
        users[1] = "Dimon";
        size += 2;
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
        String s = messageField.getText().toString();
        messages[size] = s;
        users[size] = "me";
        messageField.setText("");
        size++;
        MessagesAdapter adapter = new MessagesAdapter(this, users, messages);
        ListView lv = (ListView) findViewById(R.id.chatListView);
        lv.setAdapter(adapter);
    }


}
