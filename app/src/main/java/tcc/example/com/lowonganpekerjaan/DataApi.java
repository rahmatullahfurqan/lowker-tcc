package tcc.example.com.lowonganpekerjaan;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import tcc.example.com.lowonganpekerjaan.Model.Login;
import tcc.example.com.lowonganpekerjaan.Model.User;

public interface DataApi {

    @Headers("Content-Type: application/json")
    @POST("login")
    Call<User> getResultLogin(@Body Login login);
}
