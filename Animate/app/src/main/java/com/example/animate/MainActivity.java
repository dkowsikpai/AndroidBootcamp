package com.example.animate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    boolean showbart = true;
    ImageView bart, homer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bart = findViewById(R.id.bart);
        homer = findViewById(R.id.homer);

        bart.setTranslationX(-1000f);
        bart.setTranslationY(-1000f);
        bart.setScaleX(0.5f);
        bart.setScaleY(0.5f);
    }


    public void fadebt(View view) {
        if (showbart){
            bart.animate().alpha(0f).setDuration(2000);//2000 ms
            homer.animate().alpha(1f).setDuration(2000);
            showbart = false;
        }else{
            homer.animate().alpha(0f). setDuration(2000);
            bart.animate().alpha(1f).setDuration(2000);
            showbart = true;
        }
    }

    public void trans_bart(View view) {
        //bart.animate().rotationX(360f).rotationY(360f).setDuration(2000);
        // homer.animate().alpha(0f).setDuration(2000);
        bart.animate()
                .translationXBy(1000f)
                .translationYBy(1000f)
                .rotation(360f)
                .scaleX(1)
                .scaleY(1)
                .setDuration(2000);
        homer.animate().alpha(0).setDuration(2000);
    }
}
