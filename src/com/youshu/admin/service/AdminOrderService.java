package com.youshu.admin.service;

import java.util.List;

import com.youshu.admin.bean.OrderBean;
import com.youshu.admin.dao.AdminOrderDao;
import com.youshu.admin.impl.AdminOrderImpl;

public class AdminOrderService {

	AdminOrderDao dao = new AdminOrderImpl();
	List<OrderBean> list;
	boolean flag;

	// 退货更新
	public boolean update(String orderId, String ISBN, boolean returnConfirm) {
		try {
			flag = dao.updateCancel(orderId, ISBN, returnConfirm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// 发货更新
	public boolean update(String orderId, String ISBN, String logisticsNo) {
		try {
			flag = dao.updateOut(orderId, ISBN, logisticsNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List<OrderBean> findAll() {
		try {
			list = dao.findAll("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<OrderBean> find(String str) {
		try {
			list = dao.findAll(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean delete(String[] orderId, String[] ISBN) {
		flag = true;
		try {
			for (int i = 0; i < orderId.length; i++) {
				if (!dao.deleteOrder(orderId[i], ISBN[i])) {
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
