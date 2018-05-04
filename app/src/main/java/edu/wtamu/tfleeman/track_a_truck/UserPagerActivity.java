package edu.wtamu.tfleeman.track_a_truck;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

public class UserPagerActivity extends AppCompatActivity {
    private static final String EXTRA_USER_ID =
        "edu.wtamu.tfleeman.track-a-truck.user_id";

    private ViewPager mViewPager;
    private List<User> mUsers;

    public static Intent newIntent(Context packageContext, UUID userId){
        Intent intent = new Intent(packageContext, UserPagerActivity.class);
        intent.putExtra(EXTRA_USER_ID, userId);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pager);

        UUID userId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_USER_ID);

        mViewPager = (ViewPager) findViewById(R.id.user_view_pager);

        mUsers = UserLab.get(this).getUsers();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {

            @Override
            public Fragment getItem(int position) {
                User user = mUsers.get(position);
                return UserFragment.newInstance(user.getId());
            }

            @Override
            public int getCount() {
                return mUsers.size();
            }
        });

        for (int i = 0; i < mUsers.size(); i++){
            if (mUsers.get(i).getId().equals(userId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
