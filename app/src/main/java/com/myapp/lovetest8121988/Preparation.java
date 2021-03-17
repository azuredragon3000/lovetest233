package com.myapp.lovetest8121988;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class Preparation extends View {

    private Paint paint;
    Rect rect1;
    Rect rect2;
    String text;
    startnewview startnewview1;
    public Preparation(startnewview startnewview1,Context context) {
        super(context);

        this.startnewview1 = startnewview1;
        paint = new Paint();
        paint.setTextSize(100);
        paint.setColor(Color.GRAY);
        text = "hello world";
    }

    protected void onDraw(Canvas canvas){
        canvas.drawColor(Color.BLUE);
         rect1 = new Rect(100,100,300,300);
         rect2 = new Rect(500,500,800,800);
        canvas.drawRect(rect1,paint);
        canvas.drawRect(rect2,paint);
        canvas.drawText(text,100,100,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);
        int eventType = event.getAction() & MotionEvent.ACTION_MASK;
        if (eventType == MotionEvent.ACTION_UP || eventType == MotionEvent.ACTION_POINTER_UP) {
            if (rect1.contains(x, y)) {
                text = "cuong1";
                invalidate();
                startnewview1.startview1();

            }
            if (rect2.contains(x, y)) {
                text = "cuong2";
                invalidate();
                startnewview1.startview2();
            }
        }

        return true;
    }
}
