package project3.csc214.project3_final;


import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import project3.csc214.project3_final.sounds.Song;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private static final String TAG = "Cancelmo_Debug_3";

    private MediaPlayer mPlayer;
    private AssetManager mAssets;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);  // audio playback continuity
        mAssets = getActivity().getAssets();
        mPlayer = new MediaPlayer();
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.i(TAG, "Playing The Genesee by the Yellow Jackets.");
                Toast.makeText(getContext(), R.string.playing_genesee, Toast.LENGTH_LONG).show();
                mPlayer.start();
            }
        });
    }

    //Plays the background song
    private void play(Song mSong) {
        try {
            AssetManager mAssets = getActivity().getAssets();
            AssetFileDescriptor afd = mAssets.openFd(mSong.getPath());
            if(mPlayer.isPlaying()) {
                Log.i(TAG, "Stopping");
                mPlayer.stop();
            }
            mPlayer.reset();
            Log.i(TAG, "setDataSource: " + mSong.getName());
            mPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            mPlayer.prepare();
        }
        catch(IOException e) {
            Log.e(TAG, "Error: " + mSong.getPath() + " could not play");
            e.printStackTrace();
        }
    }

    //Ends the background song
    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.release();
        mPlayer = null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setRetainInstance(true);
        View mView = inflater.inflate(R.layout.fragment_main, container, false);

        Song mMusicFound;
        try {
            String[] musicNames = mAssets.list("music");
            String path = "music/" + musicNames[0];
            mMusicFound = new Song(musicNames[0], path);
            play(mMusicFound);
        }
        catch (IOException e) {
            Log.e(TAG, "MediaPlayer interrupted");
            e.printStackTrace();
        }
        return mView;
    }

}
