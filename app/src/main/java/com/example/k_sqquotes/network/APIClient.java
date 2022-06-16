package com.example.k_sqquotes.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

//    public static final String BASE_URL="http://192.168.43.224/io.ksq/";
public static final String BASE_URL="http://192.168.20.243/io.ksq/";

    public static Retrofit getClient(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
    public static APIinterface apIinterface(){
        return getClient().create(APIinterface.class);
    }
}
