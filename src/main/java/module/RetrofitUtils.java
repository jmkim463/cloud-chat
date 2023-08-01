package module;

import okhttp3.MultipartBody;
import retrofit2.Call;

import javax.swing.*;
import java.io.IOException;

public class RetrofitUtils {

    public static <T> T getCallBody(Call<T> call) {
        T t = null;

        try {
            t = call.execute().body();
        } catch (IOException e) {}

        return t;
    }
//
//    public static MultipartBody.Part imageIconToMultipartBodyPart(ImageIcon icon) {
//
//    }


}
