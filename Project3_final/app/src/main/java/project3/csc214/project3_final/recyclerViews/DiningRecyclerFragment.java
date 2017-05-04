package project3.csc214.project3_final.recyclerViews;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import project3.csc214.project3_final.R;
import project3.csc214.project3_final.model.InfoItem;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiningRecyclerFragment extends Fragment {


    private static final String TAG = "Cancelmo_Debug_3";

    private RecyclerView mRecyclerView;
    private ArrayList<InfoItem> mItemList;


    public DiningRecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_dining_recycler, container, false);

        mItemList = new ArrayList<>();
        try {
            mItemList.add(new InfoItem("DP Dough", "", "(585) 270-8028", new URL("https://dpdough.com/locations/rochester-new-york/"), "U: 11AM-2AM, M-R 11AM-3AM, F-S 11AM-4AM", "They deliver and calzones are their specialty. Best calzones in Rochester, great for late night food"));
            mItemList.add(new InfoItem("Soup Spoon", "1378 Mt Hope Ave, Rochester, NY 14620", "(585) 244-7166", new URL("http://thesoupspoonroom.com/"), "U-M 11AM-3PM, T-R 11AM-9PM, F-S 11Am-10PM", "In CollegeTown next to bus stop. Great Cambodian Soup even for those normally not fond of Asian foods. Great for quick and cheap yet intimate and fun dates."));
            mItemList.add(new InfoItem("Deli Sandro's", "1147 S Plymouth Ave, Rochester, NY 14608", "(585) 328-3354", new URL("http://places.singleplatform.com"), "U 10AM-6PM, M-R 10AM-9PM, F-S 10AM-1:30AM", "Great subs and milkshakes. Close to Riverview and moving even closer soon."));
            mItemList.add(new InfoItem("2Vine", "24 Winthrop St, Rochester, NY 14607", "(585) 454-6020", new URL("http://urbanspoon.com"), "M 5:30PM-10PM, T-R 11:30AM-10PM, F 11:30AM-11PM, S 5:30PM-11PM", "Casual dining, great food and desserts. Short walk from Eastman School of Music"));
            mItemList.add(new InfoItem("Grappa", "30 Celebration Dr, Rochester, NY 14620", "(585) 445-5570", new URL("http://www.grapparoc.com/"), "6AM-11PM every day", "Located in CollegeTown attached to the hotel. Great for dates"));
            mItemList.add(new InfoItem("Calios", "", "(585) 292-9664", new URL("http://www.caliosonline.com/"), "11AM-4AM every day", "Good delivery calzones."));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        mRecyclerView = (RecyclerView) mView.findViewById(R.id.dining_recycler_view_frag);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ItemRecyclerAdapter mAdapter = new ItemRecyclerAdapter(mItemList);
        mRecyclerView.setAdapter(mAdapter);
        return mView;
    }

}
