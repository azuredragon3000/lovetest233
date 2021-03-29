package com.myapp.lovetest8121988;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class myRect extends HinhHoc{

    public Rect rect;
    public String text;

    private int left;
    private int right;
    private int top;
    private int bottom;

    private int mTextFormatting;
    private int colorRect;
    private int colorTextRect;

    myRect(String text, int l, int t, int r, int b,
           int colorRect, int colorTextRect,
           int textsize,
           int paddingX, int paddingY){

        this.text = text;
        left = l+paddingX;
        top = t+paddingY;
        right = r-paddingX;
        bottom = b-paddingY;

        rect = new Rect(left,top,right,bottom);
        this.colorRect = colorRect;
        this.colorTextRect = colorTextRect;
        this.mTextFormatting = textsize;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getWriteText() {
        return text;
    }
    public int getColorRect() {
        return colorRect;
    }
    public int getColorTextRect() {
        return colorTextRect;
    }
    public float getTextSize() {
        return mTextFormatting;
    }

    void myDrawRect(Canvas canvas, Paint paint){

        paint.setColor(this.getColorRect());
        canvas.drawRect(this.rect, paint);

        /* draw text bitmap */
        if(this.getWriteText() != null ) {
            paint.setColor(this.getColorTextRect());
            paint.setTextSize(this.getTextSize());
            int len_x = (int) paint.measureText(this.text);
            Rect bounds = new Rect();
            paint.getTextBounds(this.text, 0, this.text.length(), bounds);
            int len_y = bounds.height();
            int x = setPosX(this.rect.left, this.rect.width(), len_x);
            int y = setPosY(this.rect.top, this.rect.height(), len_y);
            canvas.drawText(this.text, x, y, paint);
        }
    }

    private int setPosY(int top, int h, int len) {
        int t = h - len;
        return top + (t/2)+len;
    }

    private int setPosX(int left, int w,int len) {
        int t = w - len;
        return left+(t/2);
    }

}
