package com.bblog.controller.webcontroller.page;

import com.bblog.controller.webcontroller.BasePageController;
import com.bblog.exception.CustomException;
import com.bblog.model.POJO.ActiveUser;
import com.bblog.model.POJO.Admin;
import com.bblog.service.AdminService;
import com.util.UUIDisplay;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("page/admin")
public class PAdminController extends BasePageController<Admin,Long> {
    @Autowired
    private AdminService adminService;

    @RequestMapping("loginUI")
    public String loginUI(){
        System.out.println(TEMPLATE_PATH+"login");
        return TEMPLATE_PATH+"login";
    }

    @RequestMapping("/first")
    public String first(Model model,HttpServletRequest request)throws Exception{

        //从shiro的session中取activeUser
        Subject subject = SecurityUtils.getSubject();
        //取身份信息
        ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
        Admin admin = new Admin();
        admin.setAccount(activeUser.getUsercode());
        Admin admin1 = adminService.select(admin).get(0);

        //通过model传到页面
        request.getSession().setAttribute("loginAdmin",admin1);

        return "redirect:/page/blog/pageSelect";
    }






    @RequestMapping("login")
    public String login(HttpServletRequest request)throws Exception{
//        如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        //根据shiro返回的异常类路径判断，抛出指定异常信息
        if(exceptionClassName!=null){

            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                //最终会抛给异常处理器
                throw new CustomException("账号不存在或者无权限");
            } else if (IncorrectCredentialsException.class.getName().equals(
                    exceptionClassName)) {
                throw new CustomException("用户名/密码错误");
            } else if("randomCodeError".equals(exceptionClassName)){
                throw new CustomException("验证码错误 ");
            }else {
                throw new Exception();//最终在异常处理器生成未知错误
            }
        }
//        此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
//        登陆失败还到login页面
        return TEMPLATE_PATH+"login";
    }





    @RequestMapping("select")
    public String select(Admin admin,Model model){

        List<Admin> adminList = adminService.select(admin);
        model.addAttribute("adminList",adminList);
        return TEMPLATE_PATH+"manage-user";

    }












//    @RequestMapping("login")
//    public String login(@RequestParam("account") String account,
//                        @RequestParam("password") String password,Model model,HttpServletRequest request) throws Exception {
//
//
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
////        try {
////            //执行认证操作.
////            subject.login(token);
////        }catch (AuthenticationException ae) {
////            System.out.println("登陆失败: " + ae.getMessage());
////            return TEMPLATE_PATH+"login";
////        }
////        return "redirect:/page/blog/pageSelect";
////
////        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
////        //根据shiro返回的异常类路径判断，抛出指定异常信息
////        if(exceptionClassName!=null){
////            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
////                //最终会抛给异常处理器
////                throw new CustomException("账号不存在");
////            } else if (IncorrectCredentialsException.class.getName().equals(
////                    exceptionClassName)) {
////                throw new CustomException("用户名/密码错误");
////            } else if("randomCodeError".equals(exceptionClassName)){
////                throw new CustomException("验证码错误 ");
////            }else {
////                throw new Exception();//最终在异常处理器生成未知错误
////            }
////        }
////        //此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
////        //登陆失败还到login页面
////        return "login";
//
//        try {
//            //执行认证操作.
//            subject.login(token);
//        }catch (AuthenticationException ae) {
//            System.out.println("登陆失败: " + ae.getMessage());
//            return TEMPLATE_PATH+"login";
//        }
//
//
//
//        return REDIRECT_URL+"first";
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////        Admin admin1 = adminService.selectForLogin(admin);
////        System.out.println("第一"+admin1);
////        if(admin1 != null){
////            request.getSession().setAttribute("loginAdmin",admin1);
////            System.out.println("查看是不是在的:"+admin1+"--");
////            //先这样  是打算进入到comment的查看所有评论的方法的
////            return "redirect:/page/blog/pageSelect";
////        }
////        else{
////            return TEMPLATE_PATH+"login";
////        }
//        //如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
////        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
////        //根据shiro返回的异常类路径判断，抛出指定异常信息
////        if(exceptionClassName!=null){
////            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
////                //最终会抛给异常处理器
////                throw new CustomException("账号不存在");
////            } else if (IncorrectCredentialsException.class.getName().equals(
////                    exceptionClassName)) {
////                throw new CustomException("用户名/密码错误");
////            } else if("randomCodeError".equals(exceptionClassName)){
////                throw new CustomException("验证码错误 ");
////            }else {
////                throw new Exception();//最终在异常处理器生成未知错误
////            }
////        }
////        //此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
////        //登陆失败还到login页面
////        return TEMPLATE_PATH+"login";
//    }
//    @RequestMapping("logout")
//    public String logout(HttpServletRequest request){
//
//        request.getSession().removeAttribute("loginAdmin");
//        return REDIRECT_URL+"loginUI";
//
//    }

    @RequestMapping("exist")
    public void exist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        String account1  = request.getParameter("account");
        System.out.println(account1);
        Admin admin = new Admin();
        admin.setAccount(account1);
        System.out.println(admin);
        List<Admin> adminlist = adminService.select(admin);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        if(adminlist.size()!=0){
            out.println("<font color='green'>该账号已被注册!</font>");
        }else{
            out.println("<font color='green'>恭喜您，该帐号可以使用!</font>");
        }
        out.flush();//刷新流
        out.flush();//刷新流out.close();//关闭流
    }

    @RequestMapping("registerUI")
    public String registerUI(){
        return TEMPLATE_PATH+"register";
    }
    @RequestMapping("register")
    public String register(Admin admin){
        admin.setA_id(UUID.randomUUID().toString());

        String uuid1 = UUIDisplay.generateShortUuid();
        admin.setSalt(uuid1);
        Object simpleHash = new SimpleHash("MD5",admin.getPassword(),
                uuid1, 1);
        admin.setPassword(simpleHash.toString());
        admin.setAvailable("1");
        adminService.add(admin);
        return REDIRECT_URL+"login";
    }


}
