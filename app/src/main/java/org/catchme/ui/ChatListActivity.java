package org.catchme.ui;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.catchme.messenger.R;
import org.catchme.ui.fragments.ChatListFragment;

public class ChatListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new ChatListFragment();
    }
}
