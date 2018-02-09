package com.wan.viewpagedemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SplashViewpagerActivity extends AppCompatActivity {
    private List<Fragment> mlist;
    private ViewPager mFragmentViewpager;
    private FragmentAdapter adapter;
    private com.wan.movecirclepoint.CirclePoint mCirclepoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_viewpager);
        initView();
        mFragmentViewpager.setAdapter(adapter);
        mFragmentViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mCirclepoint.setonPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        mFragmentViewpager = (ViewPager) findViewById(R.id.fragmentViewpager);
        mlist = new ArrayList<>();
        mlist.add(new Myfragment());
        mlist.add(new Myfragment1());
        adapter = new FragmentAdapter(getSupportFragmentManager(), mlist);

        mCirclepoint = (com.wan.movecirclepoint.CirclePoint) findViewById(R.id.circlepoint);
    }
}
