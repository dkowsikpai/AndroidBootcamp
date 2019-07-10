package com.example.videoview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        VideoView vid = findViewById(R.id.videoView);
        vid.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.devika);
        MediaController media = new MediaController(this);
        media.setAnchorView(vid);
        vid.setMediaController(media);
        vid.start();
    }
}
