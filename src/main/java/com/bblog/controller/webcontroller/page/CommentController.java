package com.bblog.controller.webcontroller.page;

import com.bblog.controller.webcontroller.BasePageController;
import com.bblog.model.POJO.Admin;
import com.bblog.model.POJO.Comment;
import com.bblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@RequestMapping("page/comment")
public class CommentController extends BasePageController<Comment,Long> {

    @Autowired
    CommentService commentService;
    @RequestMapping("add")
    public String add(Comment comment, HttpServletRequest request){

        comment.setbId(request.getParameter("blogId"));
        Admin admin = (Admin)request.getSession().getAttribute("loginAdmin");
        comment.setcId(UUID.randomUUID().toString());
        comment.setaId(admin.getA_id());
        comment.setaName(admin.getName());
        comment.setAvailable("1");
        comment.setCreateTime(new java.sql.Date(new java.util.Date().getTime()));
        commentService.add(comment);
        return "redirect:/page/blog/pageSelect";
    }

}
