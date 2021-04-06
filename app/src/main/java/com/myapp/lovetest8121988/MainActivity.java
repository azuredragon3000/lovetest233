package com.myapp.lovetest8121988;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements startnewview {

    private ViewLoveQuotes viewLoveQuotes;
    private ViewPreparation viewPreparation;
    private Point size;
    private MyInterstitialAd myads;
    private ImageView imageView;
    private myDiagLog mydiaglog;
    private View decorView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        Display display = getWindowManager().getDefaultDisplay();
        size = new Point();
        display.getSize(size);

        /* must  initialize bs as here */
        BitmapStore bs = BitmapStore.getInstance(this);
        myads = new MyInterstitialAd("07CC7E40850ABA2DF210A2D2564CAD76",
                "ca-app-pub-8404443559572571/7496530619",this);

        viewPreparation = new ViewPreparation(this,this,size);
        setContentView(viewPreparation);
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                  @Override
                 public void onSystemUiVisibilityChange(int visibility) {
                  if(visibility == 0)
                      decorView.setSystemUiVisibility(hideSystemBar());
                  }
          });
    }




    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
       // View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(hideSystemBar());

    }

    private int hideSystemBar() {
        return View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
    }

    /* are which other class can called those methods */
    public void createCustomizeDialog() {
        mydiaglog = new myDiagLog("What's your name?","OK",this,this);
    }

    @Override
    public Bitmap getBitmap(String image) {
        BitmapStore.addBitmap(this,
                image,
                new PointF(size.x, size.y),
                1, true);
        Bitmap bitmap = BitmapStore.getBitmap(image);
        return bitmap;
    }

    @Override
    public void startview3() {
        ViewLoveTestImage view3 = new ViewLoveTestImage(this,this,size);
        setContentView(view3);
    }

    @Override
    public void exit() {
        finish();
    }

    public void backToView(){
        setContentView(viewPreparation);
    }

    public void setAds(){
        myads.load_ad(this);
    }

    @Override
    public void startview1() {
        imageView = new ImageView(this);
        ViewLoveTest myOrreryDrawable = ViewLoveTest.Create(size,this);
        imageView.setImageDrawable(myOrreryDrawable);
        imageView.setScaleType(ImageView.ScaleType.FIT_START);
        setContentView(imageView);

        ObjectAnimator animation = ObjectAnimator.ofFloat(imageView,"translationX",size.x);

        animation.setDuration(5000);
        animation.start();


        animation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                startview3();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

    @Override
    public void stopview1() {

    }

    @Override
    public void startview2() {
        viewLoveQuotes = new ViewLoveQuotes(this,this,size);
        setContentView(viewLoveQuotes);
        viewLoveQuotes.startgame();
    }

    @Override
    public void stopview2() {
        viewLoveQuotes.stopgame();
    }


}