package com.example.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user, passw;
    String username = "Abc", password="1234";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {
        user = findViewById(R.id.useret);
        passw = findViewById(R.id.passet);
        Log.i("username:", toString().valueOf(user.getText()));
        Log.i("password", toString().valueOf(passw.getText()));
        if (username.equals(toString().valueOf(user.getText())) && password.equals(toString().valueOf(passw.getText()))){
            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "Wrong Credential", Toast.LENGTH_LONG).show();
        }



    }
}
