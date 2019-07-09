package com.pity.carousels_toolbox.views;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pity.carousels_toolbox.R;

public class VideoPlayerView extends AppCompatActivity {

    private VideoView videoView;
    private ProgressBar progressBar;
    private Uri urlVideo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_video_player);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getSupportActionBar().hide();

        progressBar = findViewById(R.id.progress_bar);
        videoView = findViewById(R.id.video_view);

        urlVideo = getIntent().getData();


        MediaController controller = new MediaController(this);
        videoView.setVideoURI(urlVideo);
        videoView.setMediaController(controller);
        controller.setAnchorView(videoView);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp)  {
                progressBar.setVisibility(View.GONE);
                if (mp.isPlaying()) videoView.start();
            }
        });
    }
}
