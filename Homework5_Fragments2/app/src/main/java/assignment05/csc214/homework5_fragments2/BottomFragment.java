package assignment05.csc214.homework5_fragments2;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragment extends FragmentLifecycleLogger {

    private TextView mBottomTextView;

    public BottomFragment() {
        // Required empty public constructor
    }

    public void messageSentBack(CharSequence message) {
        mBottomTextView.setText(message);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView called (Bottom)");
        View view = inflater.inflate(R.layout.fragment_bottom, container, false);
        mBottomTextView = (TextView) view.findViewById(R.id.bottom_message_display);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom, container, false);
    }

}
