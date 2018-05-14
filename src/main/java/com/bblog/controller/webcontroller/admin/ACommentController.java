package com.bblog.controller.webcontroller.admin;

import com.bblog.controller.webcontroller.BaseAdminController;

import com.bblog.model.POJO.Comment;
import com.bblog.service.CommentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
@RequestMapping(value="admin/comment")
public class ACommentController extends BaseAdminController<Comment,Long> {

    @Autowired
    CommentService commentService;

    @RequestMapping("selectAll")
    public String selectAll(Comment comment,Model model){
        List<Comment> commentList =  commentService.select(comment);
        model.addAttribute("commentList",commentList);
        return TEMPLATE_PATH+"comment";
    }

    @RequestMapping("banByPrimaryKey")
    @RequiresPermissions("comment:update")
    public String banByPrimaryKey(HttpServletRequest request){
        String id = request.getParameter("cId");
        System.out.println("123123123123");
        commentService.banByPrimaryKey(id);

        return REDIRECT_URL+"selectAll";
    }

    @RequestMapping("activeByPrimaryKey")
    @RequiresPermissions("comment:update")
    public String activeByPrimaryKey(HttpServletRequest request){
        String id = request.getParameter("cId");
        System.out.println(id);
        commentService.activeByPrimaryKey(id);
        return REDIRECT_URL+"selectAll";

    }





}
