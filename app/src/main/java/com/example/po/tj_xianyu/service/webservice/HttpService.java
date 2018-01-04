package com.example.po.tj_xianyu.service.webservice;

import java.util.concurrent.TimeUnit;

import okhttp3.*;
/**
 * Created by 13701 on 2017/12/25.
 */

public class HttpService {
    private static OkHttpClient client = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();
    //private static final String LOGIN_URL = "http://180.160.26.153:8080/JDBC/Hello";
    private static final String IP_ADDRESS = "fwhpopopo.cn";
    //private static final String IP_ADDRESS = "180.160.3.127";
    private static String LOGIN_URL = "http://"+IP_ADDRESS+":8080/XianyuServer/";
    //private static String LOGIN_URL = "http://192.168.5.61:8080/JDBC/";
    public static void  sendOkHttpRequest(String command,okhttp3.RequestBody requestBody,okhttp3.Callback callback){
        //OkHttpClient client = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();
        final Request request = new Request.Builder().post(requestBody).url(LOGIN_URL+command).build();
        client.newCall(request).enqueue(callback);
    }

    public static void sendOkHttpRequest(String url,okhttp3.Callback callback){
        final Request request = new Request.Builder().get().url(url).build();
        client.newCall(request).enqueue(callback);
    }

    //public static void sendOkHttpGetRequest()
}
