package aproject02.csc214.project2_network.recyclerView;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import aproject02.csc214.project2_network.R;
import aproject02.csc214.project2_network.ViewProfileActivity;
import aproject02.csc214.project2_network.model.Post;
import aproject02.csc214.project2_network.model.User;

/**
 * Created by Dan on 4/9/17.
 */

public class PostViewHolder extends RecyclerView.ViewHolder  {

    private static final String KEY_EMAIL = "aproject02.csc214.project2_network.email";
    private static final String KEY_VIEW_EMAIL = "aproject02.csc214.project2_network.view_email";

    private TextView mPostView;
    private ImageView mPostImage;
    private Post mPost;


    public PostViewHolder(final View mView) {
        super(mView);
        mPostView = (TextView) mView.findViewById(R.id.post_list_text_view);
        mPostImage = (ImageView) mView.findViewById(R.id.post_list_image_view);
    }

    public void bindPost(Post mPPost) {
        mPost = mPPost;
        mPostView.setText(mPPost.toString());
        //TODO link up images
    }
}
