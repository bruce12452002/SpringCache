package bruce.home.Cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Method;
import java.util.Arrays;

@SpringBootApplication
@EnableCaching
public class CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }

    @Bean("myKey")
    public KeyGenerator keyGenerator() {
        return (Object target, Method method, Object... params) -> {
            System.out.println("target=" + target);
            System.out.println("method=" + method);
            Arrays.stream(params).forEach(p -> System.out.println("params=" + p));
            Object[] args = new Object[params.length + 2];
            args[0] = target;
            args[1] = method;
            System.arraycopy(params, 0, args, 2, params.length);
            return new SimpleKey(args);
        };
    }


}
