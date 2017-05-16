package com.anwesome.ui.imagefilterradiolistdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.anwesome.ui.imagefilterradiolist.ImageRadioFilterView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.forest1);
        ImageRadioFilterView imageRadioFilterView = new ImageRadioFilterView(this,bitmap);
        addContentView(imageRadioFilterView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,300));
    }
}
