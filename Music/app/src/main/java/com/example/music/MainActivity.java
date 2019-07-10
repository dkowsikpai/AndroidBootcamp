package com.example.music;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    SeekBar vol, seek;
    MediaPlayer playmusic = new MediaPlayer();
    MediaPlayer onlinemusic = new MediaPlayer();
    String url = "https://producaodavoz.com.br/provoz/Servidor/Midias/Musicas/Pop%20Internacional/Kodaline%20-%20All%20i%20want.mp3\n";
    AudioManager audiomanager;
    Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vol = findViewById(R.id.vol);
        seek = findViewById(R.id.seek);
        playmusic = MediaPlayer.create(this, R.raw.sampleaudio);

        // Online Music Set the users-permission in the Manifest to access Internet
        try {
            onlinemusic.setDataSource(url);
            onlinemusic.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Audio Manager
        audiomanager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int maxvol = audiomanager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curvol = audiomanager.getStreamVolume(AudioManager.STREAM_MUSIC);

        vol.setMax(maxvol);
        vol.setProgress(curvol);

        vol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(getApplicationContext(), String.valueOf(progress), Toast.LENGTH_LONG).show();
                audiomanager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        onlinemusic.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Toast.makeText(getApplicationContext(), "Media is ready", Toast.LENGTH_LONG).show();
                seek.setMax(onlinemusic.getDuration());
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        seek.setProgress(onlinemusic.getCurrentPosition());
                    }
                },0, 1000);
            }

        });

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    onlinemusic.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void play1(View view) {
        playmusic.start();
    }

    public void pause1(View view) {
        playmusic.pause();
    }

    public void stop1(View view) {
        playmusic.stop();
    }

    public void play2(View view) {
        onlinemusic.start();
    }

    public void pause2(View view) {
        onlinemusic.pause();
    }

    public void stop2(View view) {
        onlinemusic.stop();
    }
}
