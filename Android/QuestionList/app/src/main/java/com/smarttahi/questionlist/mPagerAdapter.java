package com.smarttahi.questionlist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.smarttahi.questionlist.Fragment.ArrayListFragment;

public class mPagerAdapter extends FragmentPagerAdapter {
    private int count;
     mPagerAdapter(FragmentManager fm,int count) {
        super(fm);
        this.count = count;
    }

    @Override
    public Fragment getItem(int position) {
        return ArrayListFragment.newInstance(position);
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
