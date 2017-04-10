package aproject02.csc214.project2_network.recyclerView;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import aproject02.csc214.project2_network.R;
import aproject02.csc214.project2_network.database.NetworkDb;
import aproject02.csc214.project2_network.model.User;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserListFragment extends Fragment {

    private static final String KEY_EMAIL = "aproject02.csc214.project2_network.email";

    private RecyclerView mRecyclerView;
    private NetworkDb mDatabase;
    private ArrayList<User> mUsersList;




    public UserListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "RecyclerView");
        View mView = inflater.inflate(R.layout.fragment_user_list, container, false);
        mDatabase = NetworkDb.get(getContext());
        mUsersList = mDatabase.getUserList();
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.user_recycler_view_fragment);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        UserRecyclerAdapter mAdapter = new UserRecyclerAdapter(mUsersList);
        mRecyclerView.setAdapter(mAdapter);

        // Inflate the layout for this fragment
        return  mView;
    }

    public static UserListFragment newInstance(User mUser) {
        UserListFragment mFragment = new UserListFragment();
        Bundle args = new Bundle();
        args.putString(KEY_EMAIL, mUser.getEmail());
        mFragment.setArguments(args);
        return mFragment;
    }

}
