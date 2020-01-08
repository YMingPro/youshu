package com.youshu.admin.service;

import java.util.List;

import com.youshu.admin.bean.UserBean;
import com.youshu.admin.dao.AdminUserDao;
import com.youshu.admin.impl.AdminUserImpl;

public class AdminUserService {

	AdminUserDao dao = new AdminUserImpl();
	List<UserBean> list;
	UserBean user;
	boolean flag;

	public List<UserBean> findAll() {
		try {
			list = dao.findAll("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public UserBean findOne(String str) {
		try {
			list = dao.findAll(str);
			user=list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public List<UserBean> find(String str) {
		try {
			list = dao.findAll(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean update(String userId, UserBean newUser) {
		try {
			flag = dao.updateUser(userId, newUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean delete(String[] userId) {
		flag = true;
		try {
			for (int i = 0; i < userId.length; i++) {
				if (!dao.deleteUser(userId[i])) {
					flag = false;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
