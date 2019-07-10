package com.example.basicphraser;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3, b4, b5, b6, b7, b8;
    MediaPlayer mediaPlayer = new MediaPlayer();
    AudioManager audioManager;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int maxvol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curvol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(maxvol);
        seekBar.setProgress(curvol);

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);


        View.OnClickListener btn_clicked = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int url=0;
                switch (v.getId()){
                    case R.id.button1: url= R.raw.doyouspeakenglish;break;
                    case R.id.button2: url= R.raw.goodevening;break;
                    case R.id.button3: url= R.raw.hello;break;
                    case R.id.button4: url= R.raw.howareyou;break;
                    case R.id.button5: url= R.raw.ilivein;break;
                    case R.id.button6: url= R.raw.mynameis;break;
                    case R.id.button7: url= R.raw.please;break;
                    case R.id.button8: url= R.raw.welcome;break;
                }
                mediaPlayer = MediaPlayer.create(getApplicationContext(), url);
                mediaPlayer.start();
            }
        };

        b1.setOnClickListener(btn_clicked);
        b2.setOnClickListener(btn_clicked);
        b3.setOnClickListener(btn_clicked);
        b4.setOnClickListener(btn_clicked);
        b5.setOnClickListener(btn_clicked);
        b6.setOnClickListener(btn_clicked);
        b7.setOnClickListener(btn_clicked);
        b8.setOnClickListener(btn_clicked);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(getApplicationContext(), String.valueOf(progress), Toast.LENGTH_LONG).show();
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void stopmusic(View view) {
        mediaPlayer.pause();
    }
}
