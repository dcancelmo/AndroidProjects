package aproject02.csc214.project2_network.recyclerView;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;

import aproject02.csc214.project2_network.R;
import aproject02.csc214.project2_network.database.NetworkDb;
import aproject02.csc214.project2_network.model.Post;
import aproject02.csc214.project2_network.model.User;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostListFragment extends Fragment {

    private static final String KEY_USERNAME = "aproject02.csc214.project2_network.username";

    private RecyclerView mRecyclerView;
    private NetworkDb mDatabase;
    private ArrayList<Post> mPostsList;
    PostRecyclerAdapter mAdapter;


    public PostListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "RecyclerView");
        View mView = inflater.inflate(R.layout.fragment_post_list, container, false);
        mDatabase = NetworkDb.get(getContext());
        mPostsList = mDatabase.getPosts();
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.post_recycler_list_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Collections.reverse(mPostsList);
        mAdapter = new PostRecyclerAdapter(mPostsList);
        mRecyclerView.setAdapter(mAdapter);
        // Inflate the layout for this fragment
        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPostsList = mDatabase.getPosts();
        Collections.reverse(mPostsList);
        mAdapter.swap(mPostsList);
    }


    public static PostListFragment newInstance(Post mPost) {
        PostListFragment mFragment = new PostListFragment();
        Bundle args = new Bundle();
        args.putString(KEY_USERNAME, mPost.getUsername());
        mFragment.setArguments(args);
        return mFragment;
    }

}
