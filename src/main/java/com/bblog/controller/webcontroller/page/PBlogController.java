package com.bblog.controller.webcontroller.page;

import com.bblog.controller.webcontroller.BasePageController;
import com.bblog.model.POJO.Blog;
import com.bblog.service.BlogService;
import com.bblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("page/blog")
public class PBlogController extends BasePageController<Blog,Long> {
    @Autowired
    BlogService blogService;
    @Autowired
    CommentService commentService;

    @RequestMapping("pageSelect")
    public String pageSelect(HttpServletRequest request, Model model) throws UnsupportedEncodingException {

        request.setCharacterEncoding("utf-8");
        String sign = request.getParameter("sign");
        String col = request.getParameter("col");
        String topicname=null;
        if(col!=null){

            topicname = new String(col.getBytes("ISO-8859-1"),"UTF-8");
        }
        System.out.println("转换之后的字符串:"+topicname);
        String id = request.getParameter("id");
        String title = request.getParameter("title");

        Blog blog = new Blog();

        blog.setBlogId(id);
        blog.setTitle(title);
        blog.setSign(sign);
        blog.setCol(topicname);
        System.out.println("---------------------"+blog);
        List<Blog> blogList = blogService.select(blog);
        List<Blog> blogClickList = blogService.selectByClick();
        model.addAttribute("blogList", blogList);
        model.addAttribute("blogClickList",blogClickList);
        return TEMPLATE_PATH + "index";
    }
    @RequestMapping("detail")
    public String detail(Blog blog,Model model){

        model.addAttribute("blog",blogService.select(blog).get(0));
        System.out.println("---------------------------------------------------------"+blog);
        model.addAttribute("blogClickList",blogService.selectByClick());
        model.addAttribute("commentList",commentService.selectAll(blog.getBlogId()));
        return TEMPLATE_PATH + "article";
    }



}
