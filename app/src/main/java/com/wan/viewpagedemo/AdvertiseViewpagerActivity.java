package com.wan.viewpagedemo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import me.relex.circleindicator.CircleIndicator;

public class AdvertiseViewpagerActivity extends AppCompatActivity {

    private ViewPager mAdvertiseviewpager;
    private int[] mImage = new int[10];
    private CircleIndicator mCircleindicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertise_viewpager);
        initView();
        AdvertiseViewpagerAdapter advertiseViewpagerAdapter = new AdvertiseViewpagerAdapter(mImage);//将mImage数组作为构造函数的参数

        mAdvertiseviewpager.setAdapter(advertiseViewpagerAdapter);//设置adapter
        mCircleindicator.setViewPager(mAdvertiseviewpager);//设置指示器


    }

    private void initView() {
        mAdvertiseviewpager = (ViewPager) findViewById(R.id.advertiseviewpager);
        //获得图片的resID，存放在int数组mImage中
        mImage[0] = R.drawable.first;
        mImage[1] = R.drawable.second;
        mImage[2] = R.drawable.third;

        mCircleindicator = (CircleIndicator) findViewById(R.id.circleindicator);

    }
}
