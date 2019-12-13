package com.example.zubinthakkar.asktoagriexpert;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class Login extends AppCompatActivity {

    Button btn1,btn2,hi,gu,en;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_redirect);

        hi=(Button) findViewById(R.id.hindi);
        gu=(Button) findViewById(R.id.gujarati);
        en=(Button) findViewById(R.id.english);

        final Intent refersh=new Intent(Login.this,SplashScreen.class);

        hi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale locale3= new Locale("hi");
                Locale.setDefault(locale3);
                Configuration config3 = new Configuration();
                config3.locale = locale3;
                getBaseContext().getResources().updateConfiguration(config3, getBaseContext().getResources().getDisplayMetrics());
                startActivity(refersh);
            }
        });

        en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale locale3= new Locale("en");
                Locale.setDefault(locale3);
                Configuration config3 = new Configuration();
                config3.locale = locale3;
                getBaseContext().getResources().updateConfiguration(config3, getBaseContext().getResources().getDisplayMetrics());
                startActivity(refersh);
            }
        });

        gu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale locale3= new Locale("gu");
                Locale.setDefault(locale3);
                Configuration config3 = new Configuration();
                config3.locale = locale3;
                getBaseContext().getResources().updateConfiguration(config3, getBaseContext().getResources().getDisplayMetrics());
                startActivity(refersh);
            }
        });

        btn1=(Button) findViewById(R.id.btn_expert);
        btn2=(Button) findViewById(R.id.btn_farmer);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent in=new Intent(Login.this,ExpertLogin.class);
                 startActivity(in);
            }
        });



        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent i=new Intent(Login.this,FarmerLogin.class);
               startActivity(i);
            }
        });

    }
    }
