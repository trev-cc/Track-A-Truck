package edu.wtamu.tfleeman.track_a_truck;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.UUID;

public class UserFragment extends Fragment{

    private static final String ARG_USER_ID = "user_id";

    private User mUser;
    private EditText mNameField;
    private EditText mPositionField;
    private EditText mEmailField;

    public static UserFragment newInstance(UUID userId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_USER_ID, userId);

        UserFragment fragment = new UserFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID userId = (UUID) getArguments().getSerializable(ARG_USER_ID);
        mUser = UserLab.get(getActivity()).getUser(userId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user, container, false);

        mNameField = (EditText) v.findViewById(R.id.user_name);
        mNameField.setText(mUser.getName());
        mNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mUser.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPositionField = (EditText) v.findViewById(R.id.user_position);
        mPositionField.setText(mUser.getPosition());
        mPositionField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mUser.setPosition(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEmailField = (EditText) v.findViewById(R.id.user_email);
        mEmailField.setText(mUser.getEmail());
        mEmailField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mUser.setEmail(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return v;
    }
}
