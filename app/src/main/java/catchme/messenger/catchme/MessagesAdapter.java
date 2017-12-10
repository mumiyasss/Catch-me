package catchme.messenger.catchme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MessagesAdapter extends BaseAdapter {

    private Context mContext;
    private String [] messages;
    private String [] users;
    private int k = 0;

    public MessagesAdapter(Context context, String[] messages, String[] users) {
        mContext = context;
        this.users = users;
        this.messages = messages;
    }

    static class ViewHolder {
        TextView messageText;
        TextView userName;
    }

    @Override
    public int getCount() {
        return messages.length;
    }

    @Override
    public String getItem(int i) {
        if (k % 2 == 0) {
            k++;
            return messages[i];
        }
        else{
            k++;
            return users[i];
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
