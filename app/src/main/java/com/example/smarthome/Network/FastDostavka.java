package com.example.smarthome.Network;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface FastDostavka {
    @POST("/api/auth/login")
    public Call<Tokens> login(@Body Login m);
//    @GET("/posts")
//    public Call<List<Post>> getAllPosts();
}
