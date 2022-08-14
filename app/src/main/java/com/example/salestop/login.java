package com.example.salestop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class login extends AppCompatActivity {
     Button button2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button2 =findViewById(R.id.button2);
        TextView textView10 = findViewById(R.id.textView10);
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user =username.getText().toString();
                String pass =password.getText().toString();
                if(!user.isEmpty()){

                    if(!pass.isEmpty()){

                      final  String user_Data =username.getText().toString();
                      final  String pass_Data=password.getText().toString();
                        FirebaseDatabase fd = FirebaseDatabase.getInstance();
                        DatabaseReference dr = fd.getReference("datauser");

                        Query check_user = dr.orderByChild("name1").equalTo(user_Data);
                        check_user.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                  String pass_Check = snapshot.child(user_Data).child("psd").getValue(String.class);
                                   if(pass_Check.equals(pass_Data)){
                                       Toast.makeText(getApplicationContext(), "Login successfully", Toast.LENGTH_SHORT).show();
                                       // Intent
                                       Intent intent = new Intent(login.this,home.class);
                                       startActivity(intent);
                                       finish();


                                   }else{
                                       Toast.makeText(getApplicationContext(), "Invalid password", Toast.LENGTH_SHORT).show();
                                   }

                                } else {
                                Toast.makeText(getApplicationContext(), "Invalid user id", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                    }else{
                        Toast.makeText(getApplicationContext(), "Enter the password", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(), "Enter the user name", Toast.LENGTH_SHORT).show();

                }

            }
        });

        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,register.class);
                startActivity(intent);
            }
        });
    }
}