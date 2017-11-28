package catchme.messenger.catchme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class ChatActivity extends AppCompatActivity {
    static String [] messages = new String[100];
    static int size = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        messages[0] = "hello";
        messages[1] = "its meee";
        size += 2;
        MessagesAdapter adapter = new MessagesAdapter(this, messages);
        ListView lv = (ListView) findViewById(R.id.chatListView);
        lv.setAdapter(adapter);

    }

    public void send(View view) {
        EditText messageField = findViewById(R.id.messageField);
        String s = messageField.getText().toString();
        messages[size] = s;
        messageField.setText("");
        size++;
    }


}
