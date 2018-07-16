package com.smarttahi.questionlist.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.smarttahi.questionlist.mAdapter;
import com.smarttahi.questionlist.tools.Config;
import com.smarttahi.questionlist.tools.Data.Question;
import com.smarttahi.questionlist.tools.HttpRequest;
import com.smarttahi.questionlist.tools.JSONmanager;
import com.smarttahi.questionlist.tools.MyApplication;
import com.smarttahi.questionlist.tools.PackParameter;

import java.util.ArrayList;

public class BaseFragment extends Fragment {
    public RecyclerView recyclerView;
    public static final String TAG = "Fragment_three";
   public SwipeRefreshLayout refreshLayout;
   public ArrayList<Question> questions = null;
   public ArrayList<Question> changedList = new ArrayList<>();
    mAdapter adapter;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void setRecycler(mAdapter adapter) {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<Question> loadData(String page,String kind) {
        HttpRequest.sentHttpsRequest(PackParameter.Question_List(page, kind), Config.Api_Question_List, new HttpRequest.Callback() {
            @Override
            public void onSuccess(HttpRequest.Response response) {
                questions = JSONmanager.getQuestionList(response.getDate());
            }

            @Override
            public void onFiled(Exception e) {
                questions = new ArrayList<>();
                for (int i = 0; i<10; i++) {
                    questions.add(MyApplication.getAutoQuestion());
                }
                Log.d(TAG, e.toString());
                Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
            }
        });

        return questions;

//        this.adapter.notifyItemRangeRemoved(0, previousNum);
//        COUNT = q.size();
//        this.adapter.notifyItemChanged(0, q);
    }




    public void refresh(String p,String k) {
        final String page = p;
        final String kind = k;
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        HttpRequest.sentHttpsRequest(PackParameter.Question_List(page, kind), Config.Api_Question_List, new HttpRequest.Callback() {
                            @Override
                            public void onSuccess(HttpRequest.Response response) {
                                changedList = JSONmanager.getQuestionList(response.getDate());
                                int i;
                                for (i = 0;i<changedList.size(); i++){
                                    if(questions.get(i)==changedList.get(i)){
                                        changedList.remove(i);
                                    }
                                }
                                questions.addAll(changedList);
                                adapter.refreshItem(questions);
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
        });
    }
}
