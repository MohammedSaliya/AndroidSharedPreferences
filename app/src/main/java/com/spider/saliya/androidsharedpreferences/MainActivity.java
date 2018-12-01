package com.spider.saliya.androidsharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password, phone;
    Button save, retrieve, clear;
    private String MySAVE;
    String Name="NAME";
    String Password="PASSWORD";
    String Phone="PHONE";

    SharedPreferences sharedPreferences;

//    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* <-----EditText------>*/

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);

        /* <-----Button------>*/

        save = findViewById(R.id.save);
        retrieve = findViewById(R.id.retrieve);
        clear = findViewById(R.id.clear);

        sharedPreferences = getSharedPreferences(MySAVE, Context.MODE_PRIVATE);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = username.getText().toString();
                String pass = password.getText().toString();
                String pho = phone.getText().toString();


                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(Name, name);
                editor.putString(Password, pass);
                editor.putString(Phone, pho);
                editor.commit();

                if (name.equals("") || pass.equals("") || pho.equals("")) {
                    Toast.makeText(MainActivity.this, "Please Enter your All Your Details", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(MainActivity.this, "Thank You So Much", Toast.LENGTH_LONG).show();

                }
            }

        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username.setText("");
                password.setText("");
                phone.setText("");

                sharedPreferences = getSharedPreferences(MySAVE, Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();


                editor.clear();
                editor.commit();


            }
        });
        retrieve.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            sharedPreferences = getSharedPreferences(MySAVE, Context.MODE_PRIVATE);

                                            if (sharedPreferences.contains(Name)) {
                                                username.setText(sharedPreferences.getString(Name, " "));
                                            }
                                            if (sharedPreferences.contains(Password)) {
                                                password.setText(sharedPreferences.getString(Password, ""));
                                            }
                                            if (sharedPreferences.contains(Phone)) {
                                                phone.setText(sharedPreferences.getString(Phone, ""));
                                            }
                                        }
                                    }

        );

    }
}
