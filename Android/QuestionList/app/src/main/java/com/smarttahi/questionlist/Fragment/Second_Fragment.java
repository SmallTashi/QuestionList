package com.smarttahi.questionlist.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

public class Second_Fragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setKind("情感");
        setPage("0");
    }

}
