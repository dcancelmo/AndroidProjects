package aproject02.csc214.project2_network.recyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import aproject02.csc214.project2_network.R;
import aproject02.csc214.project2_network.model.User;

/**
 * Created by Dan on 4/9/17.
 */

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<User> mUsers;
    public UserRecyclerAdapter(List<User> mUserList) {
        mUsers = mUserList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        View mView = mInflater.inflate(R.layout.view_user, parent, false);
        UserViewHolder mHolder = new UserViewHolder(mView);
        return mHolder;
    }


    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bindUser(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public void setUsers(List<User> mPUsers) {
        mUsers = mPUsers;
        notifyDataSetChanged();
    }
}
