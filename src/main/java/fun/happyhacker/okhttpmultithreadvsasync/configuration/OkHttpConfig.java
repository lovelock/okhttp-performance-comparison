package fun.happyhacker.okhttpmultithreadvsasync.configuration;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

@SpringBootConfiguration
public class OkHttpConfig {

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder().connectionPool(new ConnectionPool(100, 5, TimeUnit.SECONDS)).build();
    }
}
