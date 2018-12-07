package tcc.example.com.lowonganpekerjaan.View.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tcc.example.com.lowonganpekerjaan.R;
import tcc.example.com.lowonganpekerjaan.View.Activity.Signin.SigninActivity;

public class SplashActivity extends AppCompatActivity {
    SharedPreferences userDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        userDetails = getSharedPreferences("userdetails",  Context.MODE_PRIVATE);
        if (!userDetails.getString("username","").equals("")){
            startActivity(new Intent(SplashActivity.this,MainActivity.class));
        }
        else
        {
            startActivity(new Intent(SplashActivity.this,SigninActivity.class));
        }
    }
}
