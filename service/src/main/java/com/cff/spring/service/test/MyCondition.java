package com.cff.spring.service.test;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.HashMap;
import java.util.Map;

/**
* @author chenff
* @description @TODO
* @date 2017年7月13日 下午3:35:38
* @version 1.0
*/
public class MyCondition implements Condition{
	
	public static Map<String,String> myMap=new HashMap<String,String>();

	public static Integer count=0;
	
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		System.out.println(count++);
		return true;
	}

}
