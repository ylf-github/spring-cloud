package com.ylf.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: ylf
 * @Time: 2019/6/20 下午8:01
 * @Description:
 */
@Service
@FeignClient(value="service-hi",fallback = HiHystric.class)
public interface IFeignHi{
    @RequestMapping(value = "/hi/{id}")
     String hi(@PathVariable("id") String id);
}
