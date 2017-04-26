package homework09.csc214.homework09_multithreading;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final int RC_PRIME = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startPrimeActivity(View view) {
        Intent mIntent = new Intent(MainActivity.this, PrimeActivity.class);
        startActivity(mIntent);
    }

    public void startHandlerActivity(View view) {
        Intent mIntent = new Intent(MainActivity.this, HandlerActivity.class);
        startActivity(mIntent);
    }

    public void startHTTPActivity(View view) {
        Intent mIntent = new Intent(MainActivity.this, HTTPActivity.class);
        startActivity(mIntent);
    }
}
