package com.bblog.dao;
import com.bblog.model.POJO.Comment;

import java.util.List;

public interface CommentMapper {
    public List<Comment> selectAll(String blogId);
    public List<Comment> select(Comment comment);
    public void banByPrimaryKey(String id);
    public void activeByPrimaryKey(String id);
    public void add(Comment comment);


}
