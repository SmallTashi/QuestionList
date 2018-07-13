package com.smarttahi.questionlist.tools;

import android.os.Handler;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpRequest {

    private static OutputStream out = null;

    private static HttpsURLConnection connection = null;

    public static void sentHttpsRequest(final String parameter, final String api, final Callback callback) {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(api);
                    connection = (HttpsURLConnection) url.openConnection();
                    connection.setReadTimeout(5 * 1000);
                    connection.setConnectTimeout(10 * 1000);
                    connection.setRequestMethod("POST");
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.setUseCaches(false);
                    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    connection.connect();
                    out = connection.getOutputStream();
                    out.write(parameter.getBytes());
                    out.flush();
                    out.close();
                    Log.d("Tag",String.valueOf(connection.getResponseCode()));
                    if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        final byte[] in = ReadStream(connection.getInputStream());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Response data = new Response(in);
                                Log.d("Tag", data.getDate());
                                if(data.getDate()!=null&&data.getDate().length()!=0){
                                    callback.onSuccess(data);
                                }
                                else callback.onFiled(new Exception("No data"));
                             }
                        });
                    } else {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Log.d("Tag",String.valueOf(connection.getResponseCode()));
                                    callback.onFiled(new Exception(String.valueOf(connection.getResponseCode())));
                                } catch (IOException e) {
                                    callback.onFiled(e);
                                }
                            }
                        });
                    }
                } catch (final ProtocolException e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFiled(e);
                        }
                    });
                } catch (final IOException e) {
                    e.printStackTrace();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFiled(e);
                        }
                    });
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                    if (out!=null){
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

    public static class Response {
        private int State;
        private String Info;
        private String Date;
        Response(byte[] response) {
            String rawDate = new String(response);
            try {
                JSONObject object = new JSONObject(rawDate);
                State = object.getInt("status");
                Info = object.getString("info");
                Date = object.getString("data");
            } catch (JSONException e) {
                e.printStackTrace();
                Date = null;
            }
        }

        public String getInfo() {
            return Info;
        }

        public String getDate() {
            return Date;
        }

        public int getState() {
            return State;
        }
    }

    public interface Callback {
        void onSuccess(Response response);

        void onFiled(Exception e);
    }

    private static byte[] ReadStream(InputStream in) {
        //内存
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //创建保存数据的字节数组
        byte[] temp = new byte[1024];
        //开始读取数据
        int len;
        try {
            if (in != null) {
                while ((len = in.read(temp)) != -1) {
                    outputStream.write(temp, 0, len);
                    //数据由输入流写入字节数组，
                    //由字节数组写入到输出流中
                }
                in.close();
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }
}
