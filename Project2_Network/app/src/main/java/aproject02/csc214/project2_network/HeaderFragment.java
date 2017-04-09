package aproject02.csc214.project2_network;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class HeaderFragment extends Fragment {

    private static final String TAG = "cancelmo_network_test";

    public interface HeaderButtonListener {
        public void homeButtonPressed();
        public void selfPostButtonPressed();
        public void ownProfileButtonPressed();
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
        mChangeListener.selfPostButtonPressed();
    }

    public void onOwnProfileButtonPressed(View view) {
        mChangeListener.ownProfileButtonPressed();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mView = inflater.inflate(R.layout.fragment_header, container, false);

        ImageButton mHomeButton = (ImageButton) mView.findViewById(R.id.home_button);
        ImageButton mNewPostButton = (ImageButton) mView.findViewById(R.id.new_post_button);
        ImageButton mOwnProfileButton = (ImageButton) mView.findViewById(R.id.see_own_profile);

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

        return mView;
    }


}
