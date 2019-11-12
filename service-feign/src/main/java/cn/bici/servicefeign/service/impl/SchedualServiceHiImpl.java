package cn.bici.servicefeign.service.impl;

import cn.bici.servicefeign.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * @author Override
 * @version 1.0
 * @since 2019/11/8 15:43
 */
@Component
public class SchedualServiceHiImpl implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry"+name;
    }
}
