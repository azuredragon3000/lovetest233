package com.myapp.lovetest8121988;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class ViewLoveTestImage extends View {
    private Bitmap bitmap;
    private Paint paint;
    private startnewview startnewview1;
    private String[] Image = new String[25];
    private Rect rect;

    protected myRect[] rects;

    public boolean onTouchEvent(MotionEvent event) {
        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);
        int eventType = event.getAction() & MotionEvent.ACTION_MASK;
        if (eventType == MotionEvent.ACTION_UP || eventType == MotionEvent.ACTION_POINTER_UP) {
            if (rects[0].rect.contains(x, y)) {
                //exit
                //startnewview1.stopview2();
                startnewview1.backToView();
                startnewview1.setAds();
            }
        }
        return true;
    }

    public ViewLoveTestImage(Context context, startnewview startnewview1, Point mScreenSize) {
        super(context);
        this.startnewview1 = startnewview1;
        rects = new myRect[1];
        int x = (int)mScreenSize.x;
        int y = (int)mScreenSize.y;
        paint = new Paint();
        int padding_x = x/70;
        int padding_y = y/70;

        rects[0] = new myRect("X",(7*x)/8 ,0 ,x ,(y/8),
                Color.argb(100,255,255,255),
                Color.rgb(30, 34, 233),
                (int)mScreenSize.x/25,
                padding_x, padding_y);
        InitializeImage();
        setBitmap();
    }

    private void setBitmap() {
        Random randGenerator = new Random();
        int index = randGenerator.nextInt(24);
        bitmap = startnewview1.getBitmap(Image[index]);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 0, 0, null);
        rects[0].myDrawRect(canvas, paint);
    }

    private void InitializeImage() {
        for(int i=0;i<25;i++){
            Image[i] = "lovetest"+i;
        }
    }
}
