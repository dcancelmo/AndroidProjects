package layout;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import aproject02.csc214.project2_network.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HeaderFragment extends Fragment {


    ImageButton mHomeButton;
    ImageButton mNewPostButton;

    public HeaderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mHomeButton = (ImageButton) container.findViewById(R.id.home_button);
        mHomeButton.setImageResource(R.mipmap.ic_home);
        mNewPostButton = (ImageButton) container.findViewById(R.id.new_post_button);
        mNewPostButton.setImageResource(R.mipmap.ic_new_post);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_header, container, false);
    }

}
