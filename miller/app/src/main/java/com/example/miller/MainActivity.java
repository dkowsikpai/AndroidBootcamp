package com.example.miller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convert(View view) {
        et = findViewById(R.id.editText);
        String data = toString().valueOf(et.getText());
        Double wt = Double.parseDouble(data) * 1.33;
        Toast.makeText(getApplicationContext(), "Weight on miller's planet is: "+toString().valueOf(wt), Toast.LENGTH_LONG).show();
        Intent i = new Intent(MainActivity.this, second.class);
        startActivity(i);

    }
}
