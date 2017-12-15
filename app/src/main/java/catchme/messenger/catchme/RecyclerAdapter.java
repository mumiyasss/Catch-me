package catchme.messenger.catchme;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;

import java.util.List;

import catchme.messenger.logic.models.Chat;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Chat> users;
    private static Context context;

    public RecyclerAdapter(Context context, List<Chat> users) {
        this.users = users;
        this.context = context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName;

        public ViewHolder(View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.userName);
        }
    }
    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.userName.setText(users.get(position).getName());
        holder.userName.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra("chat_id", users.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
}

