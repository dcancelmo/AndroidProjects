package project01.csc214.project01_simplegames;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {

    private static final String TAG = "DANIEL_TAG";
    private static final String KEY_USER1 = "project01.csc214.project01_simplegames.username1";
    private static final String KEY_USER2 = "project01.csc214.project01_simplegames.username2";

    private static String sUser1;
    private static String sUser2;

    public ScoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_score, container, false);
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        state.putString(KEY_USER1, sUser1);
        state.putString(KEY_USER2, sUser2);
    }

}
