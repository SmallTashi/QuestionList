package com.smarttahi.questionlist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.smarttahi.questionlist.Fragment.First_Fragment;
import com.smarttahi.questionlist.Fragment.Second_Fragment;
import com.smarttahi.questionlist.Fragment.Third_Fragment;

import java.util.ArrayList;

public class mPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments = new ArrayList<>();

    private int count;
     mPagerAdapter(FragmentManager fm,int count) {
        super(fm);
        this.count = count;
         fragments.add(new First_Fragment());
         fragments.add(new Second_Fragment());
         fragments.add(new Third_Fragment());
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
