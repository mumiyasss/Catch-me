package catchmemessemger.itis.kpfu.ru.catchme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);
        addChat("User1");
        addChat("User2");
        addChat("User3");
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerAdapter(this, users);
        mRecyclerView.setAdapter(mAdapter);



    }

}
