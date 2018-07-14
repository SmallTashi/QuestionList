package com.smarttahi.questionlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    public ViewPager pager;
    public mPagerAdapter adapter;
    public static final int COUNT = 3;
    public TabLayout title;
    public TabLayout.Tab one;
    public TabLayout.Tab two;
    public TabLayout.Tab three;

    /*
     * TODO 1.实现fragment与ViewPager的联动
     * TODO 2.测试项目
     * TODO 3.图片加载
     * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.title);
        one = title.newTab().setText(R.string.study);
        two = title.newTab().setText(R.string.emotion);
        three = title.newTab().setText(R.string.other);
        title.addTab(one);
        title.addTab(two);
        title.addTab(three);
        pager = findViewById(R.id.pager);
        adapter = new mPagerAdapter(getSupportFragmentManager(), COUNT);
        pager.setAdapter(adapter);
        setListener(title,pager);
    }

    public void setListener(TabLayout tabLayout, final ViewPager pager){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                pager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        one.select();
                        break;
                    case 1:
                        two.select();
                        break;
                    case 2:
                        three.select();
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


}
