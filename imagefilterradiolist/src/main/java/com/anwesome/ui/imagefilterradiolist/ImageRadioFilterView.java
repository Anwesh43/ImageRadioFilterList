package com.anwesome.ui.imagefilterradiolist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 16/05/17.
 */
public class ImageRadioFilterView extends View{
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public ImageRadioFilterView(Context context) {
        super(context);
    }
    public void onDraw(Canvas canvas) {

    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){

        }
        return true;
    }
}
