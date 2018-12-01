package tcc.example.com.lowonganpekerjaan.Signin;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tcc.example.com.lowonganpekerjaan.MainActivity;
import tcc.example.com.lowonganpekerjaan.R;


public class SigninActivity extends AppCompatActivity implements SigninContract {
    private EditText pass, user;
    private String password,username;
    private Button masuk, daftar;
    private SharedPreferences userDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        userDetails = this.getSharedPreferences("userdetails",  Context.MODE_PRIVATE);
        if (!userDetails.getString("username","").equals("")){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }
        pass = findViewById(R.id.et_signin_pass);
        user = findViewById(R.id.et_signin_user);
        daftar = findViewById(R.id.btn_signin_daftar);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
        masuk = findViewById(R.id.btn_signin_masuk);
        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();
            }
        });


    }

    @Override
    public void checkLogin() {
        password = pass.getText().toString();
        username = user.getText().toString();
        if (username.equals("") || password.equals("")){
            formBelumLegkap();
        }
        else {
            new SigninPresenter(this).getLogin(username, password);
        }
        }

    @Override
    public void signup() {
        //startActivity(new Intent(this, SignupActivity.class));
    }

    @Override
    public void formBelumLegkap() {
        Toast.makeText(this, "Harap isi semua", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void wrongPass(int i) {
        Toast.makeText(this, String.valueOf(i), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        SharedPreferences.Editor edit = userDetails.edit();
        edit.putString("username",username);
        edit.putString("password",password);
        edit.commit();
        Toast.makeText(getApplicationContext(),"sukses cuk",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
    @Override
    public void loginFailed(String f) {
        Toast.makeText(getApplicationContext(),f,Toast.LENGTH_SHORT).show();
    }

}
