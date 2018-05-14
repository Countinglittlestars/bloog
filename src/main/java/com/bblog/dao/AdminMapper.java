package com.bblog.dao;



import com.bblog.model.POJO.Admin;
import com.bblog.model.POJO.SysPermission;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface AdminMapper {



    //登陆进去后台
    public Admin login(Admin admin);

    public Admin selectForLogin(Admin admin);

    //修改指定的管理员信息
    public void updateByPrimaryKey(Admin admin);

    //按照id号查询管理员信息
    public List<Admin> select(Admin admin);


    public void banByPrimaryKey(String id);

    public void activeByPrimaryKey(String id);

    public void add(Admin admin);

    public Admin findSysUserByUserCode(String account);


}
