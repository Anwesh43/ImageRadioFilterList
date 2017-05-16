package com.anwesome.ui.imagefilterradiolistdemo;

import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anwesome.ui.imagefilterradiolist.ImageFilterRadioList;
import com.anwesome.ui.imagefilterradiolist.ImageRadioFilterView;
import com.anwesome.ui.imagefilterradiolist.OnSelectionChangeListener;

public class MainActivity extends AppCompatActivity {
    private Bitmap bitmap;
    private String bitmapKey = "IFRV_bitmap";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(bitmap == null) {
            if(savedInstanceState!=null && savedInstanceState.getParcelable(bitmapKey) != null) {
                bitmap = savedInstanceState.getParcelable(bitmapKey);
            }
            else {
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.forest1);
            }
        }
        ImageFilterRadioList imageFilterRadioList = new ImageFilterRadioList(this);
        for(int i=0;i<15;i++) {
            final int index = i;
            imageFilterRadioList.addImage(bitmap,new OnSelectionChangeListener() {
                @Override
                public void onSelect() {
                    Toast.makeText(MainActivity.this, (index+1)+"Selected", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onUnSelect() {
                    Toast.makeText(MainActivity.this, (index+1)+"UnSelected", Toast.LENGTH_SHORT).show();
                }
            });
        }
        imageFilterRadioList.show();
    }
    public void onSaveInstanceState(Bundle bundle) {
        if(bitmap != null) {
            bundle.putParcelable(bitmapKey, bitmap);
        }
    }
}
