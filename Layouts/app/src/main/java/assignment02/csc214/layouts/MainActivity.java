package assignment02.csc214.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static int sTextViewValue = 100;
    private static final String TAG = "Cancelmo";

    public int getSTextViewValue() {
        return sTextViewValue;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mDevNameButton = (Button) findViewById(R.id.dev_name);
        mDevNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.cancelmo, Toast.LENGTH_SHORT).show();
                Log.i(TAG, "mDevNameButton clicked");
            }
        });
        Button mTANameButton = (Button) findViewById(R.id.ta_name);
        mTANameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.beadle, Toast.LENGTH_SHORT).show();
                Log.i(TAG, "mTANameButton clicked");
            }
        });
        final TextView mDecrementText = (TextView) findViewById(R.id.value);

        Button mDecrementButton = (Button) findViewById(R.id.decrement);
        mDecrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sTextViewValue = sTextViewValue - 1;
                mDecrementText.setText(String.valueOf(getSTextViewValue()));
                Log.i(TAG, "Value decremented 1");
            }
        });
        mDecrementText.setText(String.valueOf(getSTextViewValue()));



    }
}
