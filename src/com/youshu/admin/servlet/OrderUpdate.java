package com.youshu.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youshu.admin.service.AdminOrderService;
import com.youshu.common.util.Constants;

@WebServlet("/admin/OrderUpdate")
public class OrderUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String orderID = request.getParameter("OID");
		String ISBN = request.getParameter("ISBN");
		String logisticsNo = request.getParameter("LNO");
		boolean flag = new AdminOrderService().update(orderID, ISBN, logisticsNo);
		
		if (flag) {
			out.print("<script>alert('发货成功!');window.top.location.href='OrderShow';</script>");
		} else {
			out.print("<script>alert('发货失败!');window.location.href='ordersSend.jsp?OID=" + orderID + "&ISBN=" + ISBN
					+ "';</script>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
