package edu.wtamu.tfleeman.track_a_truck;

        import android.support.v4.app.Fragment;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.List;

public class UserListFragment extends Fragment{

    private RecyclerView mUserRecyclerView;
    private UserAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_list, container, false);

        mUserRecyclerView = (RecyclerView) view
                .findViewById(R.id.crime_recycler_view);
        mUserRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI(){
        UserLab userlab = UserLab.get(getActivity());
        List<User> users = userlab.getUsers();

        mAdapter = new UserAdapter(users);
        mUserRecyclerView.setAdapter(mAdapter);
    }

    private class UserHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private User mUser;

        private TextView mNameTextView;
        /*private TextView mPositionTextView;
        private TextView mPhoneTextView;
        private TextView mEmailTextView;
        private TextView mAddressTextView;*/

        public UserHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_user, parent, false));
            itemView.setOnClickListener(this);

            mNameTextView = (TextView) itemView.findViewById(R.id.user_name);
            /*mPositionTextView = (TextView) itemView.findViewById(R.id.user_position);
            mPhoneTextView = (TextView) itemView.findViewById(R.id.user_phone);
            mEmailTextView = (TextView) itemView.findViewById(R.id.user_email);
            mAddressTextView = (TextView) itemView.findViewById(R.id.user_address);*/
        }

        public void bind(User user) {
            mUser = user;
            mNameTextView.setText(mUser.getName());
            /*mPositionTextView.setText(mUser.getPosition());
            mPhoneTextView.setText(mUser.getPhone());
            mEmailTextView.setText(mUser.getEmail());
            mAddressTextView.setText(mUser.getAddress());*/
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), mUser.getName() + "clicked!", Toast.LENGTH_SHORT)
                    .show();
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
