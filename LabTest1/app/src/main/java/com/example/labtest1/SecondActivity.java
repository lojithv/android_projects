package com.example.labtest1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SecondActivity extends AppCompatActivity {

    ListView l;
    String colors[]
            = { "Blue", "Red", "Green" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.colors_list_view, colors);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String color = colors[position];
                changeBackgroundColor(color);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void changeBackgroundColor(String color){
        switch(color) {
            case "Blue":
                setBackgroundColor(Color.BLUE);
                break;
            case "Red":
                setBackgroundColor(Color.RED);
                break;
            case "Green":
                setBackgroundColor(Color.GREEN);
                break;
            default:
        }
    }

    void setBackgroundColor(int colorCode){
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(colorCode);
    }
}