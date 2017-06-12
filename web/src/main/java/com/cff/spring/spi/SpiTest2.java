package com.cff.spring.spi;

/**
 * @author cff
 * @version 1.0
 * @description @TODO
 * @date 2017/6/12 下午11:53
 */
public class SpiTest2 {
    public static void main(String[] args) {
        SpiTestApi spi = SpiFactory.getSpiFactory();
        if (spi != null) {
            spi.dealTest();
        } else {
            System.out.println("null");
        }
    }
}
