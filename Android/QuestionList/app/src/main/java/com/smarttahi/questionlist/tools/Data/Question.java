package com.smarttahi.questionlist.tools.Data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;


/**
 * status : 200
 * info : success
 * data : [{"title":"又在写bug\\\\ue056","description":"bug是真的多","kind":"其他","tags":"PHP","reward":2,"answer_num":0,"disappear_at":"2019-02-27 01:11:20","created_at":"2018-05-19 17:35:14","is_anonymous":0,"id":52,"photo_thumbnail_src":"","nickname":"。","gender":"女"}]
 * <p>
 * title : 又在写bug\\ue056
 * description : bug是真的多
 * kind : 其他
 * tags : PHP
 * reward : 2
 * answer_num : 0
 * disappear_at : 2019-02-27 01:11:20
 * created_at : 2018-05-19 17:35:14
 * is_anonymous : 0
 * id : 52
 * photo_thumbnail_src :
 * nickname : 。
 * gender : 女
 */
public class Question implements Parcelable {


    public String title;
    private String description;
    private String kind;
    private String tags;
    private int reward;
    private int answer_num;
    private String disappear_at;
    private String created_at;
    private int is_anonymous;
    public int id;
    private byte photo_thumbnail_src;
    private String nickname;
    private String gender;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getAnswer_num() {
        return answer_num;
    }

    public void setAnswer_num(int answer_num) {
        this.answer_num = answer_num;
    }

    public String getDisappear_at() {
        return disappear_at;
    }

    public void setDisappear_at(String disappear_at) {
        this.disappear_at = disappear_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getIs_anonymous() {
        return is_anonymous;
    }

    public void setIs_anonymous(int is_anonymous) {
        this.is_anonymous = is_anonymous;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getPhoto_thumbnail_src() {
        return photo_thumbnail_src;
    }

    public void setPhoto_thumbnail_src(String photo_thumbnail_src) {
        //TODO 图片加载
        byte bitmap = 0;
        this.photo_thumbnail_src = bitmap;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.kind);
        dest.writeString(this.tags);
        dest.writeInt(this.reward);
        dest.writeInt(this.answer_num);
        dest.writeString(this.disappear_at);
        dest.writeString(this.created_at);
        dest.writeInt(this.is_anonymous);
        dest.writeInt(this.id);
        dest.writeByte(this.photo_thumbnail_src);
        dest.writeString(this.nickname);
        dest.writeString(this.gender);
    }

    public Question() {
    }

    private Question(Parcel in) {
        this.title = in.readString();
        this.description = in.readString();
        this.kind = in.readString();
        this.tags = in.readString();
        this.reward = in.readInt();
        this.answer_num = in.readInt();
        this.disappear_at = in.readString();
        this.created_at = in.readString();
        this.is_anonymous = in.readInt();
        this.id = in.readInt();
        this.photo_thumbnail_src = in.readByte();
        this.nickname = in.readString();
        this.gender = in.readString();
    }

    public static final Parcelable.Creator<Question> CREATOR = new Parcelable.Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel source) {
            return new Question(source);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };
}


