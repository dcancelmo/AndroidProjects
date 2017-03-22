package assignment05.csc214.homework5_fragments2;


import android.app.Activity;
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
public class TopFragment extends FragmentLifecycleLogger {

    private static final String KEY_MESSAGE = "assignment05.csc214.homework5_fragments2.message";

    public interface MessageChangedListener {
        public void messageChanged(CharSequence message);
    }
    private MessageChangedListener mChangeListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mChangeListener = (MessageChangedListener)activity;
    }



    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView called (Top)");
        View view = inflater.inflate(R.layout.fragment_top, container, false);
        Bundle args = getArguments();
        TextView mDisplayMessage = (TextView) view.findViewById(R.id.top_message_display);
        if (args != null) {
            String mMessage = args.getString(KEY_MESSAGE);
            mDisplayMessage.setText(mMessage);
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top, container, false);
    }


}
