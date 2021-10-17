package bruce.home.Cache.service.impl;

import bruce.home.Cache.service.KeyService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class KeyServiceImpl implements KeyService {
    // key 的語法可看官方的表格： https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#cache-spel-context
    // #root.methodName、#root.method.name 都一樣，不會帶 package 名稱，可用 MyServiceImpl.getCacheData debug 查看 Cache.store
    // 所以如果方法名稱一樣，也會有 MyServiceImpl 的情形

    @Cacheable(value = "xxx", key = "#root.method.name")
//    @Cacheable(value = "xxx", key = "'ooo'") // key 的字串要用「'」包起來，如果 key 的名稱一樣，也會有 MyServiceImpl 的情形
    @Override
    public String aKey() {
        System.out.println("I'm aKey");
        return "aKey";
    }

    @Cacheable(value = "xxx", key = "#root.method.name")
//    @Cacheable(value = "xxx", key = "'ooo'")
    @Override
    public String bKey() {
        System.out.println("I'm bKey");
        return "bKey";
    }

}
