package com.youshu.admin.service;

import com.youshu.admin.dao.AdminSalesDao;
import com.youshu.admin.impl.AdminSalesImpl;

public class AdminSalesService {
	AdminSalesDao dao = new AdminSalesImpl();
	Double amount;

	public Double getAmount() {
		try {
			amount = dao.getAmount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return amount;
	}

	public Double getDateRangeAmount(String date1, String date2) {
		try {

			amount = dao.getDateRangeAmount(date1, date2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return amount;
	}

}
