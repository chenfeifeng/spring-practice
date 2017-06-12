package com.cff.spring.utils.spi;

import com.cff.spring.spi.SpiTestApi;

/**
 * Created by cff on 2017/6/8.
 */
public class SpiTestApiImpl implements SpiTestApi{
    @Override
    public String dealTest() {
        System.out.println("util实现的spi接口......");
        return "util";
    }
}
