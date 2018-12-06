package tcc.example.com.lowonganpekerjaan.View.Activity.Signin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tcc.example.com.lowonganpekerjaan.Model.Login;
import tcc.example.com.lowonganpekerjaan.Model.User;
import tcc.example.com.lowonganpekerjaan.Service;

public class SigninPresenter {
    SigninContract signinContract;
    Service service = new Service();
    public SigninPresenter(SigninContract view){
        signinContract=view;
    }
    public void getLogin(String username , String password){
        Login login=new Login(username,password);
        service.getAPI().getResultLogin(login).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.code() == 200) {
                    signinContract.loginSuccess(response.body());
                } else if (response.code() == 409) {
                    signinContract.wrongPass();
                } else {
                    signinContract.loginFailed();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                signinContract.loginFailed();
            }
        });
    }
}
