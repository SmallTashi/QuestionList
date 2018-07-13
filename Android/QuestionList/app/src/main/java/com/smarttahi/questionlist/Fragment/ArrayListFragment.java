package com.smarttahi.questionlist.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;

public class ArrayListFragment extends Fragment {
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static int num;


    public static Fragment newInstance(int position) {
        if (position == FIRST) {
            First_Fragment f = new First_Fragment();
            Bundle bundle = new Bundle();
            bundle.putInt("num", position);
            return f;
        } else if (position == SECOND) {
            Second_Fragment f = new Second_Fragment();
            Bundle bundle = new Bundle();
            bundle.putInt("num", position);
            return f;
        } else {
            Third_Fragment f = new Third_Fragment();
            Bundle bundle = new Bundle();
            bundle.putInt("num", position);
            return f;
        }
    }

}
