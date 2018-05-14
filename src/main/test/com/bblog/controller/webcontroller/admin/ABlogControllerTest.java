package com.bblog.controller.webcontroller.admin;

import com.bblog.service.BlogService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ABlogControllerTest {
    ApplicationContext applicationContext;
    @Test
    public void delete() {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-all.xml");
        BlogService blogService = (BlogService) applicationContext.getBean("BlogService");
//        blogService.delete("a94a3c37-58b6-4dd6-8462-e0cf5d3c29f2");
//        blogService.select;
        System.out.println("删除成功");



    }
}