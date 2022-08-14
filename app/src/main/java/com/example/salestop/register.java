package com.example.salestop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {

    FirebaseDatabase fd;
    DatabaseReference dr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView textView16 = findViewById(R.id.textView16);

        EditText firstname = findViewById(R.id.firstname);
        EditText lastname = findViewById(R.id.lastname);
        EditText username1 = findViewById(R.id.username1);
        EditText dob = findViewById(R.id.dob);
        EditText gender = findViewById(R.id.gender);
        EditText pswd= findViewById(R.id.pswd);
        EditText pswd1 = findViewById(R.id.pswd1);

        TextView button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname     =firstname.getText().toString();
                String lname     =lastname.getText().toString();
                String name1 =username1.getText().toString();
                String dob1   =dob.getText().toString();
                String gen =gender.getText().toString();
                String psd =pswd.getText().toString();
                String psd1 =pswd1.getText().toString();

                if(fname.isEmpty() ||lname.isEmpty() || name1.isEmpty() || dob1.isEmpty() || gen.isEmpty() || psd.isEmpty() || psd1.isEmpty() ){
                    Toast.makeText(getApplicationContext(), "Fill all the document ", Toast.LENGTH_SHORT).show();
                }
                if(psd.equals(psd1) ){

                    fd = FirebaseDatabase.getInstance();
                    dr = fd.getReference("datauser");

                    String fname_s     =firstname.getText().toString();
                    String lname_s     =lastname.getText().toString();
                    String name1_s =username1.getText().toString();
                    String dob1_s   =dob.getText().toString();
                    String gen_s =gender.getText().toString();
                    String psd_s =pswd.getText().toString();

                    StoringData sd = new StoringData(fname_s,lname_s,name1_s,dob1_s,gen_s,psd_s);
                    // to store data
                    dr.child(name1_s).setValue(sd);

                    Toast.makeText(getApplicationContext(), "Registered successfully ", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(register.this,home.class);
                    startActivity(intent);
                    finish();

                }else{
                    Toast.makeText(getApplicationContext(), "Password not matching ", Toast.LENGTH_SHORT).show();
                }


            }
        });


        textView16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(register.this,login.class);
                startActivity(intent);

                finish();
            }
        });
    }
}