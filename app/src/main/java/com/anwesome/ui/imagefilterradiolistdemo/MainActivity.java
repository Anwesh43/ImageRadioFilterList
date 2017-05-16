package com.anwesome.ui.imagefilterradiolistdemo;

import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anwesome.ui.imagefilterradiolist.ImageRadioFilterView;
import com.anwesome.ui.imagefilterradiolist.OnSelectionChangeListener;

public class MainActivity extends AppCompatActivity {
    private Bitmap bitmap;
    private String bitmapKey = "IFRV_bitmap";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(bitmap == null) {
            if(savedInstanceState!=null && savedInstanceState.getParcelable(bitmapKey) != null) {
                bitmap = savedInstanceState.getParcelable(bitmapKey);
            }
            else {
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.forest1);
            }
        }
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ImageRadioFilterView imageRadioFilterView = new ImageRadioFilterView(this, bitmap);
        addContentView(imageRadioFilterView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,500));
        imageRadioFilterView.setOnSelectionChangeListener(new OnSelectionChangeListener() {
            @Override
            public void onSelect() {
                Toast.makeText(MainActivity.this, "Selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onUnSelect() {
                Toast.makeText(MainActivity.this, "UnSelected", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onSaveInstanceState(Bundle bundle) {
        if(bitmap != null) {
            bundle.putParcelable(bitmapKey, bitmap);
        }
    }
}
