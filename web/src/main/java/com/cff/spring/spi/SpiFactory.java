package com.cff.spring.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by cff on 2017/6/8.
 */
public class SpiFactory {
    private SpiFactory(){

    }

    public static SpiTestApi getSpiFactory(){
        SpiTestApi spiTestApi=null;
        ServiceLoader<SpiTestApi> serviceLoader=ServiceLoader.load(SpiTestApi.class);

        Iterator<SpiTestApi> searchs = serviceLoader.iterator();
        if (searchs.hasNext()) {
            spiTestApi = searchs.next();
        }
        return spiTestApi;
    }
}
