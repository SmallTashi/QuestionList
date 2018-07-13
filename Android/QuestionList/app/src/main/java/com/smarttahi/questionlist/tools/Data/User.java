package com.smarttahi.questionlist.tools.Data;

import android.os.Parcel;
import android.os.Parcelable;


public class User implements Parcelable {
    /**
     * stuNum : 2016210xxx
     * stuname : 李吉
     * college : 通信与信息工程学院
     * class : 01041602班
     * classNum : 01041602
     * gender : 男
     * major : 0104
     * grade : 2016
     * idNum : xxxxx
     */

    private String stuNum="";
    private String name="";
    private String college="";
    private String classX="";
    private String classNum="";
    private String gender="";
    private String major="";
    private String grade="";
    private String idNum="";
    /**
     * id : 2828
     * introduction : An Android Developer
     * nickname : Jay
     * photo_thumbnail_src : http://wx.idsbllp.cn/cyxbsMobile/Public/photo/thumbnail/1520430636_1133226083.png
     * photo_src : http://wx.idsbllp.cn/cyxbsMobile/Public/photo/1520430636_1133226083.png
     * updated_time : 2018-05-05 23:15:35
     * phone : 159235xxxxx
     * qq : 14325xxxxx
     */
    private int id;
    private String introduction="";
    private String nickname="";
    private String photo_thumbnail_src="";
    private String photo_src="";
    private String updated_time="";
    private String phone="";
    private String qq="";

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getClassX() {
        return classX;
    }

    public void setClassX(String classX) {
        this.classX = classX;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public User() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoto_thumbnail_src() {
        return photo_thumbnail_src;
    }

    public void setPhoto_thumbnail_src(String photo_thumbnail_src) {
        this.photo_thumbnail_src = photo_thumbnail_src;
    }

    public String getPhoto_src() {
        return photo_src;
    }

    public void setPhoto_src(String photo_src) {
        this.photo_src = photo_src;
    }

    public String getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(String updated_time) {
        this.updated_time = updated_time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.stuNum);
        dest.writeString(this.name);
        dest.writeString(this.college);
        dest.writeString(this.classX);
        dest.writeString(this.classNum);
        dest.writeString(this.gender);
        dest.writeString(this.major);
        dest.writeString(this.grade);
        dest.writeString(this.idNum);
        dest.writeInt(this.id);
        dest.writeString(this.introduction);
        dest.writeString(this.nickname);
        dest.writeString(this.photo_thumbnail_src);
        dest.writeString(this.photo_src);
        dest.writeString(this.updated_time);
        dest.writeString(this.phone);
        dest.writeString(this.qq);
    }

    User(Parcel in) {
        this.stuNum = in.readString();
        this.name = in.readString();
        this.college = in.readString();
        this.classX = in.readString();
        this.classNum = in.readString();
        this.gender = in.readString();
        this.major = in.readString();
        this.grade = in.readString();
        this.idNum = in.readString();
        this.id = in.readInt();
        this.introduction = in.readString();
        this.nickname = in.readString();
        this.photo_thumbnail_src = in.readString();
        this.photo_src = in.readString();
        this.updated_time = in.readString();
        this.phone = in.readString();
        this.qq = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}




