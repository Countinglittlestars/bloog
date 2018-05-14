package com.bblog.service.impl;

import com.bblog.dao.CommentMapper;
import com.bblog.model.POJO.Comment;
import com.bblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    /**
     * 后台页面查询所有的comment
     * @return
     */

    public List<Comment> select(Comment comment){
        List<Comment> commentsList  = commentMapper.select(comment);
        return commentsList;
    }

    /**
     * 前台页面根据blogId查询所有的comment
     * @param blogId
     * @return
     */
    public List<Comment> selectAll(String blogId){
        List<Comment> commentList = commentMapper.selectAll(blogId);
        return commentList;
    }




    /**
     * 把评论设置为不可显示
     * @param id
     */

    public void banByPrimaryKey(String id){
        System.out.println("Service123123123123");
        commentMapper.banByPrimaryKey(id);
    }

    /**
     * 把评论设置为可显示的
     * @param id
     */


    public void activeByPrimaryKey(String id)
    {
        commentMapper.activeByPrimaryKey(id);
    }

    public void add(Comment comment){
        commentMapper.add(comment);
    }






}
