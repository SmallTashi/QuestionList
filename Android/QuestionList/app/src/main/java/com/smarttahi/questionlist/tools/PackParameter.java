package com.smarttahi.questionlist.tools;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;

public class PackParameter {
    public static String User_Key(String stuNum, String idNum) {
        return "stuNum=" + stuNum + "&idNum=" + idNum;
    }

    public static String User_Remind(String stuNum, String idNum,String before_time,String content,String time_id,String date){
        return "stuNum=" + stuNum + "&idNum=" + idNum + "&before_time=" + before_time + "&content=" + content + "&time_id=" + time_id + "&date=" + date ;
    }

    public static String User_Remind_Del(String stuNum, String idNum,String id) {
        return "stuNum=" + stuNum + "&idNum=" + idNum+"&id"+id;
    }


    //stuNum=2017211566&idNum=252849&title=功能是真的写不完&description=代码量是真的多。就很烦&is_anonymous=0&kind=其他&tags=PHP&reward=1&disappear_time=2018-08-01 00:00:00
    public static String Question_Add(int stuNum, int idNum, String title, String description, int is_anonymous, String kind, String reward, String disappear_time) {
        return "stuNum=" + stuNum + "&idNum=" + idNum + "&title=" + title + "&description=" + description + "&is_anonymous=" + is_anonymous + "&kind=" + kind + "&tags=PHP&reward=" + reward + "&disappear_time=" + disappear_time;
    }

    //page=3&size=1&kind=其他
    public static String Question_List(String page, String kind) {
        return "page=" + page +"&size=10"+ "&kind=" + kind;
    }

    //stuNum=2017211566&idNum=252849&question_id=81
    public static String Question_Cancel_Detail(int stuNum, int idNum, int QuestionId) {
        return "stuNum=" + stuNum +"&idNum=" + idNum + "&question_id" + QuestionId;
    }

    public static String Picture(int stuNum, int idNum, int QuestionId, Bitmap photo1,@Nullable Bitmap photo2,@Nullable Bitmap photo3) {
        String s="stuNum=" + stuNum + "&idNum=" + idNum + "&question_id" + QuestionId+"&photo1"+photo1;

        if(photo2!=null){
            if(photo3!=null){
                s= "stuNum=" + stuNum +  "&idNum=" + idNum + "&question_id" + QuestionId+"&photo1"+photo1+"&photo2"+photo2+"&photo1"+photo3;
            }
            s= "stuNum=" + stuNum  + "&idNum=" + idNum + "&question_id" + QuestionId+"&photo1"+photo1+"&photo2"+photo2;

        }
        return s;
    }

    public static String Answer_Create(int stuNum, int idNum, String content,int QuestionId) {
        return "stuNum=" + stuNum + "&idNum=" + idNum +"&content"+content+ "&question_id" + QuestionId;
    }

    public static String Answer_List_Question(int stuNum, int idNum,int QuestionId) {
        return "stuNum=" + stuNum + "&idNum=" + idNum +"&question_id" + QuestionId;
    }

    public static String Answer_Praise_Comment(int stuNum, int idNum,int AnswerId) {
        return "stuNum=" + stuNum + "&idNum=" + idNum +"&answer_id" + AnswerId;
    }

    public static String Answer_List_Comment(int stuNum, int idNum,int AnswerId,String content) {
        return "stuNum=" + stuNum + "&idNum=" + idNum +"&answer_id" + AnswerId+"&content"+content;
    }

    public static String Answer_Adopt(int stuNum, int idNum,int AnswerId,int QuestionId) {
        return "stuNum=" + stuNum + "&idNum=" + idNum +"&answer_id" + AnswerId+"&question_id" + QuestionId;
    }

    public static String Course(int stuNum,Boolean forceFetch){
        return "stuNum="+stuNum+"&forceFetch"+forceFetch;
    }

}
