package com.cff.spring.service.spi;


import com.cff.spring.spi.SpiTestApi;

/**
 * Created by cff on 2017/6/8.
 */
public class ServiceSpiImpl implements SpiTestApi{


    @Override
    public String dealTest() {
        System.out.println("server实现的spi接口......");
        return "server";
    }
}
