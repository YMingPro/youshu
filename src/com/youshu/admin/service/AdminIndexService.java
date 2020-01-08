package com.youshu.admin.service;

import java.sql.SQLException;

import com.youshu.admin.bean.Model;
import com.youshu.common.db.ConnectionPool;
import com.youshu.common.util.Tools;

/** 本类用于初始化首页板块的数据 */
public class AdminIndexService extends Model {

	String loginTime;
	int today;

	/* 统计板块 */
	// 该方法用于统计订单、用户、图书总量
	public int getTotalCount(String tableName) {
		sql = "SELECT Count(*) FROM " + tableName;
		try {
			rs = ConnectionPool.getConnection().prepareStatement(sql).executeQuery();
			resultCount = rs.next() ? rs.getInt(1) : 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConnectionPool.closeConnection(rs);
		return resultCount;
	}

	// 该方法用于统计总的访问量
	public int getVisitCount() {
		sql = "select * from module where module_name='totalvisit'";
		try {
			rs = ConnectionPool.getConnection().prepareStatement(sql).executeQuery();
			resultCount = rs.next() ? Integer.valueOf(rs.getString(2)) : 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		ConnectionPool.closeConnection(rs);
		return resultCount;
	}

	/* 消息板块 */
	// 该方法用来在处理订单消息
	public String getOrderMessage() {
		int count1 = 0, count2 = 0;
		try {
			sql = "select count(*) from orders where Order_Out='未发货'";
			rs = ConnectionPool.getConnection().createStatement().executeQuery(sql);
			count1 = rs.next() ? rs.getInt(1) : 0;
			sql = "select count(*) from orders where Order_Return='true'";
			rs = ConnectionPool.getConnection().createStatement().executeQuery(sql);
			count2 = rs.next() ? rs.getInt(1) : 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		String info = "";
		if (count2 > 0) {
			info = count1 > 0
					? ("<a href=\"OrderShow\" style=\"color:red\">您有" + count1 + "条订单未发货，" + count2 + "条退货订单未处理</a>")
					: ("<a href=\"OrderShow\" style=\"color:red\">您有" + count2 + "条退货订单未处理</a>");
		} else {
			info = count1 > 0 ? ("<a href=\"OrderShow\" style=\"color:red\">您有" + count1 + "条订单未发货</a>") : "暂无订单处理";
		}

		ConnectionPool.closeConnection(rs);
		return info;
	}

	// 该方法用于获取登录时间LoginTime
	public String getLoginTime() {
		sql = "select module_value from module where module_name='loginTime'";
		try {
			rs = ConnectionPool.getConnection().createStatement().executeQuery(sql);
			loginTime = rs.next() ? rs.getString(1) : "Unknown Time";
		} catch (Exception e) {
			e.printStackTrace();
		}

		ConnectionPool.closeConnection(rs);
		return loginTime;
	}

	/* 处理后台登录时间更新 */
	// 获取上次登录后缓存在temp的时间信息
	public String getLoginTemp() {
		sql = "select module_value from module where module_name='loginTimeTemp'";
		String logintime = null;
		try {
			psmt = ConnectionPool.getConnection().prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				logintime = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ConnectionPool.closeConnection(psmt, rs);
		return logintime;
	}

	// LoginTemp -> LoginTime
	public boolean updateLastLogin() {
		String temp = getLoginTemp();
		sql = "update module set module_value=? where module_name='loginTime'";
		flag = false;
		try {
			psmt = ConnectionPool.getConnection().prepareStatement(sql);
			psmt.setString(1, temp);
			flag = psmt.executeUpdate() > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnectionPool.closeConnection(psmt);
		return flag;
	}

	// 本次时间 -> LoginTemp
	public boolean updateLoginTime() {
		sql = "update module set module_value=? where module_name='loginTimeTemp'";
		flag = false;
		try {
			psmt = ConnectionPool.getConnection().prepareStatement(sql);
			psmt.setString(1, Tools.getNowTime());
			flag = psmt.executeUpdate() > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnectionPool.closeConnection(psmt);
		return flag;
	}

	// 登录时间总处理
	public void updateTime() {
		updateLastLogin();
		updateLoginTime();
	}

	/* 数据图表板块 */
	// 获取七日访问量
	public int[] getVisitTime() {
		sql = "select counter from visitcount where to_days(NOW()) - TO_DAYS(riqi) = ?";
		conn = ConnectionPool.getConnection();
		int[] visitcount = new int[7];
		try {
			for (int i = 1; i < visitcount.length; i++) {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, i);
				rs = psmt.executeQuery();
				visitcount[i] = rs.next() ? rs.getInt(1) : 0;
			}
			visitcount[0] = getVisitToday();
		} catch (Exception e) {
			e.printStackTrace();
		}

		ConnectionPool.closeConnection(conn, psmt, rs);
		return visitcount;
	}

	// 获取七日用户量
	public int[] getUserTime() {
		sql = "select count(*) from users where to_days(NOW()) - TO_DAYS(createTime) >= ?";
		conn = ConnectionPool.getConnection();
		int[] userCount = new int[7];
		try {
			for (int i = 0; i < userCount.length; i++) {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, i);
				rs = psmt.executeQuery();
				userCount[i] = rs.next() ? rs.getInt(1) : 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ConnectionPool.closeConnection(conn, psmt, rs);
		return userCount;
	}

	// 获取七日订单量
	public int[] getOrderTime() {
		sql = "select count(*) from orders where to_days(NOW()) - TO_DAYS(Order_Time) >= ?";
		conn = ConnectionPool.getConnection();
		int[] orderCount = new int[7];
		try {
			for (int i = 0; i < orderCount.length; i++) {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, i);
				rs = psmt.executeQuery();
				orderCount[i] = rs.next() ? rs.getInt(1) : 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ConnectionPool.closeConnection(conn, psmt, rs);
		return orderCount;
	}

	/* 今日数据板块 */
	// 获取今日新访问量
	public int getVisitToday() {
		sql = "select module_value from module where module_name='dayvisit'";
		try {
			psmt = ConnectionPool.getConnection().prepareStatement(sql);
			rs = psmt.executeQuery();
			today = rs.next() ? rs.getInt(1) : 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		ConnectionPool.closeConnection(psmt, rs);
		return today;
	}

	// 获取今日新评论数
	public int getEvaluationToday() {
		sql = "select count(*) from orders where to_days(NOW()) - TO_DAYS(Order_Evaltime) = 0";
		try {
			psmt = ConnectionPool.getConnection().prepareStatement(sql);
			rs = psmt.executeQuery();
			today = rs.next() ? rs.getInt(1) : 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		ConnectionPool.closeConnection(psmt, rs);
		return today;
	}

	// 获取今日新用户数
	public int getUserToday() {
		sql = "select count(*) from users where to_days(NOW()) - TO_DAYS(createTime) = 0";
		try {
			psmt = ConnectionPool.getConnection().prepareStatement(sql);
			rs = psmt.executeQuery();
			today = rs.next() ? rs.getInt(1) : 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		ConnectionPool.closeConnection(psmt, rs);
		return today;
	}

	// 获取今日新订单量
	public int getOrderToday() {
		sql = "select count(*) from orders where to_days(NOW()) - TO_DAYS(Order_Time) = 0";
		try {
			psmt = ConnectionPool.getConnection().prepareStatement(sql);
			rs = psmt.executeQuery();
			today = rs.next() ? rs.getInt(1) : 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		ConnectionPool.closeConnection(psmt, rs);
		return today;
	}

}
