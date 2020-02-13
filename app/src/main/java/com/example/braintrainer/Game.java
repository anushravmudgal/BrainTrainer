package com.example.braintrainer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import static java.lang.Boolean.TRUE;

public class Game extends AppCompatActivity {
    TextView ti,qu;
    Random r;
    int num1, num2, ans=0;

    public String qgen(){

        String ques;
        num1 = r.nextInt(1000);
        num2 = r.nextInt(1000);
        ques = "What is "+num1+" + "+num2 +" ?";

        return ques;
    }
public void click(View v){

        question();
}


    public void question(){
        qu = findViewById(R.id.ques);
        String s1 = qgen();
        qu.setText(s1);
        ans = num1+num2;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ti = findViewById(R.id.timer);
        num1 = 0;
        num2 = 0;
        r = new Random();
        question();


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
