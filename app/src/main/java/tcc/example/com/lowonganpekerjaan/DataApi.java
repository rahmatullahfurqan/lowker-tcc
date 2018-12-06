package tcc.example.com.lowonganpekerjaan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import tcc.example.com.lowonganpekerjaan.Model.DataKetertarikanResponse;
import tcc.example.com.lowonganpekerjaan.Model.Login;
import tcc.example.com.lowonganpekerjaan.Model.Pekerjaan;
import tcc.example.com.lowonganpekerjaan.Model.Signup;
import tcc.example.com.lowonganpekerjaan.Model.User;

public interface DataApi {

    @Headers("Content-Type: application/json")
    @POST("login")
    Call<User> getResultLogin(@Body Login login);

    @GET("vacancies")
    Call<List<Pekerjaan>> getVacancies();

    @GET("user/{id}")
    Call<User> getProfile(@Path("id")String id);

    @Headers("Content-Type: application/json")
    @POST("user")
    Call<Void> setDataUser(@Body Signup data);

    @FormUrlEncoded
    @POST("simpandata.php")
    Call<DataKetertarikanResponse> setDataKetertarikan(@Field("username") String username,
                                                       @Field("name") String name,
                                                       @Field("age") String age,
                                                       @Field("address") String address,
                                                       @Field("id_user") String idUser,
                                                       @Field("id_vacancies") String idVacancies,
                                                       @Field("name_vacancies") String nameVacancies,
                                                       @Field("description_vacancies") String detailVacancies);
}
