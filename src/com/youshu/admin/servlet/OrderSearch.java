package com.youshu.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youshu.admin.bean.OrderBean;
import com.youshu.admin.service.AdminOrderService;

/**
 * Servlet implementation class BackSelectOrder
 */
@WebServlet("/admin/OrderSearch")
public class OrderSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String conditions = request.getParameter("conditions") == null ? "" : request.getParameter("conditions");

		List<OrderBean> list = new AdminOrderService().find(conditions);
		request.setAttribute("list", list);
		request.getRequestDispatcher("orders.jsp").forward(request, response);

	}

}
