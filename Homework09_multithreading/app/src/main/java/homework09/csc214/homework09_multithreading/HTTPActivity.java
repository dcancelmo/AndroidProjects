package homework09.csc214.homework09_multithreading;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

public class HTTPActivity extends AppCompatActivity {

    public static final String TAG = "CANCELMOTESTING";

    EditText mURLInput;
    ImageView mImageDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        mURLInput = (EditText) findViewById(R.id.url_entry);
        mImageDisplay = (ImageView) findViewById(R.id.image_display);
        mImageDisplay.setImageResource(R.drawable.bread_lol);
    }

    public void fetchImage(View view) {
        Log.i(TAG, "fetchImage called");
//        try {
//            //InputStream mStream = (InputStream) new URL(mURLInput.getText().toString()).getContent();
//            //Drawable mDrawable = Drawable.createFromStream(mStream, "src");
//            //mImageDisplay.setImageDrawable(mDrawable);
//            Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(mURLInput.getText().toString()).getContent());
//            mImageDisplay.setImageBitmap(bitmap);
//            Log.i(TAG, "fetchImage successful with URL: " + mURLInput.getText().toString());
//        } catch (Exception e) {
//            Log.i(TAG, "fetchImage failed");
//            Toast.makeText(this, getString(R.string.invalid_url), Toast.LENGTH_LONG).show();
//            return;
//        }
        new DownloadTask().execute(mURLInput.getText().toString());
    }
    private class DownloadTask extends AsyncTask<String, Void, Bitmap> {
        public DownloadTask() {}

        protected Bitmap doInBackground(String... url) {
            String mURL = url[0];
            Bitmap mBitImage = null;
            try {
                InputStream mStream = new java.net.URL(mURL).openStream();
                mBitImage = BitmapFactory.decodeStream(mStream);
            } catch (Exception e) {
                Log.i(TAG, "Invalid URL");
            }
            return mBitImage;
        }

        protected void onPostExecute(Bitmap result) {
            mImageDisplay.setImageBitmap(result);
        }
    }
}
