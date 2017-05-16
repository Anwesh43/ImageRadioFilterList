package com.anwesome.ui.imagefilterradiolist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anweshmishra on 16/05/17.
 */
public class ImageLayout extends ViewGroup {
    private int w,h,viewH;
    public ImageLayout(Context context) {
        super(context);
        initDimension(context);
    }
    public void initDimension(Context context) {
        DisplayManager displayManager = (DisplayManager)context.getSystemService(Context.DISPLAY_SERVICE);
        Display display = displayManager.getDisplay(0);
        if(display != null) {
            Point size = new Point();
            display.getRealSize(size);
            w = size.x;
            h = size.y;
            viewH = Math.max(w,h)/4;
        }
    }
    public void addImage(Bitmap bitmap,OnSelectionChangeListener onSelectionChangeListener) {
        ImageRadioFilterView imageRadioFilterView = new ImageRadioFilterView(getContext(),bitmap);
        imageRadioFilterView.setOnSelectionChangeListener(onSelectionChangeListener);
        addView(imageRadioFilterView,new LayoutParams(w,viewH));
        requestLayout();
    }
    public void onMeasure(int wspec,int hspec) {
        int hMax = viewH/4;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            measureChild(child,wspec,hspec);
            hMax += viewH+viewH/4;
        }
        setMeasuredDimension(w,Math.max(hMax+viewH/4,h));
    }
    public void onLayout(boolean reloaded,int a,int b,int w,int h) {
        int x = 0,y = viewH/4;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            child.layout(x,y,x+w,y+viewH);
            y+= viewH+viewH/4;
        }
    }
}
