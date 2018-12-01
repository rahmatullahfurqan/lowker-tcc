package tcc.example.com.lowonganpekerjaan;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    Retrofit retrofit = null;

    public DataApi getAPI(){

        String BASE_URL = "https://loker-api.herokuapp.com/api/";
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(DataApi.class);
    }
}
