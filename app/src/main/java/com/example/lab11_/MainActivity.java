package com.example.lab11_;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b,b1;
    TextView n,m;
    EditText name,mail;
    SharedPreferences sp;
    String names,mails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        name=(EditText) findViewById(R.id.editTextTextPersonName);
        mail=(EditText) findViewById(R.id.emailtake);
        b=(Button) findViewById(R.id.button);
        b1=(Button) findViewById(R.id.button1);

        sp=getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                names=name.getText().toString();
                mails=mail.getText().toString();

                SharedPreferences.Editor editor= sp.edit();

                editor.putString("name",names);
                editor.putString("mail",mails);

                editor.commit();
                Toast.makeText(MainActivity.this, "Your Information is Saves", Toast.LENGTH_SHORT).show();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,newActivity.class);
                startActivity(intent);
            }
        });
    }
}