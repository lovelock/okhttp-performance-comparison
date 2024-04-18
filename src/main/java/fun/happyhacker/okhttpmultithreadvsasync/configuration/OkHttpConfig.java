package fun.happyhacker.okhttpmultithreadvsasync.configuration;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootConfiguration
public class OkHttpConfig {

    @Bean
    public OkHttpClient okHttpClient() {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Dispatcher dispatcher = new Dispatcher(executorService);
        return new OkHttpClient.Builder().dispatcher(dispatcher).build();
    }
}
