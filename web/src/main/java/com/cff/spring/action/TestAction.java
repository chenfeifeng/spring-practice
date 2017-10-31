package com.cff.spring.action;

import com.cff.spring.mvc.impls.IAutomation;
import com.cff.spring.service.test.MyCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author cff
 * @version 1.0
 * @description @TODO
 * @date 2017/6/19 下午11:44
 */
@Controller
@RequestMapping("/test")
public class TestAction {

    @Autowired
    private IAutomation automation;

    @RequestMapping("/init")
    @ResponseBody
    public String initTest(String pwd){
    	MyCondition.myMap.put("myCondition", "cff");
        return pwd;
    }

    @RequestMapping("/test1")
    @ResponseBody
    public String test1(String pwd) {
        System.out.println(automation);
        if(automation==null){
            return "null";
        }
        return automation.say(pwd);
    }
    
    @RequestMapping("/error")
    @ResponseBody
    public void notfount(HttpServletRequest request,HttpServletResponse response) {
    	try {
            System.out.println("执行了error");
            response.sendRedirect("/index.jsp");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}
    }

}

