package cn.bici.servicefeign.controller;

import cn.bici.servicefeign.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Override
 * @version 1.0
 * @since 2019/11/8 11:47
 */
@RestController
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @RequestMapping(value = "/hi")
    public String sayHi(@RequestParam("name") String name){
        return schedualServiceHi.sayHiFromClientOne(name);
    }
}
