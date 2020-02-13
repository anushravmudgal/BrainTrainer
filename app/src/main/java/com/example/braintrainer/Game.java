package com.example.braintrainer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;

import static java.lang.Boolean.TRUE;

public class Game extends AppCompatActivity {
    TextView ti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ti = findViewById(R.id.timer);
        ti.setText("0:30");

        new CountDownTimer(30000+100, 1000) {
            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onTick(long millis) {





                int t = (int) millis;

                if(t/1000>9) {
                    ti.setText("0:" + t / 1000);
                }else{
                    ti.setText("0:0" + t / 1000);
                }

                Log.i("Seconds left", "onTick: " + millis / 1000);
            }

            public void onFinish() {
                Log.i("Finished", "Countdow completed!");


            }
        }.start();






    }
}
