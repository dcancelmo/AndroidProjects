package project3.csc214.project3_final.recyclerViews;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import project3.csc214.project3_final.R;
import project3.csc214.project3_final.model.InfoItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class URRecyclerFragment extends Fragment {

    private static final String TAG = "Cancelmo_Debug_3";

    private RecyclerView mRecyclerView;
    private ArrayList<InfoItem> mItemList;


    public URRecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_urrecycler, container, false);

        mItemList = new ArrayList<>();
        mItemList.add(new InfoItem("University of Rochester", "500 Joseph C. Wilson Blvd, Rochester, NY, 14611", "(585) 275-2121", "24/7", "Founded in 1850. Motto: Meliora - Ever Better. Research institution."));
        mItemList.add(new InfoItem("Public Safety / MERT", "", "(585) 275-3333", "24/7", "Emergency response within the University. For anything you would call 911 for, call here instead."));
        mItemList.add(new InfoItem("Kendrick House", "975 Hill Court Road", "", "24/7", "Phase (Hill Court) residence hall with suite style living. Houses the Phi Sigma Sigma and the Sigma Nu floors."));
        mItemList.add(new InfoItem("Munro House", "974 Hill Court Road", "", "24/7", "Phase (Hill Court) residence hall with suite style living. Houses the Phi Kappa Tau and Alpha Phi floors."));
        mItemList.add(new InfoItem("Wilder Tower", "810 Wilson Blvd", "", "24/7", "Towers (Jackson Court) residence hall. Suite style and double living. Houses several special interest floors."));
        mItemList.add(new InfoItem("Hillside", "See Susan B. Anthony Hall", "", "M-W 9AM-1AM, R-F 9AM-3AM, S 12PM-3AM, U 12PM-1AM", "Located in Susan B Anthony Hall. Sells snacks, basic food ingredients, and other essentials."));
        mItemList.add(new InfoItem("Danforth Dining Hall", "See Susan B. Anthony Hall", "", "M-R 11AM-1:30AM & 5PM-7PM, F 11AM-1:30PM", "Located in Susan B Anthony Hall. Station style unlimited eating. Accepts swipes."));
        mItemList.add(new InfoItem("Susan B. Anthony Hall", "740 Library Road", "", "24/7", "Freshman residence hall nicknamed \"Sue B\". Building also has Hillside and Danforth Dining Hall. A tunnel connects Sue B to Spurrier Hall."));
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.UR_recycler_view_frag);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ItemRecyclerAdapter mAdapter = new ItemRecyclerAdapter(mItemList);
        mRecyclerView.setAdapter(mAdapter);
        return mView;
    }

}
