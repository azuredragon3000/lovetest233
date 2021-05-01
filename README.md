package com.example.main;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ObjectView {
    CustomLayout mLayout;
    MView[] views;
    PropertyView[] pViews;
    Activity activity;
    Point size;
    String tag;
    private Question question;
    ArrayList<TextView> ATitleLayout;


    ObjectView(Activity activity, Point size,Question question){
        this.activity = activity;
        this.size = size;
        this.question = question;
        ATitleLayout = new ArrayList<TextView>();
    }

    public void setpViews(PropertyView[] pViews) {
        this.pViews = pViews;
    }

    public void setInput(InputComponent input) {
        input.setRects(pViews);
    }

    void combine(){
        mLayout = new CustomLayout(activity,size,pViews);
        views = new MView[pViews.length];
        for(int i=0;i<views.length;i++) {
            views[i] = new MView();
            views[i].bg = pViews[i].bg;
            if (pViews[i].typeView.equals("TextView")) {
                views[i].view = new TextView(activity);

                TextView TitleLayout = new TextView(activity);
                GradientDrawable border = new GradientDrawable();
                border.setColor(0xFFFFFFFF); //white background
                border.setStroke(1, 0xFF000000); //black border with full opacity
                if(Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    TitleLayout.setBackgroundDrawable(border);
                } else {
                    TitleLayout.setBackground(border);
                }

                if(pViews[i].question == null){
                    TitleLayout.setText(views[i].bg);
                }else {
                    switch (pViews[i].question) {
                        case "ques":
                            TitleLayout.setText(question.Question);
                            break;
                        case "A":
                            TitleLayout.setText(question.A);
                            break;
                        case "B":
                            TitleLayout.setText(question.B);
                            break;
                        case "C":
                            TitleLayout.setText(question.C);
                            break;
                        case "D":
                            TitleLayout.setText(question.D);
                            break;
                        default:
                            TitleLayout.setText(views[i].bg);
                            break;
                    }
                    ATitleLayout.add(TitleLayout);
                }

                views[i].view = TitleLayout;
                mLayout.addView(views[i].view);

            } else {
                views[i].view = new View(activity);
                Drawable resImg = getImageDrawable(views[i].bg);
                views[i].view.setBackground(resImg);
                mLayout.addView(views[i].view);
            }
        }
    }

    private Drawable getImageDrawable(String image) {
        int resID = activity.getResources().getIdentifier(image, "drawable", activity.getPackageName());
        return activity.getResources().getDrawable(resID);
    }

    public void setTag(String question) {
        tag = question;
    }

    public String getTag() {
        return tag;
    }

    public void setQuestion(Question question) {

        ATitleLayout.get(0).setText(question.Question);
        ATitleLayout.get(1).setText(question.A);
        ATitleLayout.get(2).setText(question.B);
        ATitleLayout.get(3).setText(question.C);
        ATitleLayout.get(4).setText(question.D);

    }
}
