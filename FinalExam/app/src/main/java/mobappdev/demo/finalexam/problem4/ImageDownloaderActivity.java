package mobappdev.demo.finalexam.problem4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;

import mobappdev.demo.finalexam.R;

public class ImageDownloaderActivity extends AppCompatActivity {
    private static final String TAG = "ImgDler";
    protected ImageView mImageView;

    //http://images3.wikia.nocookie.net/__cb20120128045061/thehungergames/images/6/67/Bread.jpg
    private static final String IMAGE_URL_STRING = "http://images3.wikia.nocookie.net/__cb20120128045061/thehungergames/images/6/67/Bread.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_downloader);
        mImageView = (ImageView) findViewById(R.id.iv_image);
    }

    public void downloadPressed(View view) {
        new ImageFetchTask().execute(IMAGE_URL_STRING);
    }

    private class ImageFetchTask extends AsyncTask<String, Void, Bitmap> {

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

            mImageView.setImageBitmap(result);
        }
    }


    // use this method to scale the image
    private Bitmap getScaledBitmap(String path) {
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);

        return getScaledBitmap(path, size.x, size.y);
    }

    private static Bitmap getScaledBitmap(String path, int width, int height) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        Log.d(TAG, "requested width=" + width + "," + "requested height=" + height);
        Log.d(TAG, "srcWidth=" + srcWidth + "," + "srcHeight=" + srcHeight);

        int sampleSize = 1;
        if(srcHeight > height || srcWidth > width ) {
            if(srcWidth > srcHeight) {
                sampleSize = Math.round(srcHeight / height);
            }
            else {
                sampleSize = Math.round(srcWidth / width);
            }
        }

        Log.d(TAG, "sampleSize=" + sampleSize);

        BitmapFactory.Options scaledOptions = new BitmapFactory.Options();
        scaledOptions.inSampleSize = sampleSize;

        //return BitmapFactory.decodeFile(path, scaledOptions);
        return BitmapFactory.decodeFile(path);
    }
}
