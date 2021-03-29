package com.myapp.lovetest8121988;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

public class Triangle extends HinhHoc{

    private Point diem1;
    private Point diem2;
    private Point diem3;

    private int top;
    private int left;
    private int right;
    private int bottom;

    private Paint paint;
    Triangle(Point diem1, Point diem2, Point diem3 , int color){
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;

        paint = new Paint();
        paint.setColor(color);

        left = diem1.x;
        top = diem1.y;
        bottom = diem2.y;
        right = diem3.x;

         if (left > right) {
            int temp = right;
            right = left;
            left = temp;
        }
    }

    void drawTriangle(Canvas canvas){

        Path path = new Path();
        path.moveTo(this.diem1.x,this.diem1.y); // Top
        path.lineTo(this.diem2.x,this.diem2.y); // Bottom left
        path.lineTo(this.diem3.x,this.diem3.y); // Bottom right
        path.lineTo(this.diem1.x,this.diem1.y); // Back to Top
        path.close();

        canvas.drawPath(path, this.paint);
    }

    public boolean contains(int x, int y) {
            if(x<right && x>left){
                if(y<bottom&&y>top){
                    return true;
                }
            }
        return false;
    }
}
