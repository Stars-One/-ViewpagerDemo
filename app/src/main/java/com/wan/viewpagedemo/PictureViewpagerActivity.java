package com.wan.viewpagedemo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class PictureViewpagerActivity extends AppCompatActivity {

    private ViewPager mPictureviewpager;
    private int[] mImage = new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_viewpager);
        initView();
        AdvertiseViewpagerAdapter advertiseViewpagerAdapter = new AdvertiseViewpagerAdapter(mImage);//将mImage数组作为构造函数的参数
        mPictureviewpager.setAdapter(advertiseViewpagerAdapter);//设置adapter


    }

    private void initView() {
        mPictureviewpager = (ViewPager) findViewById(R.id.pictureviewpager);
        mImage[0] = R.drawable.first;
        mImage[1] = R.drawable.second;
        mImage[2] = R.drawable.third;

    }
}
