package com.example.peomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddPeom extends AppCompatActivity {

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
        // ToDO:: implements
        return false;
    }
}
