package project3.csc214.project3_final;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import project3.csc214.project3_final.database.CustomEntryDb;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomItemFragment extends Fragment {

    public CustomItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_custom_item, container, false);
    }

}
