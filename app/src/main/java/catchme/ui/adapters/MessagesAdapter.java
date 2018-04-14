package catchme.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import catchme.net.models.Message;
import catchme.ui.R;


public class MessagesAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> messages = new ArrayList<>();
    private List<String> users = new ArrayList<>();
    private int k = 0;


    public MessagesAdapter(Context context, List<Message> messages) {
        mContext = context;
        // TODO: решить проблему с авторством сообщений
        for(Message mes : messages) {
            String author;
            if(mes.getAuthor() == 0)
                author = "Идет отправка вашего сообщения...";
            else
            if(mes.getAuthor() == 1)
                author = "kolya";
            else if(mes.getAuthor() == 2)
                author = "dima";
            else if(mes.getAuthor() == 5)
            author = "lesya";
            else author = "user";

            this.users.add(author);
            this.messages.add(mes.getText());
        }

    }

    static class ViewHolder {
        TextView messageText;
        TextView userName;
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public String getItem(int i) {
        if (k % 2 != 0) {
            k++;
            return messages.get(i);
        }
        else{
            k++;
            return users.get(i);
        }
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolderName;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.message, viewGroup, false);
            viewHolderName = new ViewHolder();
            viewHolderName.userName = (TextView) convertView.findViewById(R.id.userName);
            viewHolderName.messageText = (TextView) convertView.findViewById(R.id.message);

            convertView.setTag(viewHolderName);
        } else {
            viewHolderName = (ViewHolder) convertView.getTag();
        }

        viewHolderName.userName.setText(getItem(position));
        viewHolderName.messageText.setText(getItem(position));

        return convertView;
    }

}
