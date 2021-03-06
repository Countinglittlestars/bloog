package com.bblog.controller.webcontroller.admin;

import com.baidu.ueditor.ActionEnter;

import com.bblog.controller.webcontroller.BaseAdminController;
import com.bblog.model.POJO.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/ued")

public class UEditorController extends BaseAdminController<Blog, String> {
    @RequestMapping(value="/config")
    public void config(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/html");
        String rootPath = request.getSession()
                .getServletContext().getRealPath("/");

        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
