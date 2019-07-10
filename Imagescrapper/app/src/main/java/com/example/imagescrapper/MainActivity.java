package com.example.imagescrapper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button bt;
    ImageView imageView;
    List<String> list = new ArrayList<String>();

    public class DataDownloadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection)url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while (data != -1){
                    char current = (char) data;
                    result = result + current;
                    data = reader.read();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }
    }

    public class ImageDownloadTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... urls) {

            URL url;
            HttpURLConnection urlConnection = null;
            Bitmap bitmap = null;

            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection)url.openConnection();
                urlConnection.connect();
                InputStream in = urlConnection.getInputStream();
                bitmap = BitmapFactory.decodeStream(in);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        DataDownloadTask task = new DataDownloadTask();
        String result = "";
        try {
            result = task.execute("https://ktu.edu.in/home.htm;jsessionid=9763C494BDB45397AC8212DCAF128648.KTUApp1").get();
            Pattern p = Pattern.compile("<li>\n" + "                        <img src=\"(.*?)\" />");
            Matcher m = p.matcher(result);
            Log.i("resultsc", result);
            while(m.find()){
                Log.i("urlgot", m.group(1));
                String temp = "https://ktu.edu.in/" + m.group(1);
                list.add(temp);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void load_data(View view) {
        int l = list.size();
        Random r = new Random();
        int i = r.nextInt(l);
        ImageDownloadTask imgtask = new ImageDownloadTask();
        try {
            Bitmap res = imgtask.execute(list.get(i)).get();
            imageView.setImageBitmap(res);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
