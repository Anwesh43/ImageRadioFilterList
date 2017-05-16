package com.anwesome.ui.imagefilterradiolist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
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
        private float deg = 0;
        private int x,y,r;
        public Radio() {
            x = w/2;
            y = h-h/10;
            r = h/10;
        }
        public void draw(Canvas canvas) {
            canvas.save();
            canvas.translate(x,y);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(0,0,r,paint);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawArc(new RectF(-r,-r,r,r),0,deg,true,paint);
            canvas.restore();
        }
        public void update(float factor) {
            deg = 360*factor;
        }
        public boolean handleTap(float x,float y) {
            return x >= (this.x-this.r) && x <= (this.x+this.r) && y >= (this.y-this.r) && y <= (this.y+this.r);
        }
    }
}
