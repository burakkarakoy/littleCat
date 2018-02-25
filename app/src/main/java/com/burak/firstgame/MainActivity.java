package com.burak.firstgame;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView scoreText;
    TextView timeText;
    ImageView ImageViev1;
    ImageView ImageViev2;
    ImageView ImageViev3;
    ImageView ImageViev4;
    ImageView ImageViev5;
    ImageView ImageViev6;
    ImageView ImageViev7;
    ImageView ImageViev8;
    ImageView ImageViev9;
    public int score;

    ImageView[] imageArray;

    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageViev1 = (ImageView) findViewById(R.id.imageView1);
        ImageViev2 = (ImageView) findViewById(R.id.imageView2);
        ImageViev3 = (ImageView) findViewById(R.id.imageView3);
        ImageViev4 = (ImageView) findViewById(R.id.imageView4);
        ImageViev5 = (ImageView) findViewById(R.id.imageView5);
        ImageViev6 = (ImageView) findViewById(R.id.imageView6);
        ImageViev7 = (ImageView) findViewById(R.id.imageView7);
        ImageViev8 = (ImageView) findViewById(R.id.imageView8);
        ImageViev9 = (ImageView) findViewById(R.id.imageView9);

        imageArray= new ImageView[] {ImageViev1,ImageViev2,ImageViev3,ImageViev4,ImageViev5,ImageViev6,ImageViev7,ImageViev8,ImageViev9};

        hideImage();

        score = 0;



        new CountDownTimer(5000,1000){


            @Override
            public void onTick(long millisUntilFinished) {
                timeText = (TextView) findViewById(R.id.timeText);
                timeText.setText("Time:"+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                timeText = (TextView) findViewById(R.id.timeText);
                timeText.setText("Bitti");
                handler.removeCallbacks(runnable);

                Intent i = new Intent(getApplicationContext(),PopUp.class);
                startActivity(i);

            }
        }.start();
    }

    public void increaseScore(View view) {

        scoreText = (TextView) findViewById(R.id.scoreText);
        score++;

        scoreText.setText("Score:" + score);

    }

    public void hideImage(){

        handler= new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {

                for(ImageView image: imageArray) {
                    image.setVisibility(View.INVISIBLE);

                }

                Random rand= new Random();
                int i = rand.nextInt(8-0);

                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this, 500);

            }
        };


        handler.post(runnable);

    }
}
