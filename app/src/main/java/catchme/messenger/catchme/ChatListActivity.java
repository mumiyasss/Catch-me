package catchme.messenger.catchme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import catchme.messenger.logic.API;
import catchme.messenger.logic.models.Chat;
import catchme.messenger.logic.models.Message;

public class ChatListActivity extends AppCompatActivity {

    public static String [] users = new String[3];
    public int iaddChat = 0;
    public void addChat(String chat) {
        users[iaddChat] = chat;
        iaddChat++;
    }
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);
        API api = new API("ashdfoorieri");
        List<Chat> chats = api.getSyncChatList();
        for (Chat chat : chats) {
            addChat(chat.getName());
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerAdapter(this, users);
        mRecyclerView.setAdapter(mAdapter);



    }

}
