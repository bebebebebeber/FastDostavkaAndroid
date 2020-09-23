package com.example.smarthome.Network.interceptors;

import android.content.Context;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import com.example.smarthome.Network.utils.ConnectionInternetError;
import com.example.smarthome.Network.utils.NetworkUtil;
import com.example.smarthome.application.HomeApplication;


public class ConnectivityInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Context context= HomeApplication.getAppContext();
        Request originalRequest = chain.request();

        if (!NetworkUtil.isOnline(context)) {
            HomeApplication covidApplication = (HomeApplication) context;
//            ConnectionInternetError errorNavigation = (ConnectionInternetError) covidApplication.getCurrentActivity();
//            errorNavigation.navigateErrorPage();

        }
        Request newRequest = originalRequest.newBuilder()
                .build();
        return chain.proceed(newRequest);
    }
}