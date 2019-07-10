package com.example.luck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int rnum;
    EditText et;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Random rand = new Random();
        rnum = rand.nextInt(6) + 1;
    }

    public void guess(View view) {
//        if (view.getId() == R.id.editText) {
            et = findViewById(R.id.editText);
            iv = findViewById(R.id.imageView);
            int userinput = Integer.valueOf(toString().valueOf(et.getText()));
            if (userinput == rnum) {
                Toast.makeText(getApplicationContext(), "Congrats !!! You guessed it right", Toast.LENGTH_LONG).show();
                iv.setImageResource(R.drawable.soulmate);
            } else {
                Toast.makeText(getApplicationContext(), "Better Luck Next Time", Toast.LENGTH_LONG).show();
                iv.setImageResource(R.drawable.milesaway);
            }
//        }
    }
}
