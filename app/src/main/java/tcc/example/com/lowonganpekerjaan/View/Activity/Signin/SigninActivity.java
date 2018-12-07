package tcc.example.com.lowonganpekerjaan.View.Activity.Signin;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import tcc.example.com.lowonganpekerjaan.Model.User;
import tcc.example.com.lowonganpekerjaan.View.Activity.MainActivity;
import tcc.example.com.lowonganpekerjaan.R;
import tcc.example.com.lowonganpekerjaan.View.Activity.Signup.SignupActivity;


public class SigninActivity extends AppCompatActivity implements SigninContract {
    private EditText pass, user;
    private String password,username;
    private Button masuk, daftar;
    private SharedPreferences userDetails;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        userDetails = getSharedPreferences("userdetails",  Context.MODE_PRIVATE);
        pass = findViewById(R.id.et_signin_pass);
        user = findViewById(R.id.et_signin_user);
        progressBar=findViewById(R.id.progres_bar);
        progressBar.setVisibility(View.INVISIBLE);
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
            progressBar.setVisibility(View.VISIBLE);
            new SigninPresenter(this).getLogin(username, password);
        }
        }

    @Override
    public void signup() {
        startActivity(new Intent(this, SignupActivity.class));
    }

    @Override
    public void formBelumLegkap() {
        Toast.makeText(this, "Harap isi semua", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void wrongPass() {
        Toast.makeText(this,"username atau password salah", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess(User user) {
        progressBar.setVisibility(View.INVISIBLE);
        SharedPreferences.Editor edit = userDetails.edit();
        edit.putString("username",username);
        edit.putString("password",password);
        edit.putString("id",String.valueOf(user.getId()));
        edit.putString("address",user.getAddres());
        edit.putString("name",user.getFirstName()+" "+user.getLastName());
        edit.putString("age",String.valueOf(user.getAge()));
        edit.commit();
        Toast.makeText(getApplicationContext(),"berhasil login",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
    @Override
    public void loginFailed() {
        Toast.makeText(getApplicationContext(),"gagal",Toast.LENGTH_SHORT).show();
    }


}
