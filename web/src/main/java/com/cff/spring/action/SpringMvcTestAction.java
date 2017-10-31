package com.cff.spring.action;

import com.cff.spring.entity.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author cff
 * @version 1.0
 * @description @TODO
 * @date 2017/7/2 下午8:53
 */
@ControllerAdvice
public class SpringMvcTestAction {

    @ModelAttribute
    public User newUser() {
        System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前把返回值放入Model");
        return new User();
    }

    // 数据解析,可以将date数据进行处理
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String processUnauthenticatedException(NativeWebRequest request, Exception e) {
        System.out.println("===========应用到所有@RequestMapping注解的方法，在其抛出UnauthenticatedException异常时执行");
        return "viewName"; //返回一个逻辑视图名
    }
}
