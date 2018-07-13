package com.smarttahi.questionlist.tools.Data;

public class OthersOperation {
   class AnswerQuestion{

       /**
        * status : 200
        * info : success
        * data : 12 //返回问题ID
        */
       public static final String ANSWER_QUESTION ="https://wx.idsbllp.cn/springtest/cyxbsMobile/index.php/QA/Answer/add";

       private int status;
       private String info;
       private String data;

       public int getStatus() {
           return status;
       }

       public void setStatus(int status) {
           this.status = status;
       }

       public String getInfo() {
           return info;
       }

       public void setInfo(String info) {
           this.info = info;
       }

       public String getData() {
           return data;
       }

       public void setData(String data) {
           this.data = data;
       }
   }
   class like{

       /**
        * status : 200
        * info : success
        */
       public static final String LIKE ="https://wx.idsbllp.cn/springtest/cyxbsMobile/index.php/QA/Answer/praise";
       public static final String UNLIKE = "https://wx.idsbllp.cn/springtest/cyxbsMobile/index.php/QA/Answer/cancelPraise";

       private int status;
       private String info;

       public int getStatus() {
           return status;
       }

       public void setStatus(int status) {
           this.status = status;
       }

       public String getInfo() {
           return info;
       }

       public void setInfo(String info) {
           this.info = info;
       }
   }



}
