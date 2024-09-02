package com.example.onlinestore;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    EditText name,email,age;
    Button insert, view;

    DBHelper DB = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        age = findViewById(R.id.age);
        insert = findViewById(R.id.buttoninsert);
        view = findViewById(R.id.viewbutton);
        view.setOnClickListener(view -> startActivity(new Intent(MainActivity.this , Userlist.class)));

        insert.setOnClickListener(view -> {
            String nameTxt = name.getText().toString();
            String emailTxt = email.getText().toString();
            String ageTxt = age.getText().toString();

            Boolean checkinsertdata = DB.insertuserData(nameTxt,emailTxt,ageTxt);
            if(checkinsertdata){
                Toast.makeText(MainActivity.this,"New Entry Inserted", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(MainActivity.this, "data inserted UnSuccessfull", Toast.LENGTH_LONG).show();
            }
        });

    }
}