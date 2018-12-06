package tcc.example.com.lowonganpekerjaan.View.Fragment.Profile;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tcc.example.com.lowonganpekerjaan.Model.User;
import tcc.example.com.lowonganpekerjaan.Service;

public class ProfilePresenter {
    Service service = new Service();
    ProfileView profileView;
    public  ProfilePresenter(ProfileView view)
    {
        this.profileView=view;
    }
    public void getData(String id)
    {
        service.getAPI().getProfile(String.valueOf(id)).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.code()==200)
                {
                    profileView.onSuccses(response.body());
                }
                else
                {
                    profileView.onFailed();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                profileView.onFailed();
            }
        });
    }
}
