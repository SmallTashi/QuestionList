package com.smarttahi.questionlist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.smarttahi.questionlist.Fragment.BaseFragment;
import com.smarttahi.questionlist.Fragment.First_Fragment;
import com.smarttahi.questionlist.Fragment.Second_Fragment;
import com.smarttahi.questionlist.Fragment.Third_Fragment;

import java.util.ArrayList;
import java.util.List;

public class mPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> fragments;

    private int count;
     mPagerAdapter(FragmentManager fm, ArrayList<BaseFragment> fragments) {
        super(fm);
        this.count = fragments.size();
         this.fragments = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return count;
    }




    /*
     * Determines whether a page View is associated with a specific key object
     * as returned by {@link #instantiateItem(ViewGroup, int)}. This method is
     * required for a PagerAdapter to function properly.
     * */
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        return view == object;    //could be implemented as <code>return view == object
//    }
}
