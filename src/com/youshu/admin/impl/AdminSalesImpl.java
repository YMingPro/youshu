package com.youshu.admin.impl;

import com.youshu.admin.bean.Model;
import com.youshu.admin.dao.AdminSalesDao;
import com.youshu.common.db.ConnectionPool;

public class AdminSalesImpl extends Model implements AdminSalesDao {
	double money;

	@Override
	public Double getAmount() throws Exception {
		sql = "SELECT * FROM v_adminsales";
		conn = ConnectionPool.getConnection();
		psmt = conn.prepareStatement(sql);
		rs = psmt.executeQuery();
		money = rs.next() ? rs.getDouble(1) : 0;

		ConnectionPool.closeConnection(conn, psmt, rs);
		return money;
	}

	public Double getDateRangeAmount(String date1, String date2) throws Exception {
		sql = "select sum(Total) from v_adminorder where Order_Time between ?  and ? ";
		conn = ConnectionPool.getConnection();
		psmt = conn.prepareStatement(sql);
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, date1);
		psmt.setString(2, date2);
		System.out.println(date1);
		System.out.println(date2);
		rs = psmt.executeQuery();
		money = rs.next() ? rs.getDouble(1) : 0;
		
		ConnectionPool.closeConnection();
		return money;
	}

}
