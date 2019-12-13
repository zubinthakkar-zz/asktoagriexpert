package com.example.zubinthakkar.asktoagriexpert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FarmerRegistration extends AppCompatActivity {

    Button reg;
    EditText nametm,emailtm,numbertm,passtm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer_registration);

        reg=(Button) findViewById(R.id.btn_reg);
        nametm=(EditText) findViewById(R.id.name);
        emailtm=(EditText) findViewById(R.id.mail);
        numbertm=(EditText) findViewById(R.id.number);
        passtm=(EditText) findViewById(R.id.pass);


    }
    public void Onfregs (View view)
    {
        String name = nametm.getText().toString();
        String email = emailtm.getText().toString();
        String number = numbertm.getText().toString();
        String pass = passtm.getText().toString();
        String type = "FRegister";

        FarmerRegWorker farmerRegWorker = new FarmerRegWorker(this);
        farmerRegWorker.execute(type,name,email,number,pass);
    }
}
