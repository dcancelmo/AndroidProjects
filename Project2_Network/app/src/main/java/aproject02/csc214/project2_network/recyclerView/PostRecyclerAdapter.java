package aproject02.csc214.project2_network.recyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import aproject02.csc214.project2_network.R;
import aproject02.csc214.project2_network.model.Post;
import aproject02.csc214.project2_network.model.User;

/**
 * Created by Dan on 4/9/17.
 */

public class PostRecyclerAdapter extends RecyclerView.Adapter<PostViewHolder> {

    private List<Post> mPosts;

    public PostRecyclerAdapter(List<Post> mPostList) {
        mPosts = mPostList;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        View mView = mInflater.inflate(R.layout.view_post, parent, false);
        PostViewHolder mHolder = new PostViewHolder(mView);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.bindPost(mPosts.get(position));
    }

    @Override
    public int getItemCount() {
        if (mPosts != null) {
            return mPosts.size();
        } else {
            return 0;
        }
    }

    public void swap(ArrayList<Post> mNewList){
        if (mPosts != null) {
            mPosts.clear();
            mPosts.addAll(mNewList);
        } else {
            mPosts = mNewList;
        }
        notifyDataSetChanged();
    }
}
