package com.bblog.dao;

import com.bblog.model.POJO.SysPermission;
import java.util.List;


public interface SysMapper {
    //根据用户id查询菜单
    public List<SysPermission> findMenuListByUserId(String userid)throws Exception;
    //根据用户id查询权限url
    public List<SysPermission> findPermissionListByUserId(String userid)throws Exception;

}
