package com.bblog.service;

import com.bblog.model.POJO.Comment;
import java.util.List;


public interface CommentService{
    public List<Comment> selectAll(String blogId);
    public void banByPrimaryKey(String id);
    public void activeByPrimaryKey(String id);
    public List<Comment> select(Comment comment);
    public void add(Comment comment);
}
