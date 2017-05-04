package project3.csc214.project3_final;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends SupportMapFragment {

    private GoogleMap mMap;
    private GoogleApiClient mClient;

    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
            }
        });
    }

    public void updateLocation(double mLat, double mLon) {
        if(mMap != null) {
            LatLng mLocation = new LatLng(mLat, mLon);
            MarkerOptions locationMarker = new MarkerOptions().position(mLocation);
            mMap.clear();
            mMap.addMarker(locationMarker);
            CameraUpdate mUpdate = CameraUpdateFactory.newLatLngZoom(mLocation, 10.0f);
            mMap.animateCamera(mUpdate);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_map, container, false);
        return mView;
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        mClient.connect();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        mClient.disconnect();
//    }

}
