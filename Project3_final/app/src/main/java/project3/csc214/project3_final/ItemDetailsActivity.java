package project3.csc214.project3_final;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import project3.csc214.project3_final.recyclerViews.URRecyclerFragment;

import static project3.csc214.project3_final.ItemDetailsFragment.createInstance;

public class ItemDetailsActivity extends AppCompatActivity {

    private static final String TAG = "Cancelmo_Debug_3";

    Fragment mFragment;
    FragmentManager mFragManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        mFragManager = getSupportFragmentManager();
        Intent mIntent = getIntent();
        if (mIntent == null) {
            Toast.makeText(this, getString(R.string.an_error_has_occurred), Toast.LENGTH_LONG).show();
            finish();
        } else {
            mFragment = createInstance(mIntent);
            mFragManager.beginTransaction().add(R.id.details_frame_layout, mFragment).commit();
        }
    }
}
