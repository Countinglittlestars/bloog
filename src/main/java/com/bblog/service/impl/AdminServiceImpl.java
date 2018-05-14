package com.bblog.service.impl;

import com.bblog.dao.AdminMapper;
import com.bblog.model.POJO.Admin;
import com.bblog.model.POJO.Blog;
import com.bblog.model.POJO.SysPermission;
import com.bblog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * admin里面有 如果有id就根据id，如果没id就查全部
     * @param admin
     * @return
     */
    public List<Admin> select(Admin admin){
        List<Admin> adminList = adminMapper.select(admin);
        System.out.println(adminList);
        return adminList;

    };

    /**
     * 根据传进来的账号和密码查询到admin1,返回
     * @param admin
     * @return 检查到的admin
     */
    public Admin selectForLogin(Admin admin){
        Admin admin1 = adminMapper.selectForLogin(admin);
        return admin1;
    }

    /**
     * 根据传进来的admin的id找到对应的admin并修改admin的信息
     * @param admin
     */

    //修改指定的管理员信息
    public void updateByPrimaryKey(Admin admin){
        adminMapper.updateByPrimaryKey(admin);

    };


    /**
     * 禁止用户登录
     * @param id
     */
    public void banByPrimaryKey(String id){

        adminMapper.banByPrimaryKey(id);
    }

    /**
     * 激活用户的登陆状态
     * @param id
     */
    public void activeByPrimaryKey(String id){
        adminMapper.activeByPrimaryKey(id);
    }


    public void add(Admin admin){
        adminMapper.add(admin);
    }


//    public Admin findSysUserByUserCode(String account){
//        Admin admin = adminMapper.findSysUserByUserCode(account);
//        return admin;
//    }

//    public List<SysPermission> findMenuListByUserId(String userid)
//            throws Exception {
//
//        return adminMapper.findMenuListByUserId(userid);
//    }
//
//    public List<SysPermission> findPermissionListByUserId(String userid)
//            throws Exception {
//
//        return adminMapper.findPermissionListByUserId(userid);
//    }

}
