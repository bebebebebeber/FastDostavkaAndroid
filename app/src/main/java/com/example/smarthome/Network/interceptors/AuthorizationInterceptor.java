package com.example.smarthome.Network.interceptors;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import com.example.smarthome.BaseActivity;
import com.example.smarthome.application.HomeApplication;


import java.io.IOException;
import java.util.concurrent.Executor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthorizationInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request newRequest = chain.request().newBuilder()
                .build();
        Response response = chain.proceed(newRequest);

        if (response.code() == 401) {
            HomeApplication context = (HomeApplication) HomeApplication.getAppContext();
            BaseActivity a = (BaseActivity) context.getCurrentActivity();
            BiometricPrompt.PromptInfo promptI = new BiometricPrompt.PromptInfo.Builder()
                    .setTitle("Підтверження входу в додаток")
                    .setSubtitle("Підтвердіть ваші біометричні дані")
                    .setDeviceCredentialAllowed(true)
                    // Can't call setNegativeButtonText() and
                    // setAllowedAuthenticators(...|DEVICE_CREDENTIAL) at the same time.
                    // .setNegativeButtonText("Use account password")
                    .build();
            Executor executor = ContextCompat.getMainExecutor(context);
            BiometricPrompt bp = new BiometricPrompt(a, executor, new BiometricPrompt.AuthenticationCallback() {
                @Override
                public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                    Toast.makeText(HomeApplication.getAppContext(),
                            "Authentication error", Toast.LENGTH_SHORT)
                            .show();
                }

                @Override
                public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                    Toast.makeText(HomeApplication.getAppContext(),
                            "Authentication succeeded!", Toast.LENGTH_SHORT)
                            .show();
                }

                @Override
                public void onAuthenticationFailed() {
                    Toast.makeText(HomeApplication.getAppContext(), "Authentication failed",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            });
            bp.authenticate(promptI);
//            NavigationHost navigationHost = (NavigationHost) context.getCurrentActivity();
//            navigationHost.navigateTo(new LoginFragment(), false);
          //  return response;
        }
        return response;
    }
}
