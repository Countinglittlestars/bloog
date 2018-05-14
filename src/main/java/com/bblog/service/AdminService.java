package com.bblog.service;

import com.bblog.model.POJO.Admin;
import com.bblog.model.POJO.Blog;
import com.bblog.model.POJO.SysPermission;

import java.util.List;
public interface AdminService {



    //按照id号查询管理员信息
    public List<Admin> select(Admin admin);

    public void banByPrimaryKey(String id);

    public void updateByPrimaryKey(Admin admin);

    public Admin selectForLogin(Admin admin);

    public void activeByPrimaryKey(String id);

    public void add(Admin admin);
//    public Admin findSysUserByUserCode(String account);

//    public List<SysPermission> findMenuListByUserId(String userid) throws Exception;
//
//    public List<SysPermission> findPermissionListByUserId(String userid) throws Exception;
}
