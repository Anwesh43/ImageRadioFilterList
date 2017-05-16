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
    private int w,h,time = 0;
    public ImageRadioFilterView(Context context) {
        super(context);
    }
    public void onDraw(Canvas canvas) {
        if(time == 0) {
            w = canvas.getWidth();
            h = canvas.getHeight();
        }
        time++;
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){

        }
        return true;
    }
    private class Radio {
        private int x,y,r;
        public Radio() {
            x = w/2;
            y = h-h/10;
            r = h/10;
        }
    }
}
