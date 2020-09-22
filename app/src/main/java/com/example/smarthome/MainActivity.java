package com.example.smarthome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.smarthome.Network.ImageRequester;
import com.example.smarthome.Network.Login;
import com.example.smarthome.Network.NetworkService;
import com.example.smarthome.Network.Tokens;
import com.example.smarthome.constants.Urls;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //private ImageRequester imageRequester;
    private NetworkImageView editImage;
    private Button loginButton;
    public void saveJWTToken(String token) {
        SharedPreferences prefs;
        SharedPreferences.Editor edit;
        prefs=this.getSharedPreferences("jwtStore", Context.MODE_PRIVATE);
        edit=prefs.edit();
        try {
            edit.putString("token",token);
            Log.i("Login",token);
            edit.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton = (Button) findViewById(R.id.button);
        //imageRequester = ImageRequester.getInstance();
        //editImage =findViewById(R.id.photo);
        //NetworkImageView nv = (NetworkImageView) findViewById(R.id.photo);
        //imageRequester.setImageFromUrl(editImage, Urls.BASE_URL+"Images/div4una.jpg");

    }

    public void click(View view) {
        final TextInputEditText password = findViewById(R.id.password);
        final TextInputEditText email = findViewById(R.id.email);
        final TextInputLayout passwordLayout = findViewById(R.id.passwordLayout);
        final TextInputLayout emailLayout = findViewById(R.id.emailLayout);
        if(email.getText().toString()==""||password.getText().toString()==""){
            passwordLayout.setError("Fill all fields!");
        }
        else{
            passwordLayout.setError("");
        }


        Login m = new Login();
        m.setEmail(email.getText().toString());
        m.setPassword(password.getText().toString());
        NetworkService.getInstance()
                .getJSONApi()
                .login(m)
                .enqueue(new Callback<Tokens>() {
                    @Override
                    public void onResponse(@NonNull Call<Tokens> call, @NonNull Response<Tokens> response) {

                        //textView.append(post.getId() + "\n");
                        //textView.append(post.getUserId() + "\n");
                        //textView.append(post.getTitle() + "\n");
                        //textView.append(post.getBody() + "\n");
                        if(response.errorBody()==null&&response.isSuccessful()){
                            passwordLayout.setError("");
                            //loginButton.setError("");
                            Tokens post = response.body();
                            Toast toast = Toast.makeText(getApplicationContext(), "All done! your ref token :" + post.getRefreshToken(), Toast.LENGTH_LONG);
                            toast.show();
                            saveJWTToken(post.getToken());
                        }
                        else{
                            //emailLayout.setError("");
                            //password.setError("Login or password was wrong");
                            passwordLayout.setError("Login or password was wrong");
                            loginButton.setError("Login or password was wrong");
                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<Tokens> call, @NonNull Throwable t) {

                        //textView.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
//        Intent intent = new Intent(this, MenuSideBarActivity.class);
//        startActivity(intent);
    }
}