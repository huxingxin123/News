package com.example.hxx.test4.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OkHttp {
    public static void OkHttpConnection(String address,okhttp3.Callback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
    public static void OkHttpConnectionPost(String address, final RequestBody body,final okhttp3.Callback callback){
        OkHttpClient client=new OkHttpClient();
        Request request= new Request.Builder().url(address).post(body).build();
        client.newCall(request).enqueue(callback);
    }
}
