package com.cff.spring.utils.common;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
* @author chenff
* @description @TODO
* @date 2017年7月11日 下午8:10:51
* @version 1.0
*/
public class Test2 {
	public static void main(String[] args) throws Exception {
		System.out.println(Thread.currentThread().getContextClassLoader());
		System.out.println(Thread.currentThread().getContextClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println( Thread.currentThread().getContextClassLoader());
		System.out.println("====");
		File file = new File(
				"/Users/chenfeifeng/workspace/notofywk/tenantsso/cas-impl/target/cas-impl-2.0.0-SNAPSHOT.jar");// jar包的路径
		URL url = file.toURI().toURL();
		ClassLoader loader = new URLClassLoader(new URL[] { url });// 创建类加载器
		System.out.println(loader);
		System.out.println(loader.getParent());
		Thread.currentThread().setContextClassLoader(loader);
		System.out.println("===");
		System.out.println(Thread.currentThread().getContextClassLoader());
		System.out.println(Thread.currentThread().getContextClassLoader().getParent());
		System.out.println("====");
		System.out.println( Thread.currentThread().getContextClassLoader());
	}
}
