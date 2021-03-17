package com.myapp.lovetest8121988;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

public class MainActivity extends Activity implements startnewview{

    private View1 view1;
    private View2 view2;
    private Preparation preparation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);


        preparation = new Preparation(this,this);
        setContentView(preparation);

    }

    public void backToView(){
        setContentView(preparation);
    }


    @Override
    public void startview1() {
        view1 = new View1(this,this);
        setContentView(view1);
        view1.startgame();
    }

    @Override
    public void stopview1() {
        view1.stopgame();
    }

    @Override
    public void startview2() {
        view2 = new View2(this,this);
        setContentView(view2);
        view2.startgame();
    }

    @Override
    public void stopview2() {
        view2.stopgame();
    }
}