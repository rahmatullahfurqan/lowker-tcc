package tcc.example.com.lowonganpekerjaan.Signin;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import tcc.example.com.lowonganpekerjaan.Model.Login;
import tcc.example.com.lowonganpekerjaan.Model.User;
import tcc.example.com.lowonganpekerjaan.Service;

public class SigninPresenter {
    SigninContract signinContract;
    Service service = new Service();
    ResponseBody user;
    public SigninPresenter(SigninContract view){
        signinContract=view;
    }
    public void getLogin(String username , String password){
        Login login=new Login(username,password);
        service.getAPI().getResultLogin(login).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()){
                    if (response.code()==401)
                    {
                        user=response.errorBody();
                        signinContract.wrongPass(9);
                    }
                    else if (response.code()==409)
                    {
                        signinContract.wrongPass(1);
                    }
                }
                else {
                    signinContract.loginFailed(response.message());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                signinContract.loginFailed(t.getMessage());
            }
        });
    }
}
