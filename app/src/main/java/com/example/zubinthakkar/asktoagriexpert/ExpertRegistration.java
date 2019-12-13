package com.example.zubinthakkar.asktoagriexpert;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.Statement;

public class ExpertRegistration extends AppCompatActivity {

    Button register;
    EditText nametm,emailtm,numbertm,passtm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expert_registration);

        register=(Button) findViewById(R.id.btn_reg);
        nametm=(EditText) findViewById(R.id.name);
        emailtm=(EditText) findViewById(R.id.mail);
        numbertm=(EditText) findViewById(R.id.number);
        passtm=(EditText) findViewById(R.id.pass);



    }
    public void OnReg(View view)
    {
        String name = nametm.getText().toString();
        String email = emailtm.getText().toString();
        String number = numbertm.getText().toString();
        String pass = passtm.getText().toString();
        String type = "Register";

        ExpertWorker expertWorker = new ExpertWorker(this);
        expertWorker.execute(type,name,email,number,pass);
//        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
//        backgroundWorker.execute(type, name,pass, email,number);
    }

}



