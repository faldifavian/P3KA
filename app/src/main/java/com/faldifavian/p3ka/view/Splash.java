package com.faldifavian.p3ka.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.faldifavian.p3ka.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread t = new Thread(){
            public void run()
            {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent in= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
                finish();
            }
        };
        t.start();
    }
}
