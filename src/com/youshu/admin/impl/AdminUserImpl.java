package com.youshu.admin.impl;

import java.util.ArrayList;
import java.util.List;

import com.youshu.admin.bean.Model;
import com.youshu.admin.bean.UserBean;
import com.youshu.admin.dao.AdminUserDao;
import com.youshu.common.db.ConnectionPool;
import com.youshu.common.util.Tools;

public class AdminUserImpl extends Model implements AdminUserDao {

	final static boolean VIEW = false;
	List<UserBean> list;

	@Override
	public List<UserBean> findAll(String str) throws Exception {
		sql = "SELECT * FROM users";
		resultCount = 0;
		list = new ArrayList<UserBean>();
		conn = ConnectionPool.getConnection();
		if (str != null && !"".equals(str)) {
			sql += " WHERE User_Id like ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%" + str + "%");
		} else {
			psmt = conn.prepareStatement(sql);
		}
		rs = psmt.executeQuery();
		while (rs.next()) {
			resultCount++;
			UserBean user = new UserBean();
			user.setUserId(rs.getString("User_Id"));
			user.setUserSex(rs.getString("User_Sex"));
			user.setUserName(rs.getString("User_Nick"));
			list.add(user);
			if (VIEW)
				Tools.printModule(VIEW, user, rs);
		}

//		System.out.printf("总共%d条记录\n", resultCount);

		ConnectionPool.closeConnection(conn, psmt, rs);
		return list;
	}

	@Override
	public boolean updateUser(String userId, UserBean newUser) throws Exception {
		sql = "UPDATE users SET User_Id=?,User_Sex=?,User_Nick=? WHERE User_Id=?";
		conn = ConnectionPool.getConnection();
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, newUser.getUserId());
		psmt.setString(2, newUser.getUserSex());
		psmt.setString(3, newUser.getUserName());
		psmt.setString(4, userId);
		resultCount = psmt.executeUpdate();

//		System.out.printf("更新%d条记录\n", resultCount);

		ConnectionPool.closeConnection(conn, psmt);
		return resultCount > 0 ? true : false;
	}

	@Override
	public boolean deleteUser(String userId) throws Exception {
		sql = "DELETE FROM users WHERE User_Id=?";
		conn = ConnectionPool.getConnection();
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, userId);
		resultCount = psmt.executeUpdate();

//		System.out.printf("删除%d条记录\n", updateCount);

		ConnectionPool.closeConnection(conn, psmt);
		return resultCount > 0 ? true : false;
	}

}
