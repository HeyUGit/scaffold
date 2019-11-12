package cn.bici.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Override
 * @version 1.0
 * @since 2019/11/8 11:11
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name){
        return restTemplate.getForObject("http://sevice-hi/hi?name="+name,String.class);
    }

    public String hiError(String name){
        return "hi"+name+"，sorry,error!";
    }
}
