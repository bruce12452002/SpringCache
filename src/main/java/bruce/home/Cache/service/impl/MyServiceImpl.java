package bruce.home.Cache.service.impl;

import bruce.home.Cache.annotation.MyCacheable;
import bruce.home.Cache.service.MyService;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MyServiceImpl implements MyService {
    // 不同方法的 @Cacheable 的 cacheNames 一樣，而且方法參數也一樣，spring cache 會認為是一樣的
    // 和方法名稱、回傳值沒關係，但回傳值不同，第二次調用會有不能強制轉換的例外
    // 可用 keyGenerator 解決，但每次都寫很麻煩，還可以自己定義一個 annotation，將 keyGenerator 寫在裡面，然後使用這個註解
    // 還可用 key 解決，看 KeyServiceImpl

    @Resource
    private CacheManager cacheManager;


    // @Cacheable("xxx")
    // 屬性 value 相當於區域，之後可針對區域刪除
    // 儲存到快取的 key 是參數值，如果沒有參數，預設是 「SimpleKey []」；如有多個參數，是多個參數值，如 「SimpleKey [222,abc]」
    // 儲存到快取的 value 是回傳值

    // @Cacheable(value = "xxx", keyGenerator = "myKey")
    @MyCacheable("xxx")
    @Override
    public String aaa(int i) {
        System.out.println("I'm aaa" + i);
        return "aaa" + i;
    }

    // @Cacheable("xxx")
    // @Cacheable(value = "xxx", keyGenerator = "myKey")
    @MyCacheable("xxx")
    @Override
    public String bbb(int i) {
        System.out.println("I'm bbb" + i);
        return "bbb" + i;
    }

    @Override
    public void getCacheData() {
        cacheManager.getCacheNames().forEach(cacheName -> {
            Cache cache = cacheManager.getCache(cacheName); // store 可看到快取的 key-value
            System.out.println("key=" + cacheName);
        });
    }
}
