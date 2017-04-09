package aproject02.csc214.project2_network.recyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import aproject02.csc214.project2_network.R;
import aproject02.csc214.project2_network.model.User;

/**
 * Created by Dan on 4/9/17.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {
    private TextView mUserView;
    private User mUser;

    public UserViewHolder(View mView) {
        super(mView);
        mUserView = (TextView) mView.findViewById(R.id.user_list_text_view);
    }

    public void bindCourse(User mPUser) {
        mUser = mPUser;
        mUserView.setText(mUser.toString());
    }
}
