package com.myapp.lovetest8121988;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements startnewview{

    private View2 view2;
    private ViewPreparation viewPreparation;
    private Point size;
    private MyInterstitialAd myads;
    private ImageView imageView;
    private myDiagLog mydiaglog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        size = new Point();
        display.getSize(size);

        /* must  initialize bs as here */
        BitmapStore bs = BitmapStore.getInstance(this);
        myads = new MyInterstitialAd("07CC7E40850ABA2DF210A2D2564CAD76",
                "ca-app-pub-8404443559572571/3715462075",this);
        viewPreparation = new ViewPreparation(this,this,size);
        setContentView(viewPreparation);

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

    public void backToView(){
        setContentView(viewPreparation);
    }

    public void setAds(){
        myads.load_ad(this);
    }

    @Override
    public void startview1() {
        imageView = new ImageView(this);
        ViewLoveDrawable myOrreryDrawable = ViewLoveDrawable.Create(size,this);
        imageView.setImageDrawable(myOrreryDrawable);
        imageView.setScaleType(ImageView.ScaleType.FIT_START);
        setContentView(imageView);

        ObjectAnimator animation = ObjectAnimator.ofFloat(imageView,"translationX",1000f);

        animation.setDuration(5000);
        animation.start();
    }

    @Override
    public void stopview1() {

    }

    @Override
    public void startview2() {
        view2 = new View2(this,this,size);
        setContentView(view2);
        view2.startgame();
    }

    @Override
    public void stopview2() {
        view2.stopgame();
    }
}