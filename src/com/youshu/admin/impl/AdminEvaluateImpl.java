package com.youshu.admin.impl;

import java.util.ArrayList;
import java.util.List;

import com.youshu.admin.bean.EvaluationBean;
import com.youshu.admin.bean.Model;
import com.youshu.admin.dao.AdminEvaluateDao;
import com.youshu.common.db.ConnectionPool;
import com.youshu.common.util.Tools;

public class AdminEvaluateImpl extends Model implements AdminEvaluateDao {

	final static boolean VIEW = false;

	@Override
	public List<EvaluationBean> findAll(String str) throws Exception {
		sql = "SELECT * FROM v_adminevaluate";
		resultCount=0;
		List<EvaluationBean> list = new ArrayList<EvaluationBean>();

		conn = ConnectionPool.getConnection();
		if (str != null && !str.equals("")) {
			sql += " WHERE Order_NO like ? or Book_ISBN like ? ";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%" + str + "%");
			psmt.setString(2, "%" + str + "%");
		} else {
			psmt = conn.prepareStatement(sql);
		}
		rs = psmt.executeQuery();
		while (rs.next()) {
			resultCount++;
			EvaluationBean evaluate = new EvaluationBean();
			evaluate.setOrderNo(rs.getString("Order_NO"));
			evaluate.setISBN(rs.getString("Book_ISBN"));
			evaluate.setEvaluate(rs.getString("Order_evaluate"));
			evaluate.setEvaluateTime(rs.getDate("Order_Evaltime"));
			list.add(evaluate);
			if (VIEW)
				Tools.printModule(VIEW, evaluate, rs);
		}

//		System.out.printf("总共%d条记录\n", resultCount);

		ConnectionPool.closeConnection(conn, psmt, rs);
		return list;
	}

	@Override
	public boolean deleteEvaluate(String orderId, String ISBN) throws Exception {
		sql = "UPDATE orders SET Order_Evaluate=null,Order_Evaltime=null WHERE Order_NO=? AND Book_ISBN=?";
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
