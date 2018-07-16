package com.smarttahi.questionlist.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

public class First_Fragment extends BaseFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setKind("学习");
        setPage("0");
    }
}
