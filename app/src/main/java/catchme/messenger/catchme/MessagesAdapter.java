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

    public MessagesAdapter(Context context, String[] messages) {
        mContext = context;
        this.messages = messages;
    }

    static class ViewHolder {
        TextView messageText;
    }

    @Override
    public int getCount() {
        return messages.length;
    }

    @Override
    public String getItem(int i) {
        return messages[i];
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
            viewHolderName.messageText = (TextView) convertView.findViewById(R.id.messageText);
            convertView.setTag(viewHolderName);
        } else {
            viewHolderName = (ViewHolder) convertView.getTag();
        }

        viewHolderName.messageText.setText(getItem(position));

        return convertView;
    }

}
