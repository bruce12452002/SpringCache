package bruce.home.Cache.controller;

import bruce.home.Cache.service.MyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MyController {
    @Resource
    private MyService myService;

    @RequestMapping("/aaa")
    public String aaa(int i) {
        return myService.aaa(i);
    }

    @RequestMapping("/bbb")
    public String bbb(int i) {
        return myService.bbb(i);
    }

    @RequestMapping("/getCacheData")
    public void getCacheData() {
        myService.getCacheData();
    }
}
