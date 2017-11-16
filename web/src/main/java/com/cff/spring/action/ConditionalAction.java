package com.cff.spring.action;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cff.spring.service.test.MyCondition;

/**
 * @author chenff
 * @description @TODO
 * @date 2017年7月13日 下午3:48:15
 * @version 1.0
 */
@Conditional(MyCondition.class)
@Controller
@RequestMapping("/con")
public class ConditionalAction {
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return System.currentTimeMillis()+"";
	}
}
