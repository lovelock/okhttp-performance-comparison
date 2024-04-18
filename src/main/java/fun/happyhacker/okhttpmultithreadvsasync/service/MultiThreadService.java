package fun.happyhacker.okhttpmultithreadvsasync.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MultiThreadService {

    private static final String URL = "http://127.0.0.1:8888";

    @Autowired
    private OkHttpClient okHttpClient;

    public void call() {
        for (int i = 0; i < 100; i++) {
            Request request = new Request.Builder().url(URL + "?a=" + i).build();
            try (Response response = okHttpClient.newCall(request).execute()) {
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
