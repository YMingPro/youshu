package com.youshu.admin.dao;

import java.sql.SQLException;
import java.util.List;

import com.youshu.admin.bean.UserBean;

public interface AdminUserDao {

	/**
	 * @return 返回所有用户列表
	 * @throws SQLException 有异常就抛出
	 */
	public List<UserBean> findAll(String str) throws Exception;

	/**
	 * @param userId  要更新的用户ID
	 * @param newUser 修改的内容集合
	 * @return 是否更新成功的标记
	 * @throws SQLException 有异常就抛出
	 */
	public boolean updateUser(String userId, UserBean newUser) throws Exception;

	/**
	 * @return 是否删除成功的标记
	 * @throws SQLException 有异常就抛出
	 */
	public boolean deleteUser(String userId) throws Exception;

}
