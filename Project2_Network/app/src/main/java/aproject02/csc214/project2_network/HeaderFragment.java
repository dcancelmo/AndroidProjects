package aproject02.csc214.project2_network;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class HeaderFragment extends Fragment {

    private static String sEmail;

    private static final String TAG = "cancelmo_network_test";
    private static final String KEY_EMAIL = "aproject02.csc214.project2_network.email";

    public interface HeaderButtonListener {
        public void homeButtonPressed();
        public void selfPostButtonPressed(View v);
        public void ownProfileButtonPressed();
        public void userListButtonPressed();
    }
    private HeaderButtonListener mChangeListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mChangeListener = (HeaderButtonListener) context;
    }

    public void onHomeButtonPressed(View view) {
        mChangeListener.homeButtonPressed();
    }

    public void onSelfPostButtonPressed(View view) {
        mChangeListener.selfPostButtonPressed(view);

//        AppCompatActivity mContext = (AppCompatActivity) view.getContext();
//        FragmentManager mFragManager = mContext.getFragmentManager();
//        WritePostDialogFragment mDialog = WritePostDialogFragment.newInstance(sEmail);
//        mDialog.show(mFragManager, "NewPost Dialog");
    }

    public void onOwnProfileButtonPressed(View view) {
        mChangeListener.ownProfileButtonPressed();
    }
    public void onUserListButtonPressed(View view) {
        mChangeListener.userListButtonPressed();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mView = inflater.inflate(R.layout.fragment_header, container, false);

        Bundle mArgs = getArguments();
        sEmail = mArgs.getString(KEY_EMAIL);

        ImageButton mHomeButton = (ImageButton) mView.findViewById(R.id.home_button);
        ImageButton mNewPostButton = (ImageButton) mView.findViewById(R.id.new_post_button);
        ImageButton mOwnProfileButton = (ImageButton) mView.findViewById(R.id.see_own_profile);
        ImageButton mUserListButton = (ImageButton) mView.findViewById(R.id.see_user_list);

        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Home button clicked");
                onHomeButtonPressed(v);
            }
        });
        mNewPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSelfPostButtonPressed(v);
            }
        });
        mOwnProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOwnProfileButtonPressed(v);
            }
        });
        mUserListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onUserListButtonPressed(v);
            }
        });

        return mView;
    }


}
