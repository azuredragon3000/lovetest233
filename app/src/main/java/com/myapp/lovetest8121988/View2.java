package com.myapp.lovetest8121988;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class View2 extends SurfaceView implements Runnable{
    private Thread m1;
    private boolean running;
    private SurfaceHolder surfaceHolder;
    private Canvas canvas;
    private Paint paint;
    private Rect rect;
    startnewview startnewview1;

    public View2(startnewview startnewview1, Context context) {
        super(context);
        this.startnewview1 = startnewview1;
        m1 = new Thread(this);
        surfaceHolder = this.getHolder();
        paint = new Paint();
        rect = new Rect(100,100,300,300);
    }

    public void startgame(){
        running = true;
        m1.start();
    }

    public void stopgame() {
        running = false;
        try {
            m1.join();
        } catch (InterruptedException e) {
            Log.e("Exception","stopThread()" + e.getMessage());
        }
    }

    public void run(){
        while(running){
            if(surfaceHolder.getSurface().isValid()){
                canvas = surfaceHolder.lockCanvas();

                canvas.drawColor(Color.YELLOW);
                canvas.drawRect(rect, paint);

                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);
        int eventType = event.getAction() & MotionEvent.ACTION_MASK;
        if (eventType == MotionEvent.ACTION_UP || eventType == MotionEvent.ACTION_POINTER_UP) {
            if (rect.contains(x, y)) {

                startnewview1.stopview2();
                startnewview1.backToView();

            }

        }
        return true;
    }
}
