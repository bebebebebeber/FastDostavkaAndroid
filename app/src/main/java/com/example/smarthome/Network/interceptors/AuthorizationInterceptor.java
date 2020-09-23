package com.example.smarthome.Network.interceptors;

import com.example.smarthome.application.HomeApplication;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthorizationInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request newRequest = chain.request().newBuilder()
                .build();
        Response response = chain.proceed(newRequest);

//        if (response.code() == 401) {
//            HomeApplication context = (HomeApplication) HomeApplication.getAppContext();
//            NavigationHost navigationHost = (NavigationHost) context.getCurrentActivity();
//            navigationHost.navigateTo(new LoginFragment(), false);
//          //  return response;
//        }
        return response;
    }
}
