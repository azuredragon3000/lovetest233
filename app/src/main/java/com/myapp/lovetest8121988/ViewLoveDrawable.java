package com.myapp.lovetest8121988;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;

public class ViewLoveDrawable extends LayerDrawable {
    /**
     * Creates a new layer drawable with the list of specified layers.
     *
     * @param layers a list of drawables to use as layers in this new drawable,
     *               must be non-null
     */

    private static final int SPACE_HEIGHT = 150;
    private static final int RADIUS_SUN = 20;
    private static final int SPACE_ID = 0;
    private static final int SUN_ID = 1;

    public ViewLoveDrawable(@NonNull Drawable[] layers) {
        super(layers);
    }

    public static ViewLoveDrawable Create(Point size, Context context){

        Resources res = context.getResources();

        Drawable drawable2 = ResourcesCompat.getDrawable(res, R.drawable.logo, null);

        Drawable[] bodies = {  drawable2};
        ViewLoveDrawable myOrrery = new ViewLoveDrawable(bodies);


        myOrrery.setLayerInset(
                0,0,0,1000,1000);

        return myOrrery;
    }

    private static Drawable resizeDrawable(Drawable image, Context context,Point size, int scale) {
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, size.x/scale, size.y/scale, false);
        return new BitmapDrawable(context.getResources(), bitmapResized);
    }


}
