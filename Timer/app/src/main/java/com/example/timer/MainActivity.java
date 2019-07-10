package com.example.timer;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2;
    int time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String temp = "Its going to rain in "+ time;
                tv1.setText(temp);
                time++;
                handler.postDelayed(this, 1000);
            }
        };

        handler.post(runnable);


        new CountDownTimer(100000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String temp = "Rocket launches in " + String.valueOf(millisUntilFinished/1000) + "seconds";
                tv2.setText(temp);
            }

            @Override
            public void onFinish() {

            }
        }.start();


    }
}
