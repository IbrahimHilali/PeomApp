package com.example.peomapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class AddPoemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_peom);

        FloatingActionButton backMainActivity = findViewById(R.id.backMainActivity);
        FloatingActionButton savePoem = findViewById(R.id.savePoem);

        backMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backMainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(backMainActivityIntent);
            }
        });

        savePoem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (savePoem()) {
                    Toast.makeText(getApplicationContext(), "Thank for writing this Poem", Toast.LENGTH_SHORT)
                            .show();
                    Intent savePoemIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(savePoemIntent);
                }
                ;
                Toast.makeText(getApplicationContext(), "Poem did not saved. Please check your connections", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    private boolean savePoem() {
        final boolean[] success = {false};
        String title = ((TextInputEditText) findViewById(R.id.poemTitle2)).getText().toString();
        String content = ((TextInputEditText) findViewById(R.id.poemBody)).getText().toString();
        Poem poem = new Poem(title, content);
        new FirebaseHelper().writeData(poem, new FirebaseHelper.DataStatus() {
            @Override
            public void DataIsInserted(Poem poem, String key) {
                success[0] = true;
            }

            @Override
            public void DataIsLoaded(List<Poem> poems, List<String> keys) {

            }

            @Override
            public void DataIsUpdated(Poem poem, String key) {

            }

            @Override
            public void DataIsUpdated() {

            }
        });
        return success[0];
    }
}
