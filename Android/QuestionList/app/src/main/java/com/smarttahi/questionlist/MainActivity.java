package com.smarttahi.questionlist;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public ViewPager pager;
    public mPagerAdapter adapter;
    public static final int COUNT = 3;

    /*
    * TODO 1.实现fragment与ViewPager的联动
    * TODO 2.测试项目
    * TODO 3.图片加载
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager=findViewById(R.id.pager);
        adapter = new mPagerAdapter(getSupportFragmentManager(),COUNT);
        pager.setAdapter(adapter);
    }



}
