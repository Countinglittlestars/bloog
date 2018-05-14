package com.bblog.service.impl;

import java.util.List;

import com.bblog.dao.AdminMapper;
import com.bblog.dao.SysMapper;
import com.bblog.exception.CustomException;
import com.bblog.model.POJO.ActiveUser;
import com.bblog.model.POJO.Admin;
import com.bblog.model.POJO.SysPermission;
import com.bblog.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * <p>Title: SysServiceImpl</p>
 * <p>Description:认证和授权的服务接口 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-3-23上午11:31:43
 * @version 1.0
 */
@Service
public class SysServiceImpl implements SysService {
	
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private SysMapper sysMapper;

	@Override
//	public ActiveUser authenticat(String userCode, String password)
//			throws Exception {
//		/**
//	认证过程：
//	根据用户身份（账号）查询数据库，如果查询不到用户不存在
//	对输入的密码 和数据库密码 进行比对，如果一致，认证通过
//		 */
//		//根据用户账号查询数据库
//		Admin admin = this.findSysUserByUserCode(userCode);
//
//		if(admin == null){
//			//抛出异常
//			throw new CustomException("用户账号不存在");
//		}
//
//		//数据库密码 (md5密码 )
//		String password_db = admin.getPassword();
//
//		//对输入的密码 和数据库密码 进行比对，如果一致，认证通过
//		//对页面输入的密码 进行md5加密
//		String password_input_md5 = new MD5().getMD5ofStr(password);
//		if(!password_input_md5.equalsIgnoreCase(password_db)){
//			//抛出异常
//			throw new CustomException("用户名或密码 错误");
//		}
//		//得到用户id
//		String userid = admin.getA_id();
//		//根据用户id查询菜单
//		List<SysPermission> menus =this.findMenuListByUserId(userid);
//
//		//根据用户id查询权限url
//		List<SysPermission> permissions = this.findPermissionListByUserId(userid);
//
//		//认证通过，返回用户身份信息
//		ActiveUser activeUser = new ActiveUser();
//		activeUser.setUserid(admin.getA_id());
//		activeUser.setUsercode(userCode);
//		activeUser.setUsername(admin.getAccount());//用户名称
//
//		//放入权限范围的菜单和url
//		activeUser.setMenus(menus);
//		activeUser.setPermissions(permissions);
//
//		return activeUser;
//	}
//
	//根据用户账号查询用户信息
	public Admin findSysUserByUserCode(String userCode)throws Exception{


		Admin admin = adminMapper.findSysUserByUserCode(userCode);

		if(admin!=null){
			return admin;
		}

		return null;
	}

	@Override
	public List<SysPermission> findMenuListByUserId(String userid)
			throws Exception {
		
		return sysMapper.findMenuListByUserId(userid);
	}

	@Override
	public List<SysPermission> findPermissionListByUserId(String userid)
			throws Exception {
		
		return sysMapper.findPermissionListByUserId(userid);
	}

}
