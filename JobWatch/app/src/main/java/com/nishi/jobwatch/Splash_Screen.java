package com.nishi.jobwatch;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Splash_Screen extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH =2000;
    //ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splash_Screen.this,Login.class);
                Splash_Screen.this.startActivity(mainIntent);
                Splash_Screen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                doTask();
//                start();
//                finish();
//            }
//        }).start();
//    }
//
//    private void start() {
//        Intent intent = new Intent(Splash_Screen.this, Login.class);
//        startActivity(intent);
//
//    }
//
//    private void doTask() {
//        for (int i = 0; i <= 100; i += 20) {
//            try {
//                Thread.sleep(1000);
//                progressBar.setProgress(i);
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }
    }
}

