package mobappdev.demo.finalexam.problem2;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mobappdev.demo.finalexam.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProblemTwoTopFragment extends Fragment {

    private static final String TAG = "LogLifecylceProb2";

    TextView mTopTextView;
    String mTopString;

    public ProblemTwoTopFragment() {
        // Required empty public constructor
    }

    public void setTextView(String mTopString) {
        this.mTopString = mTopString;
        mTopTextView.setText(mTopString);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_problem_two_top, container, false);
        Log.i(TAG, "onCreateView(LayoutInflater, ViewGroup, Bundle) called");
        mTopTextView = (TextView) mView.findViewById(R.id.tv_response);
        return mView;
    }



    @Override
    public void onAttach(Activity activity) {
        Log.i(TAG, "onAttach(Activity) called");
        super.onAttach(activity);
    }

    @Override
    public void onAttach(Context context) {
        Log.i(TAG, "onAttach(Context) called");
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate(Bundle) called");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView(Bundle) called");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i(TAG, "onStart() called");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(TAG, "onResume() called");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i(TAG, "onPause() called");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG, "onStop() called");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, "onDestroyView() called");
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        Log.i(TAG, "onDetach() called");
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy() called");
        super.onDestroy();
    }

}
