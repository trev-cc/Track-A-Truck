package edu.wtamu.tfleeman.track_a_truck;

import android.support.v4.app.Fragment;

public class UserListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new UserListFragment();



    }
}
