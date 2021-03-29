package com.myapp.lovetest8121988;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
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
    private Bitmap bitmap;
    private String[] Image = new String[17];
    private int index;
    protected myRect[] rects;
    int x,y,padding_x,padding_y;
    protected Triangle[] triangles;

    public View2(startnewview startnewview1, Context context, Point mScreenSize) {
        super(context);
        x = (int)mScreenSize.x;
        y = (int)mScreenSize.y;
        padding_x = x/70;
        padding_y = y/70;
        int padding_y2 = y/10;
        this.startnewview1 = startnewview1;
        m1 = new Thread(this);
        surfaceHolder = this.getHolder();
        paint = new Paint();
        rects = new myRect[1];

        rects[0] = new myRect("X",(7*x)/8 ,0 ,x ,(y/8),
                Color.argb(100,255,255,255),
                Color.rgb(30, 34, 233),
                (int)mScreenSize.x/25,
                padding_x, padding_y);

        triangles = new Triangle[2];
        Point d1 = new Point(7*x/8+padding_x,y/8+padding_y2);
        Point d2 = new Point(7*x/8+padding_x,7*y/8-padding_y2);
        Point d3 = new Point(x-padding_x,y/2);
        triangles[0] = new Triangle(d1,d2,d3,Color.argb(100,255,255,255));

        d1 = new Point(x/8-padding_x,y/8+padding_y2);
        d2 = new Point(x/8-padding_x,7*y/8-padding_y2);
        d3 = new Point(0+padding_x,y/2);
        triangles[1] = new Triangle(d1,d2,d3,Color.argb(100,255,255,255));

        index = 0;
        InitializeImage();
        setmyBitmap();

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
                if(surfaceHolder.getSurface().isValid()) {
                    canvas = surfaceHolder.lockCanvas();
                    canvas.drawBitmap(bitmap, 0, 0, null);
                    rects[0].myDrawRect(canvas, paint);
                    for (int i = 0; i < triangles.length; i++) {
                        triangles[i].drawTriangle(canvas);
                    }
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
            if (rects[0].rect.contains(x, y)) {
                //exit
                startnewview1.stopview2();
                startnewview1.backToView();
                startnewview1.setAds();
            } else if (triangles[0].contains(x, y)) {
                setmyBitmap();
            } else if (triangles[1].contains(x, y)) {
                setmyBitmap();
            }
        }
        return true;
    }

    private void setmyBitmap() {
        bitmap = startnewview1.getBitmap(Image[index]);
        index++;
        if(index > 16){
            index =0;
        }
    }

    private void InitializeImage() {
        Image[0] = "hinhphat1";
        Image[1] = "hinhphat2";
        Image[2] = "hinhphat3";
        Image[3] = "hinhphat4";
        Image[4] = "hinhphat5";
        Image[5] = "hinhphat6";
        Image[6] = "hinhphat7";
        Image[7] = "hinhphat8";
        Image[8] = "hinhphat9";
        Image[9] = "hinhphat10";
        Image[10] = "hinhphat11";
        Image[11] = "hinhphat12";
        Image[12] = "hinhphat13";
        Image[13] = "hinhphat14";
        Image[14] = "hinhphat15";
        Image[15] = "hinhphat16";
        Image[16] = "hinhphat17";
    }

}
