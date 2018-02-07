package com.wan.viewpagedemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ActivityPictureTestViewpagerActivity extends Activity  {

    private ViewPager pictureviewpager;
    private LinearLayout pointGroup;
    private ImageView whitePoint;
    private int[] mImage = new int[10];
    private int mPointMargin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_test_viewpager);

        pictureviewpager = (ViewPager) findViewById(R.id.pictureviewtestpager);
        pointGroup = (LinearLayout) findViewById(R.id.point_group);
        whitePoint = (ImageView) findViewById(R.id.white_point);

        mImage[0] = R.drawable.first;
        mImage[1] = R.drawable.second;
        mImage[2] = R.drawable.third;



        for (int i = 0; i < 3; i++) {
            // 设置底部小圆点(灰色)
            ImageView point = new ImageView(this);
            point.setImageResource(R.drawable.shape_point_normal);

            // 设置白点的布局参数
            int pointSize = getResources().getDimensionPixelSize(R.dimen.point_margin);
            //生成一个正方形的RelativeLayout，将ImageView设置为一个固定大小正方形（动态改变ImageView的宽高）
            RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(pointSize, pointSize);
            whitePoint.setLayoutParams(params1);

            // 设置灰色点的布局参数
            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(pointSize, pointSize);
            if (i > 0) {
                params2.leftMargin = getResources().getDimensionPixelSize(R.dimen.point_margin) ;
            }
            point.setLayoutParams(params2);
            pointGroup.addView(point);

        }

        AdvertiseViewpagerAdapter advertiseViewpagerAdapter = new AdvertiseViewpagerAdapter(mImage);//将mImage数组作为构造函数的参数
        pictureviewpager.setAdapter(advertiseViewpagerAdapter);//设置adapter
        // 获取视图树对象，通过监听白点布局的显示，然后获取两个圆点之间的距离
        whitePoint.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                // 此时layout布局已经显示出来了，可以获取小圆点之间的距离了
                mPointMargin = pointGroup.getChildAt(1).getLeft() - pointGroup.getChildAt(0).getLeft();

                // 将自己移除掉
                whitePoint.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

        pictureviewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                int leftMargin = (int) (mPointMargin * (position + positionOffset)); // 页面滑动的时候，动态的获取小圆点的左边距
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) whitePoint.getLayoutParams();// 获取布局参数，然后设置布局参数
                params.leftMargin = leftMargin; // 修改参数
                whitePoint.setLayoutParams(params); // 重新设置布局参数
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
