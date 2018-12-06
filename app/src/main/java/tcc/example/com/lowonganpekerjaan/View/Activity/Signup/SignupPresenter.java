package tcc.example.com.lowonganpekerjaan.View.Activity.Signup;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tcc.example.com.lowonganpekerjaan.Model.Signup;
import tcc.example.com.lowonganpekerjaan.Model.User;
import tcc.example.com.lowonganpekerjaan.Service;

public class SignupPresenter {
    Service service=new Service();
    SignupView signupView;
    public SignupPresenter (SignupView view)
    {
        this.signupView=view;
    }
    public void setData(Signup data)
    {
        service.getAPI().setDataUser(data).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code()==200)
                {
                    signupView.setDataSuccess();
                }
                else
                {
                    signupView.dataAda();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                signupView.setDataFailure();
            }
        });
    }
}
