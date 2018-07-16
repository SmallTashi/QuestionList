package com.smarttahi.questionlist.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.smarttahi.questionlist.tools.MyApplication;
import com.smarttahi.questionlist.tools.PackParameter;

import java.util.ArrayList;
import java.util.Stack;

public class BaseFragment extends Fragment {
    RecyclerView recyclerView;
    public static final String TAG = "Fragment_three";
    public static int COUNT;
    SwipeRefreshLayout refreshLayout;
    ArrayList<Question> questions;
    ArrayList<Question> changedList = new ArrayList<>();
    private   String page = "0";
    private String kind = "学习";
    mAdapter adapter;

    public void setKind(String kind){
        this.kind = kind;
    }

    public void setPage(String page){
        this.page = page;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        questions = new ArrayList<>();
        for (int i = 9; i>=0; i++) {
            questions.add(MyApplication.getAutoQuestion());
        }
        COUNT = 10;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.page_three, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.page_three_rv);
//        refreshLayout = view.findViewById(R.id.refresh);

        adapter = new mAdapter(questions);
        setRecycler(adapter);
        HttpRequest.sentHttpsRequest(PackParameter.Question_List(page, kind), Config.Api_Question_List, new HttpRequest.Callback() {
            @Override
            public void onSuccess(HttpRequest.Response response) {
                changedList = JSONmanager.getQuestionList(response.getDate());

            }

            @Override
            public void onFiled(Exception e) {
                Log.d(TAG, e.toString());
                Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
            }
        });
        loadData(questions, COUNT);
    }

    public void setRecycler(mAdapter adapter) {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    public void loadData(ArrayList q, int previousNum) {
        this.adapter.notifyItemRangeRemoved(0, previousNum);
        COUNT = q.size();
        this.adapter.notifyItemChanged(0, q);
    }


    public void refresh() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpRequest.sentHttpsRequest(PackParameter.Question_List(page, "其他"), Config.Api_Question_List, new HttpRequest.Callback() {
                    @Override
                    public void onSuccess(HttpRequest.Response response) {
                        questions = JSONmanager.getQuestionList(response.getDate());
                        adapter.refreshItem(questions);
                        setRecycler(adapter);
                    }

                    @Override
                    public void onFiled(Exception e) {
                        Log.d(TAG, e.toString());
                        Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        }).start();
    }
}
