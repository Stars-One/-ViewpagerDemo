package com.wan.viewpagedemo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class PictureViewpagerActivity extends AppCompatActivity {

    private ViewPager mPictureviewpager;
    private int[] mImage = new int[10];
    private ImageView mFirst;
    private ImageView mSecond;
    private ImageView mThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_viewpager);
        initView();
        AdvertiseViewpagerAdapter advertiseViewpagerAdapter = new AdvertiseViewpagerAdapter(mImage);//将mImage数组作为构造函数的参数
        mPictureviewpager.setAdapter(advertiseViewpagerAdapter);//设置adapter
        mPictureviewpager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        mPictureviewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        mFirst.setImageResource(R.drawable.point_press);
                        mSecond.setImageResource(R.drawable.point_normal);
                        mThird.setImageResource(R.drawable.point_normal);
                        break;
                    case 1:
                        mFirst.setImageResource(R.drawable.point_normal);
                        mSecond.setImageResource(R.drawable.point_press);
                        mThird.setImageResource(R.drawable.point_normal);
                        break;
                    case 2:
                        mFirst.setImageResource(R.drawable.point_normal);
                        mSecond.setImageResource(R.drawable.point_normal);
                        mThird.setImageResource(R.drawable.point_press);
                        break;
                    default:

                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        mPictureviewpager = (ViewPager) findViewById(R.id.pictureviewpager);
        mImage[0] = R.drawable.first;
        mImage[1] = R.drawable.second;
        mImage[2] = R.drawable.third;
        mFirst = (ImageView) findViewById(R.id.firstImage);
        mSecond = (ImageView) findViewById(R.id.secondImage);
        mThird = (ImageView) findViewById(R.id.thirdImage);
    }
}
