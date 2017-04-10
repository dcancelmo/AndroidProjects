package aproject02.csc214.project2_network.recyclerView;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import aproject02.csc214.project2_network.HeaderFragment;
import aproject02.csc214.project2_network.R;
import aproject02.csc214.project2_network.ViewProfileActivity;
import aproject02.csc214.project2_network.WritePostActivity;
import aproject02.csc214.project2_network.database.NetworkDb;
import aproject02.csc214.project2_network.model.User;

/**
 * Created by Dan on 4/9/17.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {

    private static final String KEY_EMAIL = "aproject02.csc214.project2_network.email";
    private static final String KEY_VIEW_EMAIL = "aproject02.csc214.project2_network.view_email";
    private String sViewEmail;
    private String sEmail;

    private TextView mUserView;
    private User mUser;


    public UserViewHolder(final View mView) {
        super(mView);
        mUserView = (TextView) mView.findViewById(R.id.user_list_text_view);
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View mInnerView) {
                sViewEmail = mUser.getEmail();
                Intent intent = new Intent(mInnerView.getContext(), ViewProfileActivity.class);
                intent.putExtra(KEY_VIEW_EMAIL, sViewEmail);
                intent.putExtra(KEY_EMAIL, sEmail);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                mInnerView.getContext().startActivity(intent);
            }
        });
    }

    public void bindUser(User mPUser) {
        mUser = mPUser;
        mUserView.setText(mUser.toString());
    }

}
