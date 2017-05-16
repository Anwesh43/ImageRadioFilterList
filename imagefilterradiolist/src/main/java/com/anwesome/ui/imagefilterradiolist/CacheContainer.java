package com.anwesome.ui.imagefilterradiolist;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

/**
 * Created by anweshmishra on 16/05/17.
 */
public class CacheContainer {
    private static LruCache<Bitmap,Bitmap> scaledBitmapContainer = new LruCache<Bitmap, Bitmap>(10);
    public static void putScaledBitmap(Bitmap bitmap,Bitmap scaledBitmap) {
        scaledBitmapContainer.put(bitmap,scaledBitmap);
    }
    public static Bitmap getScaledBitmap(Bitmap bitmap) {
        return scaledBitmapContainer.get(bitmap);
    }
}
