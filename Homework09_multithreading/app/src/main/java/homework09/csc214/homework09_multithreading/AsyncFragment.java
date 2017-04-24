package homework09.csc214.homework09_multithreading;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class AsyncFragment extends Fragment {


    public AsyncFragment() {
        // Required empty public constructor
    }

    public static AsyncFragment newInstance() {
        return new AsyncFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_async, container, false);
    }

}
