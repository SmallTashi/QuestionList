package com.smarttahi.questionlist.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.smarttahi.questionlist.R;
import com.smarttahi.questionlist.mAdapter;
import com.smarttahi.questionlist.tools.Config;
import com.smarttahi.questionlist.tools.Data.Question;
import com.smarttahi.questionlist.tools.HttpRequest;
import com.smarttahi.questionlist.tools.JSONmanager;
import com.smarttahi.questionlist.tools.PackParameter;

import java.util.ArrayList;

public class Third_Fragment extends Fragment {
    RecyclerView recyclerView;
    SwipeRefreshLayout refreshLayout;
    ArrayList<Question> questions;
    Question mark;
    mAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if( getArguments()!=null)
            ArrayListFragment.num = 3;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.page_three,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        refreshLayout = view.findViewById(R.id.refresh);
        HttpRequest.sentHttpsRequest(PackParameter.Question_List("0", "其他"), Config.Api_Question_List, new HttpRequest.Callback() {
            @Override
            public void onSuccess(HttpRequest.Response response) {
                questions = JSONmanager.getQuestionList(response.getDate());
                mark = questions.get(0);
                adapter = new mAdapter(questions);
                setRecycler(adapter);
            }

            @Override
            public void onFiled(Exception e) {
                Toast.makeText(getContext(),e.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }
    public void setRecycler(mAdapter adapter){
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
    public void refresh(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpRequest.sentHttpsRequest(PackParameter.Question_List("0", "其他"), Config.Api_Question_List, new HttpRequest.Callback() {
                    @Override
                    public void onSuccess(HttpRequest.Response response) {
                        questions = JSONmanager.getQuestionList(response.getDate());
                        adapter.refreshItem(questions);
                        setRecycler(adapter);
                    }

                    @Override
                    public void onFiled(Exception e) {
                        Toast.makeText(getContext(),e.toString(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        }).start();
    }

}
