package assignment03.csc214.logginglifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoggingLifecycleActivity extends AppCompatActivity {

    private static final String TAG = "Daniel Tag";
    public static final String KEY_IMAGE = "assignment3.csc214.logginglifecylce.image";
    public static final String KEY_ROTATIONS = "assignment3.csc214.logginglifecylce.rotations";

    private boolean mOceanView = true;
    private int mRotations = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logging_lifecycle);
        Log.i(TAG, "onCreate(Bundle bundle) called");
        if (savedInstanceState != null) {
            mOceanView = savedInstanceState.getBoolean(KEY_IMAGE);
            mRotations = savedInstanceState.getInt(KEY_ROTATIONS);
        }
        mRotations = mRotations + 1;
        TextView mTravelOptionTextView = (TextView) findViewById(R.id.travel_option_text_view);
        mTravelOptionTextView.setText("Device rotated " + mRotations + " times.");

        ImageView mTravelImageView = (ImageView) findViewById(R.id.travel_image_view);
        if (mOceanView) {
            mTravelImageView.setImageResource(R.drawable.ic_venice);
            mOceanView = false;
        } else {
            mTravelImageView.setImageResource(R.drawable.ic_ocean);
            mOceanView = true;
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(KEY_IMAGE, mOceanView);
        bundle.putInt(KEY_ROTATIONS, mRotations);
    }

    public void imageCycle(View view) {
        ImageView mTravelImageView = (ImageView) findViewById(R.id.travel_image_view);
        if (mOceanView) {
            mTravelImageView.setImageResource(R.drawable.ic_venice);
            mOceanView = false;
        } else {
            mTravelImageView.setImageResource(R.drawable.ic_ocean);
            mOceanView = true;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy() called");
    }

}
