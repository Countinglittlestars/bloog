package com.bblog.service.impl;

import com.bblog.dao.BlogMapper;
import com.bblog.model.POJO.Blog;
import com.util.UUIDisplay;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BlogServiceImplTest {
    private ApplicationContext applicationContext;

    @Test
    public void testSelect(){
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-all.xml");
        Blog blog = new Blog();
        blog.setTitle("2");
        blog.setBlogId("1");
        BlogMapper blogMapper = (BlogMapper) applicationContext.getBean("blogMapper");
        System.out.println(blogMapper.select(blog));

    }

    @Test
    public void testDelete(){
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-all.xml");

        BlogMapper blogMapper = (BlogMapper) applicationContext.getBean("blogMapper");
        blogMapper.delete("a94a3c37-58b6-4dd6-8462-e0cf5d3c29f2");

    }
    @Test
    public void testmima() {

        String uuid1 = UUIDisplay.generateShortUuid();
        Object credentials = "gengren";//密码
        String hashAlgorithmName = "MD5";//加密方式
        Object simpleHash = new SimpleHash(hashAlgorithmName, credentials,
                "1111", 1);
        System.out.println("加密后的值----->" + simpleHash+"我的uuid"+uuid1);
    }
}