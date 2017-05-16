package com.anwesome.ui.imagefilterradiolist;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ScrollView;

/**
 * Created by anweshmishra on 16/05/17.
 */
public class ImageFilterRadioList  {
    private ScrollView scrollView;
    private ImageLayout imageLayout;
    private boolean isShown = false;
    private Activity activity;
    public ImageFilterRadioList(Activity activity) {
        this.activity = activity;
        scrollView = new ScrollView(activity);
        imageLayout = new ImageLayout(activity);
        scrollView.addView(imageLayout,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
    public void addImage(Bitmap bitmap,OnSelectionChangeListener onSelectionChangeListener) {
        if(!isShown) {
            imageLayout.addImage(bitmap,onSelectionChangeListener);
        }
    }
    public void show() {
        if(!isShown) {
            activity.setContentView(scrollView);
            isShown = true;
        }
    }
}
