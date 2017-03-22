package assignment05.csc214.homework5_fragments2;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Dan on 3/20/17.
 */

public class FragmentLifecycleLogger extends Fragment {
    //I think the value of this TAG string will be: FragmentLifecycleLogger
    protected final String TAG = getClass().getName();

    @Override
    public void onAttach(Activity activity) {
        Log.i(TAG, "onAttach(activity) called");
        super.onAttach(activity);
    }

    @Override
    public void onAttach(Context context) {
        Log.i(TAG, "onAttach(context) called");
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate called");
        super.onCreate(savedInstanceState);
    }

//    @Override
//    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        Log.i(TAG, "onCreateView called");
//        return super.onCreateView(inflater, container, savedInstanceState);
//    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView called");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i(TAG, "onStart called");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(TAG, "onResume called");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i(TAG, "onPause called");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG, "onStop called");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, "onDestroyView called");
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        Log.i(TAG, "onDetach called");
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy called");
        super.onDestroy();
    }

}
