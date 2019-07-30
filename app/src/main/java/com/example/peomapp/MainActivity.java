package com.example.peomapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new FirebaseHelper().readData(new FirebaseHelper.DataStatus() {
            @Override
            public void DataIsInserted(Poem poem, String key) {

            }

            @Override
            public void DataIsLoaded(List<Poem> poems, List<String> keys) {
                new RecyclerView_Config().setConfig(poems, keys, getApplicationContext());

            }

            @Override
            public void DataIsUpdated(Poem poem, String key) {

            }

            @Override
            public void DataIsUpdated() {

            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton addPoem = findViewById(R.id.addPeom);

        addPoem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addPoemIntent = new Intent(getApplicationContext(), AddPoemActivity.class);
                startActivity(addPoemIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
