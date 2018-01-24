package catchme.messenger.catchme;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import catchme.messenger.logic.API;
import catchme.messenger.logic.models.Chat;
import catchme.messenger.logic.models.Message;

import static java.lang.Thread.sleep;

public class ChatListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);
        // TODO: решить проблему с потоками
        CatchMeApp app = ((CatchMeApp) getApplicationContext());

        List<Chat> chats = app.api.getChatList();

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerAdapter(this, chats);
        mRecyclerView.setAdapter(mAdapter);
    }

    class ChatListUpdater extends AsyncTask<Void, List<Chat>, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            while (true) {
//                List<Message> just_uploaded = api.getChatMessages(CHAT_ID);
//                // Проверка на наличие отправленного сообщения
//                if(just_uploaded.size() >= newMessages.size()) {
//                    // Если да, то записываем изменения
//                    newMessages.clear();
//                    newMessages.addAll(just_uploaded);
//                    publishProgress(newMessages);
//                }
                // TODO: доделать, проверить auth header для getChats()
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        protected void onProgressUpdate(List<Chat>... chats) {
            super.onProgressUpdate(chats);
        }
    }
}
