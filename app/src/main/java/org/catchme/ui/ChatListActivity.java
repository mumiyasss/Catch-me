package org.catchme.ui;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import org.catchme.messenger.CatchMeApp;
import org.catchme.messenger.R;
import org.catchme.net.API;
import org.catchme.net.models.Chat;
import org.catchme.ui.adapters.RecyclerAdapter;

import static java.lang.Thread.sleep;

public class ChatListActivity extends AppCompatActivity {

    private RecyclerView RecyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager LayoutManager;
    private API api;
    private List<Chat> chats = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);
        api = CatchMeApp.getInstance().getApi();
        ChatListUpdater chatListUpdater = new ChatListUpdater();
        chatListUpdater.execute();
        RecyclerView = findViewById(R.id.rv);
        RecyclerView.setHasFixedSize(true);
        LayoutManager = new LinearLayoutManager(this);
        RecyclerView.setLayoutManager(LayoutManager);

    }

    class ChatListUpdater extends AsyncTask<Void, List<Chat>, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            while (true) {
                List<Chat> just_uploaded = api.getChatList();
                // Проверка на наличие отправленного сообщения
                if (just_uploaded.size() >= chats.size()) {
                    // Если да, то записываем изменения
                    chats.clear();
                    chats.addAll(just_uploaded);
                    publishProgress(chats);
                }
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        @Override
        protected void onProgressUpdate(List<Chat>[] values) {
            Adapter = new RecyclerAdapter(ChatListActivity.this, chats);
            RecyclerView.setAdapter(Adapter);
        }
    }
}
