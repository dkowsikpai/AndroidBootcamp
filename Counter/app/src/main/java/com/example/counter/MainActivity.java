package com.example.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Button b1, b2;
    TextView tv;
    EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        ed = findViewById(R.id.editText);

        tv.setText(toString().valueOf(cnt));
        /*b1 = findViewById(R.id.incre);
        b2 = findViewById(R.id.decre);
        tv = findViewById(R.id.tv);
        tv.setText(toString().valueOf(0));
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Button: ", "Pressed");
                int t = Integer.valueOf(toString().valueOf(tv.getText())) + 1;
                tv.setText(toString().valueOf(t));
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int t = Integer.valueOf(toString().valueOf(tv.getText())) - 1;
                if (t >= 0){
                    tv.setText(toString().valueOf(t));
                } else {
                    tv.setText(toString().valueOf(0));
                }
            }
        });*/
    }
    int cnt = 0;
    public void incr(View view) {
        cnt +=1;
        tv.setText(toString().valueOf(cnt));

    }

    public void decr(View view) {
        cnt -=1;
        if (cnt >= 0)
            tv.setText(toString().valueOf(cnt));
        else {
            tv.setText(toString().valueOf(0));
            cnt = 0;
        }
    }

    public void setdata(View view) {
        String t = toString().valueOf(ed.getText());
        tv.setText(t);
    }
}

