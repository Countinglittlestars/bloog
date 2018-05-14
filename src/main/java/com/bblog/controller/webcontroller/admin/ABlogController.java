package com.bblog.controller.webcontroller.admin;

import com.bblog.controller.webcontroller.BaseAdminController;
import com.bblog.model.POJO.Blog;
import com.bblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * Created by 233moutian on 2018/3/1
 * @Explain: 后台博文控制器
 */
@Controller
@RequestMapping(value = "admin/blog")
public class ABlogController extends BaseAdminController<Blog,Long> {

    @Autowired
    private BlogService blogService;


    //返回写博文的页面
    @RequestMapping("writeUI")
    public String writeUI(){
        System.out.println("hahah");

        return TEMPLATE_PATH+"add-article";
    }

    //写博文的功能
    @RequestMapping("write")
    public String write(Blog blog,Model model){

        blog.setUpdateTime(new java.sql.Date(new java.util.Date().getTime())) ;
        blog.setReleaseDate(new java.sql.Date(new java.util.Date().getTime()));
        blog.setClickHit(1);
        blog.setReplyHit(1);
        blog.setBlogId(UUID.randomUUID().toString());

        System.out.println("blog:"+blog);
        blogService.insertBlog(blog);
        return TEMPLATE_PATH+"add-article";

    }

    //修改博文的页面
    @RequestMapping("updateUI")
    public String updateUI(HttpServletRequest request,Model model){
        System.out.println("updateUI");
        String id = request.getParameter("blogId");
        Blog blog = new Blog();
        blog.setBlogId(id);
        Blog blog1 = blogService.select(blog).get(0);
        model.addAttribute("blog",blog1);
        return TEMPLATE_PATH+"update-article";
    }

    @RequestMapping("update")
    public String update(Blog blog,HttpServletRequest request,Model model){
        System.out.println("传进来的blog的id"+blog.getBlogId());
        blog.setUpdateTime(new java.sql.Date(new java.util.Date().getTime()));
        blogService.update(blog);
        return REDIRECT_URL+"select";
    }

    @RequestMapping("select")
    public String select(HttpServletRequest request,Model model){
        String sign = request.getParameter("sign");
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        Blog blog = new Blog();
        blog.setBlogId(id);
        blog.setTitle(title);
        blog.setSign(sign);
        List<Blog> blogList = blogService.select(blog);
        model.addAttribute("blogList",blogList);

        return TEMPLATE_PATH+"article";
    }


    @RequestMapping("delete")
    public String delete(HttpServletRequest request){
        String id = request.getParameter("blogId");

        blogService.delete(id.trim());
        return REDIRECT_URL+"select";
    }



//    @RequestMapping("upll")
//    public void upll(HttpServletRequest request, HttpServletResponse response){
//        try {
//        String rootPath = request.getSession().getServletContext().getRealPath("/");
//            //获取客户端传过来图片的二进制流
//            InputStream stream = request.getInputStream() ;
//            //以当前时间戳为图片命名
//            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
//            String strCurrentTime = df.format(new Date()) ;
//            String imagePath = rootPath + strCurrentTime +".jpeg" ;
//            FileOutputStream fos = new FileOutputStream(imagePath) ;
//            byte[] bbuf = new byte[32] ;
//            int hasRead = 0 ;
//            while((hasRead = stream.read(bbuf)) > 0)
//            {
//                fos.write(bbuf, 0, hasRead);//将文件写入服务器的硬盘上
//            }
//            fos.close();
//            stream.close();
//            /*
//             *  但是需要注意，采用这种原始的方式写入文件时，你会发现被写入的文件内容前4行并非是读取文件的真正内容，
//             * 从第四行开始才是正文数据。第二行是文件路径以及名称。所以通常的做法是，先将文件写入临时文件中，然后
//             * 再采用RandomAccessFile读取临时文件的第四行以后部分。写入到目标文件中。
//             */
//            Byte n ;
//            //read the temp file
//            RandomAccessFile random = new RandomAccessFile(imagePath, "r") ;
//            //read line2 to find the name of the upload file.
//            int second = 1 ;
//            String secondLine = null ;
//            while(second <=2)
//            {
//                secondLine = random.readLine();
//                second++ ;
//            }
//            //get the last location of the dir char.'\\'
//            int position = secondLine.lastIndexOf('\\') ;
//            //get the name of the upload file.
//            String fileName = secondLine.substring(position+1, secondLine.length()-1) ;
//            //relocate to the head of file
//            random.seek(0);
//            //get the location of the char.'Enter' in Line4.
//            long forthEndPosition = 0 ;
//            int forth = 1 ;
//            while((n=random.readByte())!=-1 && (forth <= 4))
//            {
//                if(n=='\n')
//                {
//                    forthEndPosition = random.getFilePointer() ;
//                    forth++ ;
//                }
//            }
//            RandomAccessFile random2 = new RandomAccessFile(imagePath, "rw") ;
//            //locate the end position of the content.Count backwards 6 lines
//            random.seek(random.length());
//            long endPosition = random.getFilePointer() ;
//            long mark = endPosition ;
//            int j = 1 ;
//            while((mark >= 0) && (j <=6))
//            {
//                mark-- ;
//                random.seek(mark);
//                n=random.readByte() ;
//                if(n=='\n')
//                {
//                    endPosition=random.getFilePointer() ;
//                    j++ ;
//                }
//            }
//            //locate to the begin of content.Count for 4 lines's end position.
//            random.seek(forthEndPosition);
//            long startPoint = random.getFilePointer() ;
//            //read the real content and write it to the realFile.
//            while(startPoint < endPosition-1)
//            {
//                n = random.readByte() ;
//                random2.write(n);
//                startPoint = random.getFilePointer() ;
//            }
//            random.close();
//            random2.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }










//
//
//
//    @RequestMapping("list")
//    public String list(@RequestParam(value = "pager.offset", required = false, defaultValue = "0") Integer offset,
//                       @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
//                       Model model){
//        List<Blog> blogList = blogService.selectByRowBounds(new Blog(), new RowBounds(offset, limit));
//        System.out.println(blogList.toString());
//        model.addAttribute("blogList", blogList);
////        model.addAttribute("count",  new PageInfo(blogList).getTotal());  无法使用此方法，改用手动查询
//        model.addAttribute("count",  blogService.selectCount(new Blog()));
//        model.addAttribute("limit", limit);
//        model.addAttribute("blogList", blogList);
//        System.out.println(TEMPLATE_PATH+"list");
//        return TEMPLATE_PATH+"list";
//    }
//
//    /*
//    43行 注解内容value是获取这个名字的参数,并赋值给offset这个变量,且这个参数不是必须的,如果没有传过来,那么它的默认值为1
//    44行 注解内容value是获取这个名字的参数,并赋值给limit这个变量,且这个参数不是必须的,如果没有传过来,那么它的默认值为10
//    46-47行 分页查询:查询从第offset条开始,查limit条数据  即查出来的数据为offset < result <= offset+limit
//    50行 count是总数据条数,需要将查询出来的list强转为Page<E>类型再调用getTotal()方法获得
//    41行 limit每页数据条数
// */
//    @RequestMapping(value = "/demoList", method = RequestMethod.GET)
//    @ResponseBody
//    public String demoList(@RequestParam(value = "pager.offset", required = false, defaultValue = "0") Integer offset,
//                       @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
//                       Model model) {
//        List<Blog> blogList = blogService
//                .selectByRowBounds(new Blog(), new RowBounds(offset, limit));
//        model.addAttribute("blogList", blogList);
////        model.addAttribute("count",  new PageInfo(blogList).getTotal());  无法使用此方法，改用手动查询
//        model.addAttribute("count",  blogService.selectCount(new Blog()));
//        model.addAttribute("limit", limit);
////        return TEMPLATE_PATH+"list";   这个地方是个jsp地址
//        return JSONObject.toJSON(model).toString();
//    }
//
//    /*
//     * 异步获取dataTable分页数据  改编版
//     * @param searchText
//     * @param sEcho
//     * @param pageBean
//     * @return
//     */
//    @RequestMapping("dataTable")
//    @ResponseBody
//    public Map dataTable(PageBean pageBean) {
//        System.out.println(pageBean.toString());
//        Example example = new Example(Blog.class);
//        if (pageBean.getSearchText() != null && !"".equals(pageBean.getSearchText())) {
//            example.createCriteria().andLike("", pageBean.getSearchText());
//            example.or().andLike("", pageBean.getSearchText());
//            example.or().andLike("", pageBean.getSearchText());
//            example.or().andLike("", pageBean.getSearchText());
//            example.or().andLike("", pageBean.getSearchText());
//            example.or().andLike("", pageBean.getSearchText());
//        }
////        List<Blog> blogList = blogService.selectByExampleAndRowBounds(example,
////                new RowBounds(pageBean.getPageOffset(), pageBean.getSize()));
//        List<Blog> blogList = blogService.selectAll();
//        Map<String,Object> map = new HashedMap();
//        map.put("iTotalRecords", blogList.size());//当前总数据条数
//        map.put("iTotalDisplayRecords",blogService.selectCount(new Blog()));//查询结果的总条数
//        map.put("aaData", blogList);
//        return map;
//
//    }
//
//
//
//    @RequestMapping("writeUI")
//    public String writeUI(){
//
//        return TEMPLATE_PATH+"write";
//    }
//    @RequestMapping("write1UI")
//    public String write1UI(){
//
//        return TEMPLATE_PATH+"write1";
//    }
//
//
//
//
//    @RequestMapping( value="/write",method = RequestMethod.POST)
//    public String write(Blog blog,HttpSession session){
//
//        System.out.println("跳转成功");
//        System.out.println(blog);
//        System.out.println(session);
//            blog.setUpdateTime(new java.sql.Date(new Date().getTime())) ;
//            blog.setReleaseDate(new java.sql.Date(new Date().getTime()));
//            blog.setCreateTime(new java.sql.Date(new Date().getTime()));
//            blog.setClickHit(1);
//            blog.setReplyHit(1);
//            Admin admin = (Admin) session.getAttribute("loginAdmin");
//            blog.setAdminId(admin.getA_id());
//            blog.setBlogId(UUID.randomUUID().toString());
//            System.out.println(blog);
//            blogService.insert(blog);
//            System.out.println("跳转成功");
//            return TEMPLATE_PATH+"write1";
//
//
//    }
//
//
//
//
//
//






}
