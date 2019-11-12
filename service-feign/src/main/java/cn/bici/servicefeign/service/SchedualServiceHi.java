package cn.bici.servicefeign.service;

import cn.bici.servicefeign.service.impl.SchedualServiceHiImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Override
 * @version 1.0
 * @since 2019/11/8 11:45
 */
@FeignClient(value = "sevice-hi",fallback = SchedualServiceHiImpl.class)
public interface SchedualServiceHi {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam("name")String name);
}
