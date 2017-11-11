package catchmemessemger.itis.kpfu.ru.catchme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ChatListActivity extends AppCompatActivity {
    final String ATTRIBUTE_NAME_USER = "user";
    final String ATTRIBUTE_NAME_MESSAGE = "message";
    final String ATTRIBUTE_NAME_TIME = "time";
    public static ArrayList users = new ArrayList();
    public static ArrayList lastMessages = new ArrayList();
    public static ArrayList time = new ArrayList();
    public void addChat(String chat) {
        users.add(chat);
    }

    public void addLastMessage(String message) {
        lastMessages.add(message);
    }

    public void addTime(String time) {
        this.time.add(time);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        addChat("User1");
        addChat("User2");
        addChat("User3");

        addLastMessage("Hey");
        addLastMessage("Hello");
        addLastMessage("Bye");

        addTime("20:00");
        addTime("22:22");
        addTime("10:15");

        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(users.size());
        Map<String, Object> m;
        for (int i = 0; i < users.size(); i++) {
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_USER, users.get(i));
            m.put(ATTRIBUTE_NAME_MESSAGE, lastMessages.get(i));
            m.put(ATTRIBUTE_NAME_TIME, time.get(i));
            data.add(m);
        }

        String[] from = {ATTRIBUTE_NAME_USER, ATTRIBUTE_NAME_MESSAGE, ATTRIBUTE_NAME_TIME};
        int [] to = {R.id.userName, R.id.lastMassage, R.id.time};

        SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.chat_list_item, from, to);

        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(sAdapter);
    }
}
