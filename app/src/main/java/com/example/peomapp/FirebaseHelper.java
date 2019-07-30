package com.example.peomapp;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseHelper {

    private FirebaseDatabase database;
    private DatabaseReference reference;

    FirebaseHelper() {
        this.database = FirebaseDatabase.getInstance();
        this.reference = database.getReference("Poems");
    }

    interface DataStatus {
        public void DataIsInserted(Poem poem, String key);

        public void DataIsLoaded(List<Poem> poems, List<String> keys);

        public void DataIsUpdated(Poem poem, String key);

        public void DataIsUpdated();
    }

    public void readData(final DataStatus dataStatus) {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Poem> poems = new ArrayList<>();
                List<String> keys = new ArrayList<>();

                for (DataSnapshot node : dataSnapshot.getChildren()) {
                    poems.add(node.getValue(Poem.class));
                    keys.add(node.getKey());
                }
                dataStatus.DataIsLoaded(poems, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void writeData(Poem poem, DataStatus dataStatus) {
        String id = reference.push().getKey();
        if (id == null) {
            throw new DatabaseException("Ref Key Could not found");
        }
        reference.child(id).setValue(poem);
        dataStatus.DataIsInserted(poem, id);
    }
}
