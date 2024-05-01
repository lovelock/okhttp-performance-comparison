package fun.happyhacker.okhttpmultithreadvsasync.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MultiThreadService {

    private static final String URL = "http://127.0.0.1:8888";

    @Autowired
    private OkHttpClient okHttpClient;

    public int call() {
        AtomicInteger count = new AtomicInteger(0);
        for (int i = 0; i < 100; i++) {
            Request request = new Request.Builder().url(URL).build();
            try (Response response = okHttpClient.newCall(request).execute()) {
                assert response.body() != null;
                count.getAndIncrement();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return count.get();
    }
}
