package homework08.csc214.homework8_sounds;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager mFragManager = getSupportFragmentManager();

        TrackListFragment mFragment = (TrackListFragment) mFragManager.findFragmentById(R.id.frame_layout_main);
        if(mFragment == null) {
            mFragment = new TrackListFragment();
            mFragManager.beginTransaction().add(R.id.frame_layout_main, mFragment).commit();
        }
    }
}
