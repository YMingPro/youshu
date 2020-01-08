package com.youshu.admin.impl;

import java.util.ArrayList;
import java.util.List;

import com.youshu.admin.bean.Model;
import com.youshu.admin.bean.OrderBean;
import com.youshu.admin.dao.AdminOrderDao;
import com.youshu.common.db.ConnectionPool;
import com.youshu.common.util.Tools;

public class AdminOrderImpl extends Model implements AdminOrderDao {

	final static boolean VIEW = false;

	@Override
	public List<OrderBean> findAll(String str) throws Exception {
		sql = "SELECT DISTINCT * FROM v_adminorder";
		resultCount=0;
		List<OrderBean> list = new ArrayList<OrderBean>();
		conn = ConnectionPool.getConnection();
		if (str != null && !str.equals("")) {// 模糊查询
			sql += " WHERE Order_NO like ? or User_Id like ? or Book_Name like ? or Book_ISBN like ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%" + str + "%");
			psmt.setString(2, "%" + str + "%");
			psmt.setString(3, "%" + str + "%");
			psmt.setString(4, "%" + str + "%");
		} else {
			psmt = conn.prepareStatement(sql);
		}
		rs = psmt.executeQuery();
		while (rs.next()) {
			resultCount++;
			OrderBean order = new OrderBean();
			order.setOrderNO(rs.getString("Order_NO"));
			order.setUserId(rs.getString("User_Id"));
			order.setBookName(rs.getString("Book_Name"));
			order.setBookISBN(rs.getString("Book_ISBN"));
			order.setTotal(rs.getDouble("Total"));
			order.setAddress(rs.getString("Address"));
			order.setLogisticsNo(rs.getString("Logistics_No") != null ? rs.getString("Logistics_No") : "");
			order.setStatus(rs.getString("Status"));
			list.add(order);
			if (VIEW)
				Tools.printModule(VIEW, order, rs);
		}

//		System.out.printf("总共%d条记录\n", resultCount);

		ConnectionPool.closeConnection(conn, psmt, rs);
		return list;
	}

	@Override
	public boolean checkExist(String logisticsNo) throws Exception {
		sql = "SELECT DISTINCT Order_NO,Logistics_No FROM orders WHERE Logistics_No=?";
		conn = ConnectionPool.getConnection();
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, logisticsNo);
		rs = psmt.executeQuery();
		resultCount = 0;
		while (rs.next()) {
			resultCount++;
		}
		ConnectionPool.closeConnection(conn, psmt, rs);
		return resultCount > 0 ? false : true;
	}

	@Override
	public boolean updateOut(String orderId, String ISBN, String logisticsNo) throws Exception {
		if (checkExist(logisticsNo)) {
			sql = "UPDATE orders SET Logistics_No=? ,Order_Gotime=?,Order_Out=? WHERE Order_NO=? AND Book_ISBN=?";
			conn = ConnectionPool.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, logisticsNo);
			psmt.setString(2, Tools.getNowTime());
			psmt.setString(3, "已发货");
			psmt.setString(4, orderId);
			psmt.setString(5, ISBN);
			resultCount = psmt.executeUpdate();

//			System.out.printf("更新%d条记录\n", resultCount);

			ConnectionPool.closeConnection(conn, psmt);
			return resultCount > 0 ? true : false;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateCancel(String orderId, String ISBN, boolean isReturn) throws Exception {
		conn = ConnectionPool.getConnection();
		if (isReturn) { // 如果同意退货，则修改状态为已取消，反之恢复原来状态
			sql = "UPDATE orders SET Order_Return=? ,Order_Out=? WHERE Order_NO=? AND Book_ISBN=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "false");
			psmt.setString(2, "已取消");
			psmt.setString(3, orderId);
			psmt.setString(4, ISBN);
		} else {
			sql = "UPDATE orders SET Order_Return=? WHERE Order_NO=? AND Book_ISBN=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "false");
			psmt.setString(2, orderId);
			psmt.setString(3, ISBN);
		}
		resultCount = psmt.executeUpdate();

//		System.out.printf("更新%d条记录\n", resultCount);

		ConnectionPool.closeConnection(conn, psmt);
		return resultCount > 0 ? true : false;
	}

	@Override
	public boolean deleteOrder(String orderId, String ISBN) throws Exception {
		sql = "DELETE FROM orders WHERE Order_NO=? AND Book_ISBN=?";
		conn = ConnectionPool.getConnection();
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, orderId);
		psmt.setString(2, ISBN);
		resultCount = psmt.executeUpdate();

//		System.out.printf("删除%d条记录\n", resultCount);

		ConnectionPool.closeConnection(conn, psmt);
		return resultCount > 0 ? true : false;
	}

}
