package catchme.messenger.catchme;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adapter extends BaseAdapter {

    private Context mContext;
    private String [] users;

    public Adapter(Context context, String[] users) {
        mContext = context;
        this.users = users;
    }

    static class ViewHolder {
        TextView userName;
    }

    @Override
    public int getCount() {
        return users.length;
    }

    @Override
    public String getItem(int i) {
        return users[i];
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
            convertView = inflater.inflate(R.layout.chat_list_item, viewGroup, false);
            viewHolderName = new ViewHolder();
            viewHolderName.userName = (TextView) convertView.findViewById(R.id.userName);
            convertView.setTag(viewHolderName);
        } else {
            viewHolderName = (ViewHolder) convertView.getTag();
        }

        viewHolderName.userName.setText(getItem(position));

        return convertView;
    }
}
