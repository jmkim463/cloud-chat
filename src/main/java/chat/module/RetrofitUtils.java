package chat.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class RetrofitUtils {

    private final static String BASE_URL = "http://127.0.0.1:8080";

    public static Retrofit createRetrofit() {
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }

    public static <T> T createService(Class<T> serviceClass) {
        T service = createRetrofit().create(serviceClass);
        return service;
    }

    public static <T> Response<T> execute(Call<T> call) {
        try {
            return call.execute();
        } catch (IOException e) {
            //서버 오류 ~~~~~~~
            return null;
        }
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static <T> T getCallBody(Call<T> call) {
        T t = null;

        try {
            t = call.execute().body();
        } catch (IOException e) {}

        return t;
    }

}
