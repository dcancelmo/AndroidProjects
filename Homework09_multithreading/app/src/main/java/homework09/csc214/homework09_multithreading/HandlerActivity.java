package homework09.csc214.homework09_multithreading;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HandlerActivity extends AppCompatActivity {

    public static final String TAG = "CANCELMOTESTING";

    private SqrtHandlerThread mSqrtHandler;
    EditText mLongEntry;
    TextView mAnswerDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        mLongEntry = (EditText) findViewById(R.id.long_entry);
        mAnswerDisplay = (TextView) findViewById(R.id.answer_display);
    }

    public void startFindLargePrime(View view) {
        String mTemp = mLongEntry.getText().toString();
        double mNum = Integer.parseInt(mTemp);
        final long mOriginal;
        if (mNum >= 2) {
            mOriginal = Long.parseLong(mTemp);
            mWorkerThread = new SqrtHandlerThread("myWorkerThread");
            Runnable task = new Runnable() {
                public void run(){
                    mUiHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            for(long i = mOriginal; i >= 2; i--){
                                if(isPrime(i)){
                                    mAnswerDisplay.setText(Long.toString(i));
                                    break;
                                }
                            }
                            if(mOriginal == 2){
                                mAnswerDisplay.setText(Long.toString(mOriginal));
                            }
                        }
                    });
                }
            };
            mWorkerThread.start();
            mWorkerThread.prepareHandler();
            mWorkerThread.postTask(task);
            mWorkerThread.postTask(task);
        } else {
            Toast.makeText(getBaseContext(), getResources().getString(R.string.value_greater_than_equal_2), Toast.LENGTH_LONG).show();
        }
    }

    public void startFindSquareRoot(View view) {
        String mTemp = mLongEntry.getText().toString();
        double mNum = Integer.parseInt(mTemp);
        long mOriginal = Long.valueOf(mTemp);
        if (mNum >= 2) {
            mOriginal = Long.parseLong(mTemp);
            mWorkerThread = new SqrtHandlerThread("myWorkerThread");
            Runnable task = new Runnable() {
                public void run(){
                    mUiHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            double longer = Math.sqrt(mOriginal);
                            mAnswerDisplay.setText(Double.toString(longer));
                        }
                    });
                }
            };
            mWorkerThread.start();
            mWorkerThread.prepareHandler();
            mWorkerThread.postTask(task);
            mWorkerThread.postTask(task);
        } else {
            Toast.makeText(getBaseContext(), getResources().getString(R.string.value_greater_than_equal_2), Toast.LENGTH_LONG).show();
        }
    }

    public boolean isPrime(long mValue) {
        for (long i = 2; i < mValue; i++) {
            if (mValue % i == 0) {
                Log.i(TAG, i + " not prime");
                return false; //not prime
            }
        }
        return true; //prime
    }

    public class SqrtHandlerThread extends HandlerThread {

        private Handler mWorkerHandler;

        public SqrtHandlerThread(String name) {
            super(name);
        }

        public void postTask(Runnable task) {
            mWorkerHandler.post(task);
        }

        public void prepareHandler() {
            mWorkerHandler = new Handler(getLooper());
        }
    }
}
