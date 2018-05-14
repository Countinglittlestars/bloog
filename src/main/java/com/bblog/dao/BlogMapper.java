package com.bblog.dao;

import com.bblog.model.POJO.Blog;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BlogMapper  {

    public void insertBlog(Blog blog);

    public List<Blog> select(Blog blog);

    public void delete(String id);

    public void update(Blog blog);

    public List<Blog> selectByClick();


}
