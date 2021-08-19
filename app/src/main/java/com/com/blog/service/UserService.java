package com.com.blog.service;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {
    @GET("/posts/{id}")
    Call<String> findById(@Path("id") int id);

    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://192.168.0.9:8080")
            .build();

    UserService service = retrofit.create(UserService.class);
}
