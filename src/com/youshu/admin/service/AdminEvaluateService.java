package com.youshu.admin.service;

import java.util.List;

import com.youshu.admin.bean.EvaluationBean;
import com.youshu.admin.dao.AdminEvaluateDao;
import com.youshu.admin.impl.AdminEvaluateImpl;

public class AdminEvaluateService {

	AdminEvaluateDao dao = new AdminEvaluateImpl();
	List<EvaluationBean> list;
	boolean flag;

	public List<EvaluationBean> find(String str) {
		try {
			list = dao.findAll(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<EvaluationBean> findAll() {
		try {
			list = dao.findAll("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean delete(String[] orderId, String[] ISBN) {
		flag = true;
		try {
			for (int i = 0; i < orderId.length; i++) {
				if (!dao.deleteEvaluate(orderId[i], ISBN[i])) {
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
