package com.ylf.fegin;

import org.springframework.stereotype.Component;

/**
 * @Author: ylf
 * @Time: 2019/6/21 下午7:03
 * @Description:
 */
@Component("hiHystric")
public class HiHystric implements IFeignHi{
    @Override
    public String hi(String id) {
        return "sorry "+id;
    }
}
