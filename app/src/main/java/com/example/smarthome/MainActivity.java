package com.example.smarthome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.smarthome.Network.ImageRequester;

public class MainActivity extends AppCompatActivity {

    private ImageRequester imageRequester;
    private NetworkImageView editImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageRequester = ImageRequester.getInstance();
        editImage =findViewById(R.id.photo);
        NetworkImageView nv = (NetworkImageView) findViewById(R.id.photo);
        imageRequester.setImageFromUrl(editImage, "http://10.0.2.2/Images/div4una.jpg");

    }
}