package tcc.example.com.lowonganpekerjaan;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    Retrofit retrofit = null;

    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build();

    public DataApi getAPI(){

        String BASE_URL = "https://loker-api.herokuapp.com/api/";
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(DataApi.class);
    }
    public DataApi setDataAPI(){
        String BASE_URL = "http://agusart.tk/api/v2/";
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(DataApi.class);
    }
}
