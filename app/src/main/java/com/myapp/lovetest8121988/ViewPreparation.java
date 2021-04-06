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

public class ViewPreparation extends View {

    private Paint paint;
    Rect rect1;
    Rect rect2;
    startnewview startnewview1;
    String result;
    int x,y,padding_x,padding_y;
    protected myRect[] rects;
    private Bitmap bitmap;
    private String image;

    public ViewPreparation(startnewview startnewview1, Context context, Point mScreenSize) {

        super(context);
        this.startnewview1 = startnewview1;
        paint = new Paint();
        paint.setTextSize(100);
        paint.setColor(Color.GRAY);
        x = (int)mScreenSize.x;
        y = (int)mScreenSize.y;
        padding_x = x/20;
        padding_y = y/20;
        int padding_xx = x/70;
        int padding_yy = y/70;
        rects = new myRect[3];
        rects[0] = new myRect(
                "LOVE TEST",
                0,
                (y/2),
                (x/2),
                (y/2)+(y/4),
                Color.argb(100,255,255,255),
                Color.rgb(0,0,0),
                (int)mScreenSize.x/35,
                padding_x, padding_y
        );

        rects[1] = new myRect(
                "LOVE QUOTES",
                (x/2),
                (y/2),
                x,
                (y/2)+(y/4),
                Color.argb(100,255,255,255),
                Color.rgb(0,0,0),
                (int)mScreenSize.x/35,
                padding_x, padding_y
        );

        rects[2] = new myRect("X",(7*x)/8 ,0 ,x ,(y/8),
                Color.argb(100,255,255,255),
                Color.rgb(30, 34, 233),
                (int)mScreenSize.x/25,
                padding_xx, padding_yy);
        image = "bg";
        bitmap = startnewview1.getBitmap(image);
    }

    protected void onDraw(Canvas canvas){
        canvas.drawBitmap(bitmap, 0, 0, null);
        for(int i=0;i<rects.length;i++){
            rects[i].myDrawRect(canvas,paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);
        int eventType = event.getAction() & MotionEvent.ACTION_MASK;
        if (eventType == MotionEvent.ACTION_UP || eventType == MotionEvent.ACTION_POINTER_UP) {
            if (rects[0].rect.contains(x, y)) {
                startnewview1.createCustomizeDialog();
            }
            if (rects[1].rect.contains(x, y)) {
                startnewview1.setAds();
                startnewview1.startview2();
            }
            if (rects[2].rect.contains(x, y)) {
                // exit
                startnewview1.exit();
            }
        }
        return true;
    }
}
