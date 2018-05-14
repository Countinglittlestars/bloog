package com.bblog.controller.webcontroller.admin;


import com.bblog.controller.webcontroller.BaseAdminController;

import com.bblog.exception.CustomException;
import com.bblog.model.POJO.Admin;
import com.bblog.service.AdminService;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 黄柏樟 on 2016/3/8.
 * 修改人 sky on 2016/4/5.
 * @Explain: 管理员控制器
 */
@Controller
@RequestMapping(value = "admin/admin")
public class AAdminController extends BaseAdminController<Admin,Long> {

    @Autowired
    private AdminService adminService;

    @RequestMapping("admin_list")
    //显示所有的用户的列表
    public String admin_list(HttpServletRequest request,Model model){
        String id = request.getParameter("a_id");
        Admin admin = new Admin();
        admin.setA_id(id);
        //adminService查找所有的用户
        List<Admin> adminlist = adminService.select(admin);
        //把查询到的list添加到model里面
        model.addAttribute("adminList",adminlist);
        return TEMPLATE_PATH+"manage-user";
    }


    //根据传来的admin更新Admin
    @RequestMapping("updateByPrimaryKey")
    public String updateByPramiryKey(Admin admin, Model model, HttpServletRequest request){
        List<Admin> admin1 = adminService.select(admin);

//        //查看密码有没有改变
//        if(admin1.get(0).getPassword().equals(admin.getPassword())){
//            //根据shiro的md5算法贾母工具进行加密
//            Md5Hash md = new Md5Hash(admin1.get(0).getPassword(), UUIDisplay.generateShortUuid(),1);
//            admin.setPassword(md.toString());
//        }

        adminService.updateByPrimaryKey(admin1.get(0));
        return REDIRECT_URL+"admin_list";

    }

    @RequestMapping("ban")
    public String ban(HttpServletRequest request){
        String id = request.getParameter("id");
        adminService.banByPrimaryKey(id);

        return REDIRECT_URL+"admin_list";
    };
    @RequestMapping("active")
    public String active(HttpServletRequest request){
        String id = request.getParameter("id");
        adminService.activeByPrimaryKey(id);
        return REDIRECT_URL+"admin_list";

    }

    @RequestMapping("loginUI")
    public String loginUI(){
        System.out.println(TEMPLATE_PATH+"login");
        return TEMPLATE_PATH+"login";
    }

//    @RequestMapping("login")
//    public String login(@RequestParam("account") String account,
//                        @RequestParam("password") String password, Model model,HttpServletRequest request) throws Exception {
//
//        Admin admin1 = adminService.selectForLogin(admin);
//        System.out.println("第一"+admin1);
//        if(admin1 != null){
//
//            request.getSession().setAttribute("loginAdmin",admin1);
//            System.out.println("查看是不是在的:"+admin1+"--");
//            //先这样  是打算进入到comment的查看所有评论的方法的
//            return "redirect:/admin/comment/selectAll";
//        }
//        else{
//            return TEMPLATE_PATH+"login";
//        }





//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
//        try {
//            //执行认证操作.
//            subject.login(token);
//        }catch (AuthenticationException ae) {
//            System.out.println("登陆失败: " + ae.getMessage());
//            return TEMPLATE_PATH+"login";
//        }
//        return "redirect:/admin/comment/selectAll";








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



//    @RequestMapping("logout")
//    public String logout(HttpServletRequest request){
//
//        request.getSession().removeAttribute("loginAdmin");
//        return REDIRECT_URL+"loginUI";
//
//    }

//    @RequestMapping("AdminManager")
//    public String AdminManager(Admin admin,HttpServletRequest request){
//
//        List<Admin> adminList = adminService.select(admin);
//        request.setAttribute("adminList",adminList);
//
//
//        return TEMPLATE_PATH+"manage-user";
//
//    }












//
//    @RequestMapping("list")
//    public String list(){
//        return TEMPLATE_PATH+"list";
//    }
//    /**
//     * 登录页
//     */
//    @RequestMapping("/loginUI")
//    public String login() {
//        return TEMPLATE_PATH+"loginUI";
//    }
//
//    /**
//     * 登陆
//     * @param admin
//     * @param session
//     * @param redirectAttributes
//     * @return
//     */
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(Admin admin,HttpSession session,RedirectAttributes redirectAttributes){
//        try {
//            Admin loginAdmin=this.adminService.login(admin);
//            if (loginAdmin!=null){
//                session.setAttribute("loginAdmin",loginAdmin);
//                return "redirect:/admin/admin/list";
//            }else {
//                redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "用户名或者密码错误"));
//                return REDIRECT_URL+"loginUI";
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "发生错误"));
//            return REDIRECT_URL+"loginUI";
//        }
//    }
//
//    /**
//     * 用户登出
//     *
//     * @param session
//     * @return
//     */
//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public String logout(HttpSession session) {
//        session.removeAttribute("loginAdmin");
//        return REDIRECT_URL+"/loginUI";
//    }
//
//    /**
//     * 查看个人资料
//     * @param id
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "/show/{id}")
//    public String show(@PathVariable Long id , Model model) {
//        Admin admin  = adminService.selectByPrimaryKey(id);
//        model.addAttribute("admin" , admin);
//        return TEMPLATE_PATH + "show";
//    }
//    /**
//     * 异步获取dataTable
//     * @param searchText
//     * @param sEcho
//     * @param pageBean
//     * @return
//     */
//    @RequestMapping("dataTable")
//    @ResponseBody
//    public Map dataTable(String searchText, int sEcho, PageBean pageBean) {
//        return adminService.dataTable(searchText, sEcho, pageBean);
//    }
//
//    /**
//     * 异步删除
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
//    @ResponseBody
//    public AjaxResult delete(@PathVariable Long id) {
//        try {
//            adminService.deleteByPrimaryKey(id);
//            return successResult;
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return errorResult;
//    }
//
//    /**
//     * 个人信息
//     * @param id
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "/saveUI/{id}")
//    public String saveUI(@PathVariable Long id , Model model) {
//        model.addAttribute(this.adminService.selectByPrimaryKey(id));
//        return TEMPLATE_PATH + "saveUI";
//    }
//
//    /**
//     * 更改个人信息
//     * @param admin
//     * @param redirectAttributes
//     * @return
//     */
//    @RequestMapping( value="/update",method = RequestMethod.POST)
//    public String update(Admin admin,RedirectAttributes redirectAttributes ){
//        try {
//            admin.setPassword(Encrypt.e(admin.getPassword()));
//            adminService.updateByPrimaryKey(admin);
//            redirectAttributes.addFlashAttribute("msg",RESULT_OK);
//            return REDIRECT_URL+"list";
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        redirectAttributes.addFlashAttribute("msg", RESULT_ERROR);
//        return REDIRECT_URL+"list";
//    }
//
//    /**
//     * 添加
//     * @param admin
//     * @param redirectAttributes
//     * @return
//     */
//    @RequestMapping( value="/add",method = RequestMethod.POST)
//    public String add(Admin admin,RedirectAttributes redirectAttributes ){
//        try {
//            admin.setPassword(Encrypt.e(admin.getPassword()));    //md5加密
//            adminService.insert(admin);
//            redirectAttributes.addAttribute("msg",RESULT_OK);
//            return REDIRECT_URL+"list";
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        redirectAttributes.addFlashAttribute("msg", RESULT_ERROR);
//        return REDIRECT_URL+"list";
//    }
//
//    /**
//     * 新增或更改页
//     * @return
//     */
//    @RequestMapping(value = "/saveUI", method = RequestMethod.GET)
//    public String editUI() {
//        return TEMPLATE_PATH + "saveUI";
//    }

}
