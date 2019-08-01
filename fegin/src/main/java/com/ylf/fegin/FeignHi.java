package com.ylf.fegin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author: ylf
 * @Time: 2019/6/20 下午8:00
 * @Description:
 */
@Controller
public class FeignHi{
    @Resource
    private IFeignHi iFeignHi;

    @RequestMapping("/hello")
    @ResponseBody
    public String hi(String id){
        System.out.println(id);
        return iFeignHi.hi(id);
    }
}
