package com.example.braintrainer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Random;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Game extends AppCompatActivity {
    TextView ti,qu, qb1, qb2, qb3, qb4, res, scr;
    Random r;
    Button p;
    Boolean act= TRUE;
    int num1, num2, ans=0, ansblock, op, sign, tg, corr=0, atmp=0;

    public String qgen(){

        String ques;
        num1 = r.nextInt(200);
        num2 = r.nextInt(200);
        ques = "What is "+num1+" + "+num2 +" ?";

        return ques;
    }

    public void timer(){
        ti = findViewById(R.id.timer);
        res = findViewById(R.id.res);
        p = findViewById(R.id.pg);
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
                act = FALSE;
                res.setText("Your score is "+corr+" / "+atmp);
                p.setVisibility(View.VISIBLE);

            }
        }.start();
    }

public void click(View v){
if(act) {
    tg = Integer.parseInt(v.getTag().toString());
    Log.i("tag","Clicked "+ tg + " ansb: "+ansblock);

    res = findViewById(R.id.res);
    if (tg-1 == ansblock) {

        res.setTextColor(GREEN);
        res.setText("Correct!");
        corr++;
        atmp++;
    }else{
        res.setTextColor(RED);
        res.setText("Wrong!");
        atmp++;
    }

    question();

}

}
public void playagain(View v){
    res = findViewById(R.id.res);
    p = findViewById(R.id.pg);
        act = TRUE;
        corr = 0;
        atmp = 0;
        question();
        timer();
        res.setText("");
        p.setVisibility(View.INVISIBLE);

}

    public void question(){
        qu = findViewById(R.id.ques);
        qb1 = findViewById(R.id.q1);
        qb2 = findViewById(R.id.q2);
        qb3= findViewById(R.id.q3);
        qb4 = findViewById(R.id.q4);
        scr = findViewById(R.id.score);
        String s1 = qgen();
        scr.setText(""+corr+" / "+atmp);
        qu.setText(s1);
        ans = num1+num2;

        ansblock = r.nextInt(4);

        switch (ansblock) {
            case 0:
               qb1.setText(""+ans);
                op = r.nextInt(100);
                sign = r.nextInt(2);
                if(sign==0) {
                    qb2.setText(""+(ans+op));
                }else {
                    qb2.setText(""+(ans-op));
                }
                op = r.nextInt(100);
                sign = r.nextInt(1);
                if(sign==0) {
                    qb3.setText(""+(ans+op));
                }else {
                    qb3.setText(""+(ans-op));
                }
                op = r.nextInt(100);
                sign = r.nextInt(1);
                if(sign==0) {
                    qb4.setText(""+(ans+op));
                }else {
                    qb4.setText(""+(ans-op));
                }
                break;




            case 1:
                qb2.setText(""+ans);
                op = r.nextInt(100);
                sign = r.nextInt(1);
                if(sign==0) {
                    qb1.setText(""+(ans+op));
                }else {
                    qb1.setText(""+(ans-op));
                }
                op = r.nextInt(100);
                sign = r.nextInt(1);
                if(sign==0) {
                    qb3.setText(""+(ans+op));
                }else {
                    qb3.setText(""+(ans-op));
                }
                op = r.nextInt(100);
                sign = r.nextInt(1);
                if(sign==0) {
                    qb4.setText(""+(ans+op));
                }else {
                    qb4.setText(""+(ans-op));
                }
                break;

            case 2:
                qb3.setText(""+ans);
                op = r.nextInt(100);
                sign = r.nextInt(1);
                if(sign==0) {
                    qb2.setText(""+(ans+op));
                }else {
                    qb2.setText(""+(ans-op));
                }
                op = r.nextInt(100);
                sign = r.nextInt(1);
                if(sign==0) {
                    qb1.setText(""+(ans+op));
                }else {
                    qb1.setText(""+(ans-op));
                }
                op = r.nextInt(100);
                sign = r.nextInt(1);
                if(sign==0) {
                    qb4.setText(""+(ans+op));
                }else {
                    qb4.setText(""+(ans-op));
                }
                break;

            case 3:
                qb4.setText(""+ans);
                op = r.nextInt(100);
                sign = r.nextInt(1);
                if(sign==0) {
                    qb2.setText(""+(ans+op));
                }else {
                    qb2.setText(""+(ans-op));
                }
                op = r.nextInt(100);
                sign = r.nextInt(1);
                if(sign==0) {
                    qb3.setText(""+(ans+op));
                }else {
                    qb3.setText(""+(ans-op));
                }
                op = r.nextInt(100);
                sign = r.nextInt(1);
                if(sign==0) {
                    qb1.setText(""+(ans+op));
                }else {
                    qb1.setText(""+(ans-op));
                }
                break;




        }


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
        timer();








    }
}
