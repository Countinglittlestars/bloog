package com.bblog.service.impl;

import com.bblog.dao.BlogMapper;
import com.bblog.model.POJO.Blog;
import com.bblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by 233moutian on 2018/3/1.
 * @Explain: 博文业务实现
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper ;

    public void insertBlog(Blog blog){
        System.out.println("111111111222");
        System.out.println(blogMapper);
        blogMapper.insertBlog(blog);
    }

    public List<Blog> select(Blog blog){

        List<Blog> blogList = blogMapper.select(blog);

        return blogList;

    }
    public void delete(String id){
        System.out.println("执行service的删除,id号是"+id);
        blogMapper.delete(id);
        System.out.println("执行成功了,id号是"+id);
    }

    public void update(Blog blog){
        blogMapper.update(blog);

    }


    public List<Blog> selectByClick(){
        return blogMapper.selectByClick();
    }















}
