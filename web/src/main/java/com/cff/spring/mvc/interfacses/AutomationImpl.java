package com.cff.spring.mvc.interfacses;

import com.cff.spring.mvc.impls.IAutomation;
import org.springframework.stereotype.Component;

/**
 * @author cff
 * @version 1.0
 * @description @TODO
 * @date 2017/7/9 下午11:50
 */
@Component
public class AutomationImpl implements IAutomation {

    @Override
    public String say(String say) {
        return say;
    }
}
