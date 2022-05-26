package com.example.lab11_;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class newActivity extends AppCompatActivity {

    TextView t1,t2;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        e1=(EditText) findViewById(R.id.editTextTextPersonName);
        e2=(EditText) findViewById(R.id.emailtake);

        SharedPreferences sp=getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        String name=sp.getString("name", "");
        String mail=sp.getString("mail", "");

        e1.setText(name);
        e2.setText(mail);
    }
}