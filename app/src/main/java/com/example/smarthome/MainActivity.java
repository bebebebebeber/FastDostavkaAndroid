package com.example.smarthome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.smarthome.Network.ImageRequester;
import com.example.smarthome.constants.Urls;

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
        imageRequester.setImageFromUrl(editImage, Urls.BASE_URL+"Images/div4una.jpg");

    }
    public void click(View view){
        Intent intent = new Intent(this, MenuSideBarActivity.class);
        startActivity(intent);
    }
}