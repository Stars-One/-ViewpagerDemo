package com.wan.viewpagedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 简单的Viewpager
     */
    private Button mSimple;
    /**
     * 带小圆点的View
     */
    private Button mAdvertise;
    /**
     * app引导页
     */
    private Button mSlash;
    private Intent intent;
    /**
     * 显示图片的Viewpager
     */
    private Button mPicture;
    /**
     * app引导页
     */
    private Button mSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mSimple = (Button) findViewById(R.id.simple);
        mSimple.setOnClickListener(this);
        mAdvertise = (Button) findViewById(R.id.advertise);
        mAdvertise.setOnClickListener(this);
        mSlash = (Button) findViewById(R.id.splash);
        mSlash.setOnClickListener(this);
        intent = new Intent();
        mPicture = (Button) findViewById(R.id.picture);
        mPicture.setOnClickListener(this);
        mSplash = (Button) findViewById(R.id.splash);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.simple:
                intent.setClass(v.getContext(), simpleViewpagerActivity.class);
                startActivity(intent);
                break;
            case R.id.advertise:
                intent.setClass(v.getContext(), AdvertiseViewpagerActivity.class);
                startActivity(intent);
                break;
            case R.id.splash:
                intent.setClass(v.getContext(), SplashViewpagerActivity.class);
                startActivity(intent);
                break;
            default:
                break;
            case R.id.picture:
                intent.setClass(v.getContext(), PictureViewpagerActivity.class);
                startActivity(intent);
                break;
        }
    }
}
