package com.smarttahi.questionlist.tools;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.smarttahi.questionlist.tools.Data.User;


public class MyApplication extends Application {
    public static final int ANSWER_LIST = 0;
    public static final int QUESTION_LIST = 1;
//    public static final int MINE_LIST = 2;
    public static final int ANSWER_DETAIL = 3;
    public static Boolean IS_LOGIN = false;


    public static User user = null;
    @SuppressLint("StaticFieldLeak")
    protected static Context thisContext;
//    public static User user;

    @Override
    public void onCreate() {
        super.onCreate();
        thisContext = getApplicationContext();
    }

    public static void keepState() {
        SharedPreferences sharedPreferences = getThisContext().getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("stuNum", user.getStuNum());
        editor.putString("idNum", user.getIdNum());
        editor.putInt("userId", user.getId());
        editor.putString("stuName", user.getName());
        editor.putString("gender", user.getGender());
        editor.apply();
        editor.commit();
    }


    public static Context getThisContext() {
        return thisContext;
    }

    public static void setUser(User user) {
        MyApplication.user = user;
        if(user!=null){
            keepState();
            IS_LOGIN = true;
        }
    }

    public static User getUser() {
        if (user != null) {
            return user;
        }
        return null;
    }
}
