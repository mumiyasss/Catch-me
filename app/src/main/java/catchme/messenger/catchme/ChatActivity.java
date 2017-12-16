package catchme.messenger.catchme;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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
    MessagesAdapter adapter = new MessagesAdapter(context, newMessages);

    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo1LCJ1c2VybmFtZSI6Imxlc3lhIiwiZXhwIjoxNTIyMDUxMTEzLCJlbWFpbCI6Imxlc3lhQG1haWwucnUifQ.JUMsvi1KH_yaLJSctIH3iXy_3rsnr5eZSbF0i5pxIyY";
    API api = new API(token);

    Intent intent = getIntent();
    int CHAT_ID ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent intent = getIntent();
        CHAT_ID  = intent.getIntExtra("chat_id", 1);

        //messagesUpdater();
        MesUp messagesUpdater = new MesUp();
        messagesUpdater.execute(CHAT_ID);
    }

    class MesUp extends AsyncTask<Integer, List<Message>, Void> {

        @Override
        protected Void doInBackground(Integer... chatId) {
            while (true) {

                List<Message> just_uploaded = api.getChatMessages(CHAT_ID);
                // Проверка на наличие отправленного сообщения
                if(just_uploaded.size() >= newMessages.size()) {
                    // Если да, то записываем изменения
                    newMessages.clear();
                    newMessages.addAll(just_uploaded);
                    publishProgress(newMessages);
                }
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        @Override
        protected void onProgressUpdate(List<Message>... nm) {
            super.onProgressUpdate(nm);
            MessagesAdapter adapter = new MessagesAdapter(ChatActivity.this, newMessages);
            ListView lv = (ListView) findViewById(R.id.chatListView);
            lv.setAdapter(adapter);
        }

    }




    void messagesUpdater() {
        Thread mesUpdThread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {

                    newMessages.clear();
                    newMessages.addAll(api.getChatMessages(CHAT_ID));
                    //Log.d("Updater", newMessages.toString());
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


    public void send(View view) {
        EditText messageField = findViewById(R.id.messageField);
        String s = messageField.getText().toString().trim();

        if (!s.equals("")) {
            api.sendMessage(CHAT_ID, s);
            Message m = new Message(s, 0);
            newMessages.add(m);
            messageField.setText("");
            MessagesAdapter adapter = new MessagesAdapter(this, newMessages);
            ListView lv = (ListView) findViewById(R.id.chatListView);
            lv.setAdapter(adapter);

        }
    }

}