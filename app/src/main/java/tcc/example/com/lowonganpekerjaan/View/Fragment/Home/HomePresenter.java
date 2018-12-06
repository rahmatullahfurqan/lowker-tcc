package tcc.example.com.lowonganpekerjaan.View.Fragment.Home;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tcc.example.com.lowonganpekerjaan.Model.Pekerjaan;
import tcc.example.com.lowonganpekerjaan.Service;

public class HomePresenter {
    Service service = new Service();
    HomeView homeView;
    public HomePresenter(HomeView view)
    {
        this.homeView=view;
    }
    public void getData()
    {
         service.getAPI().getVacancies().enqueue(new Callback<List<Pekerjaan>>() {
             @Override
             public void onResponse(Call<List<Pekerjaan>> call, Response<List<Pekerjaan>> response) {
                 if (response.code()==200)
                 {
                     homeView.getDataSuccses(response.body());
                 }
                 else
                 {
                     homeView.getDataFailed();
                 }
             }

             @Override
             public void onFailure(Call<List<Pekerjaan>> call, Throwable t) {
                    homeView.getDataFailed();
             }
         });
    }
}
