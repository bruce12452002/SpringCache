package bruce.home.Cache.controller;

import bruce.home.Cache.service.KeyService;
import bruce.home.Cache.service.MyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class KeyController {
    @Resource
    private KeyService keyService;

    @RequestMapping("/aKey")
    public String aKey() {
        return keyService.aKey();
    }

    @RequestMapping("/bKey")
    public String bKey() {
        return keyService.bKey();
    }

}
