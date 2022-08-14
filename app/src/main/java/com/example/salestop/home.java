package com.example.salestop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView friends = findViewById(R.id.friends);
        ListView list = findViewById(R.id.list);

        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> alist = new ArrayList<>();
                ArrayAdapter adapter = new ArrayAdapter<String>(home.this,R.layout.item,alist);
                list.setAdapter(adapter);

                FirebaseDatabase.getInstance().getReference().child("datauser").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists())
                        {
                            alist.clear();
                            for(DataSnapshot snapshot1 : snapshot.getChildren()){
                            StoringData data = snapshot1.getValue(StoringData.class);
                               String temp  = data.getFname()+" "+data.getLname();
                               alist.add(temp);
                            }
                             adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}