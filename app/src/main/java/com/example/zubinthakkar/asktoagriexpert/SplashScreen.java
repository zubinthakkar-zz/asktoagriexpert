package com.example.zubinthakkar.asktoagriexpert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final Thread timer=new Thread()
        {
            @Override
            public void run() {
                try
                {
                    sleep(3000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Intent login=new Intent(SplashScreen.this,Login.class);
                    startActivity(login);
                    finish();
                }
            }
        };
        timer.start();
    }
}
