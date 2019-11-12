package cn.bici.serviceribbon.controller;

import cn.bici.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Override
 * @version 1.0
 * @since 2019/11/8 11:13
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/hi")
    public String hi(@RequestParam("name") String name){
        return helloService.hiService(name);
    }

}
