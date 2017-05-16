package com.anwesome.ui.imagefilterradiolist;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
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
    private Radio radio;
    private Bitmap bitmap;
    private ImageColorFilter imageColorFilter = new ImageColorFilter();
    public ImageRadioFilterView(Context context,Bitmap bitmap) {
        super(context);
        this.bitmap = bitmap;
    }
    public void onDraw(Canvas canvas) {
        if(time == 0) {
            w = canvas.getWidth();
            h = canvas.getHeight();
            radio = new Radio();
            bitmap = Bitmap.createScaledBitmap(bitmap,w,4*h/5,true);
        }
        canvas.drawBitmap(bitmap,0,0,paint);
        imageColorFilter.draw(canvas);
        radio.draw(canvas);
        time++;
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            if(radio.handleTap(event.getX(),event.getY())) {

            }
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
            paint.setColor(Color.parseColor("#1565C0"));
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
    private class ImageColorFilter {
        private float gap = 0;
        public void draw(Canvas canvas) {
            paint.setColor(Color.argb(150,255,255,255));
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(new RectF(0,0,gap,4*h/5),paint);
            canvas.drawRect(new RectF(w-gap,0,w,4*h/5),paint);
        }
        public void update(float factor) {
            gap = (w/2)*factor;
        }
    }
    private class AnimationHandler extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private int dir = 0;
        private boolean isAnimating = false;
        private ValueAnimator startAnim = ValueAnimator.ofFloat(0,1),endAnim = ValueAnimator.ofFloat(1,0);
        public AnimationHandler() {
            startAnim.setDuration(500);
            endAnim.setDuration(500);
            startAnim.addUpdateListener(this);
            endAnim.addUpdateListener(this);
            startAnim.addListener(this);
            endAnim.addListener(this);
        }
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float factor = (float)valueAnimator.getAnimatedValue();
        }
        public void onAnimationEnd(Animator animator) {
            if(isAnimating) {
                dir = dir == 0 ? 1 : 0;
                if(dir == 1) {

                }
                else if(dir == 0) {

                }
                isAnimating = false;
            }
        }
        public void start() {
            if(!isAnimating) {
                if(dir == 0) {

                }
                else {

                }
            }
        }
    }
}
