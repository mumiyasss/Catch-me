package catchme.messenger.catchme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ChatListActivity extends AppCompatActivity {

    public static String [] users = new String[3];
    public int iaddChat = 0;
    public void addChat(String chat) {
        users[iaddChat] = chat;
        iaddChat++;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);
        addChat("User1");
        addChat("User2");
        addChat("User3");


        Adapter adapter = new Adapter(this, users);

        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ChatListActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });


    }

}
