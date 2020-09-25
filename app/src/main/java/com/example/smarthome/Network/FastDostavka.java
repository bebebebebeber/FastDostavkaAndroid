package com.example.smarthome.Network;

import com.example.smarthome.Network.models.Profile;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface FastDostavka {
    @POST("/api/auth/login")
    public Call<Tokens> login(@Body Login m);
    @POST("/api/auth/refresh")
    public Call<Tokens> refresh(@Body Refresh m);
    @GET("/api/account/profile")
    public Call<Profile> profile();
//    @GET("/posts")
//    public Call<List<Post>> getAllPosts();
}
