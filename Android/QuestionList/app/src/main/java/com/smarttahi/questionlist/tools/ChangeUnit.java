package com.smarttahi.questionlist.tools;

import android.content.Context;
import android.util.TypedValue;

public  class ChangeUnit {
    public static int dp2px(Context context,float px){
       return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,px,context.getResources().getDisplayMetrics());
    }

    public static int sp2px(Context context,float px){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,px,context.getResources().getDisplayMetrics());

    }

    public static int pt2px(Context context,float pt){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PT,pt,context.getResources().getDisplayMetrics());
    }

    public static int px2dp(Context context ,int px){
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(px/scale+(0.5f)*(px>0?1:-1));
    }

    public static int px2sp(Context context ,int px){
        float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int)(px/scale+0.5f);
    }

    public static int pt2sp(Context context,float pt){
      return px2sp(context,pt2px(context,pt));
    }

    public static int pt2dp(Context context,float pt){
        int px=pt2px(context,pt);
        return px2dp(context,px);
    }


}
