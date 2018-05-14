package com.bblog.service;

import com.bblog.model.POJO.Blog;
import java.util.List;

/**
 * Created by 233moutian on 2018/3/1.
 * @Explain: 博文业务接口
 */
public interface BlogService {


    public void insertBlog(Blog blog);
    public List<Blog> select(Blog blog);
    public void delete(String id);
    public void update(Blog blog);
    public List<Blog> selectByClick();
}
