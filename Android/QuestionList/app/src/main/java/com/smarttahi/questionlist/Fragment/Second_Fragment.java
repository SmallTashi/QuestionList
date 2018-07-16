package com.smarttahi.questionlist.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smarttahi.questionlist.R;
import com.smarttahi.questionlist.mAdapter;

public class Second_Fragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setKind("情感");
        setPage(0);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.page_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.page_two_rv);
        refreshLayout = view.findViewById(R.id.refresh_two);
        loadData();
        adapter = new mAdapter(questions);
        setRecycler(adapter);
        refresh(0);
    }

}
