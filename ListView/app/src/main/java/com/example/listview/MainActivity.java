package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    EditText editText;
    Button submit;
    final ArrayList<String> arraylist = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.listview);
        editText = findViewById(R.id.editText);
        submit = findViewById(R.id.submit);
        arraylist.add("Monica");
        arraylist.add("Rachel");
        arraylist.add("Chandler");
        arraylist.add("Pheobe");
        arraylist.add("Joey");
        arraylist.add("Ross");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arraylist);
        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), arraylist.get(position)+"has left", Toast.LENGTH_LONG).show();
                arraylist.remove(position);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arraylist.add(String.valueOf(editText.getText()));
                arrayAdapter.notifyDataSetChanged();
            }
        });

    }

}
