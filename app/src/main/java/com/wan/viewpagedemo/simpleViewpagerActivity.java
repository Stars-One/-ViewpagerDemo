package com.wan.viewpagedemo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class simpleViewpagerActivity extends AppCompatActivity {

    private ViewPager mSimpleviewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_viewpager);
        initView();
        SimpleViewpagerAdapter simpleViewpagerAdapter = new SimpleViewpagerAdapter();
        mSimpleviewpager.setAdapter(simpleViewpagerAdapter);
    }

    private void initView() {
        mSimpleviewpager = (ViewPager) findViewById(R.id.simpleviewpager);
    }
}
