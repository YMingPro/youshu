package com.youshu.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youshu.admin.service.AdminSalesService;

@WebServlet("/admin/SaleSelect")
public class SaleSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取时间区间
//		String time = request.getParameter("time");
		// 分割时间区间
		String beginTime = request.getParameter("date1");
		String endTime = request.getParameter("date2");
		double sum=0;
		if (beginTime != null && endTime!= null) {
			sum = new AdminSalesService().getDateRangeAmount(beginTime,endTime);
			request.setAttribute("beginTime", beginTime);
			request.setAttribute("endTime", endTime);
		}else {
			 sum = new AdminSalesService().getAmount();
		}
		// 返回
		request.setAttribute("sum", sum);

		request.getRequestDispatcher("sales.jsp").forward(request, response);
	}

}
