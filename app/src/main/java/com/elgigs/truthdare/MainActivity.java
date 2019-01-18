package com.elgigs.truthdare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView arw;
    Random r = new Random();
    int lastdir;
    boolean spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arw = findViewById(R.id.arrow);
    }

    public void click(View v) {
        if (!spin) {
            int newDir = r.nextInt(20000);
            float pivotX = arw.getWidth() / 2;
            float pivotY = arw.getHeight() / 2;

            Animation rotate = new RotateAnimation(lastdir, newDir, pivotX, pivotY);
            rotate.setDuration(5000);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spin = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spin = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            lastdir = newDir;
            arw.startAnimation(rotate);
        }
    }
}