package edu.wtamu.tfleeman.track_a_truck;

        import android.support.v4.app.Fragment;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.List;

public class UserListFragment extends Fragment{

    private static final String SAVED_SUBTITLE_VISIBLE = "subtitle";

    private RecyclerView mUserRecyclerView;
    private UserAdapter mAdapter;
    private boolean mSubtitleVisible;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_list, container, false);

        mUserRecyclerView = (RecyclerView) view
                .findViewById(R.id.user_recycler_view);
        mUserRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (savedInstanceState != null) {
            mSubtitleVisible = savedInstanceState.getBoolean(SAVED_SUBTITLE_VISIBLE);
        }

        updateUI();

        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        updateUI();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(SAVED_SUBTITLE_VISIBLE, mSubtitleVisible);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_user_list, menu);

        MenuItem subtitleItem = menu.findItem(R.id.show_position);
        if (mSubtitleVisible){
            subtitleItem.setTitle(R.string.hide_position);
            }else{
            subtitleItem.setTitle(R.string.show_position);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_user:
                User user = new User();
                UserLab.get(getActivity()).addUser(user);
                Intent intent = UserPagerActivity
                        .newIntent(getActivity(), user.getId());
                startActivity(intent);
                return true;
            case R.id.show_position:
                mSubtitleVisible = !mSubtitleVisible;
                getActivity().invalidateOptionsMenu();
                updateSubtitle();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateSubtitle(){
        UserLab userLab = UserLab.get(getActivity());
        int userCount = userLab.getUsers().size();
        String subtitle = getString(R.string.subtitle_format, userCount);

        if (!mSubtitleVisible){
            subtitle = null;
        }

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setSubtitle(subtitle);
    }



    private void updateUI(){
        UserLab userlab = UserLab.get(getActivity());
        List<User> users = userlab.getUsers();

        if (mAdapter == null){
            mAdapter = new UserAdapter(users);
            mUserRecyclerView.setAdapter(mAdapter);
        }else{
            mAdapter.notifyDataSetChanged();
        }

        updateSubtitle();
    }

    private class UserHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private User mUser;

        private TextView mNameTextView;
        private TextView mPositionTextView;
        private TextView mEmailTextView;

        public UserHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_user, parent, false));
            itemView.setOnClickListener(this);

            mNameTextView = (TextView) itemView.findViewById(R.id.user_name);
            mPositionTextView = (TextView) itemView.findViewById(R.id.user_position);
            mEmailTextView = (TextView) itemView.findViewById(R.id.user_email);

        }

        public void bind(User user) {
            mUser = user;
            mNameTextView.setText(mUser.getName());
            mPositionTextView.setText(mUser.getPosition());
            mEmailTextView.setText(mUser.getEmail());
        }

        @Override
        public void onClick(View view) {
            Intent intent = UserPagerActivity.newIntent(getActivity(), mUser.getId());
            startActivity(intent);
        }
    }


    private class UserAdapter extends RecyclerView.Adapter<UserHolder>
    {
        private List<User> mUsers;

        public UserAdapter(List<User> users){
            mUsers = users;
        }

        @Override
        public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new UserHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(UserHolder holder, int position) {
            User user = mUsers.get(position);
            holder.bind(user);
        }
        

        @Override
        public int getItemCount() {
            return mUsers.size();
        }
    }
}
