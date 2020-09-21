package com.example.smarthome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.toolbox.NetworkImageView;
import com.example.smarthome.Network.ImageRequester;

public class MainActivity extends AppCompatActivity {

    private ImageRequester imageRequester;
    private NetworkImageView editImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageRequester = ImageRequester.getInstance();
        editImage = findViewById(R.id.chooseImage);

        setContentView(R.layout.activity_main);
        imageRequester.setImageFromUrl(editImage, "https://img.kub.in.ua/webp_cache/f1e3a7245f/577b4748a670671bc9dbb74656c84f05-700-580-default.webp");

    }
}