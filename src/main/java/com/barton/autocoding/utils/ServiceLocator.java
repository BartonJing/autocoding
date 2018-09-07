package com.barton.autocoding.utils;

import com.barton.autocoding.test.service.impl.TestService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class ServiceLocator implements ApplicationContextAware {
    private Map<String, TestService> map;
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        map = applicationContext.getBeansOfType(TestService.class);
    }
    public Map<String, TestService> getMap() {
         return map;
    }

}
