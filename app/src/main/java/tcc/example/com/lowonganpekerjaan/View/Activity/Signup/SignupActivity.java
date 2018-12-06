package tcc.example.com.lowonganpekerjaan.View.Activity.Signup;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tcc.example.com.lowonganpekerjaan.Model.Signup;
import tcc.example.com.lowonganpekerjaan.R;
import tcc.example.com.lowonganpekerjaan.View.Activity.Signin.SigninActivity;

public class SignupActivity extends AppCompatActivity implements SignupView{

    EditText etFirstName,etLastName,etAge,etEmail,etPassword,etAddress,etPasswordConfirm;
    Button btnSignup;
    SignupPresenter signupPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initView();
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });
    }
    private void initView(){
        etAddress=findViewById(R.id.et_signup_address);
        etAge=findViewById(R.id.et_signup_age);
        etEmail=findViewById(R.id.et_signup_email);
        etFirstName=findViewById(R.id.et_signup_namadepan);
        etLastName=findViewById(R.id.et_signup_namabelakang);
        etPassword=findViewById(R.id.et_signup_password);
        etPasswordConfirm=findViewById(R.id.et_signup_passwordconfirm);
        btnSignup=findViewById(R.id.btn_signup_daftar);

    }

    public void check()
    {

        if (etFirstName.getText().toString().equals("") || etLastName.getText().toString().equals("")
                || etEmail.getText().toString().equals("") || etAge.getText().toString().equals("")
                || etPassword.getText().toString().equals(""))
        {
            formBelumLegkap();
        }
        else if (!etPassword.getText().toString().equals(etPasswordConfirm.getText().toString()))
        {
            wrongPass();
        }
        else
        {
            inputData();
        }
    }
    public void wrongPass()
    {
        Toast.makeText(getApplicationContext(),"Password tidak sama",Toast.LENGTH_SHORT).show();
        etPassword.setText("");
        etPasswordConfirm.setText("");
    }
    public void formBelumLegkap() {
        Toast.makeText(this, "Harap isi semua", Toast.LENGTH_SHORT).show();
    }

    public void inputData()
    {
        Signup data = new Signup();
        data.setAddres(etAddress.getText().toString());
        data.setAge(etAge.getText().toString());
        data.setFirst_name(etFirstName.getText().toString());
        data.setLast_name(etLastName.getText().toString());
        data.setPassword(etPassword.getText().toString());
        data.setUsername(etEmail.getText().toString());
        signupPresenter = new SignupPresenter(this);
        signupPresenter.setData(data);
    }

    @Override
    public void setDataSuccess() {
        Toast.makeText(getApplicationContext(),"pendaftaran berhasil, login untuk masuk",Toast.LENGTH_SHORT).show();
        SharedPreferences userDetails = getSharedPreferences("userdetails",  Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = userDetails.edit();
        edit.putString("username","");
        edit.putString("password","");
        edit.putString("id","");
        edit.commit();
        startActivity(new Intent(getApplicationContext(), SigninActivity.class));
    }

    @Override
    public void setDataFailure() {
        Toast.makeText(getApplicationContext(),"ussername telah ada",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dataAda() {
        Toast.makeText(getApplicationContext(),"username telah ada",Toast.LENGTH_SHORT).show();
    }
}
