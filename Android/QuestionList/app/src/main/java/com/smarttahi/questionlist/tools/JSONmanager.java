package com.smarttahi.questionlist.tools;

import android.util.Log;

import com.smarttahi.questionlist.tools.Data.Question;
import com.smarttahi.questionlist.tools.Data.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Stack;

public class JSONmanager {
    public static int getArrayNumber(String data) throws JSONException {
        JSONArray array = new JSONArray(data);
        return array.length();
    }

    public static User checkUser(String s,String data){
        JSONObject object;
        try {
            object = new JSONObject(s);
            User user = new User();
            user.setStuNum(object.getString("stuNum"));
            user.setName(object.getString("name"));
            user.setCollege(object.getString("college"));
            user.setClassX(object.getString("class"));
            user.setClassNum(object.getString("classNum"));
            user.setGender(object.getString("gender"));
            user.setMajor(object.getString("major"));
            user.setGrade(object.getString("grade"));
            user.setIdNum(object.getString("idNum"));
            JSONObject bean = new JSONObject(data);
            user.setId(bean.getInt("id"));
            user.setIntroduction(bean.getString("introduction"));
            user.setNickname(bean.getString("nickname"));
            user.setPhoto_thumbnail_src(bean.getString("photo_thumbnail_src"));
            user.setPhoto_src(bean.getString("photo_src"));
            user.setUpdated_time(bean.getString("updated_time"));
            user.setPhone(bean.getString("phone"));
            user.setQq(bean.getString("qq"));
            return user;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Question> getQuestionList(String data){
        JSONArray array ;
        ArrayList<Question> list =null;
        try {
            list = new ArrayList<>();
            array = new JSONArray(data);

            for (int i = 0; array.getJSONObject(i)!=null||i<=10; i++) {
                JSONObject object =array.getJSONObject(i);
                Question bean = new Question();
                bean.setAnswer_num(object.getInt("answer_num"));
                bean.setCreated_at(object.getString("created_at"));
                bean.setTags(object.getString("tags"));
                bean.setTitle(object.getString("title"));
                bean.setDescription(object.getString("description"));
                bean.setDisappear_at(object.getString("disappear_at"));
                bean.setGender(object.getString("gender"));
                bean.setId(object.getInt("id"));
                bean.setNickname(object.getString("nickname"));
                bean.setKind(object.getString("kind"));
                bean.setIs_anonymous(object.getInt("is_anonymous"));
                bean.setReward(object.getInt("reward"));
                bean.setPhoto_thumbnail_src(object.getString("photo_thumbnail_src"));
                list.add(bean);
            }
           ArrayList<Question> q ;
            q=list;
            list.clear();
            for (int i = 9,j =0; i >=0; i--,j++) {
                list.add(j,q.get(i));
            }
        } catch (JSONException e) {
            Log.d("JSONManager",e.toString());
            e.printStackTrace();
        }
       return list;

    }
}
