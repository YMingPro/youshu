package com.youshu.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youshu.admin.service.AdminBookService;
import com.youshu.admin.service.AdminOrderService;
import com.youshu.common.util.Constants;

@WebServlet("/admin/OrderCancel")
public class OrderCancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();

		boolean isCancel = request.getParameter("check").equals("1") ? true : false;
		boolean flag = new AdminOrderService().update(request.getParameter("OID"), request.getParameter("ISBN"), isCancel);
		if(flag) new AdminBookService().updateStock(request.getParameter("ISBN"));
		out.print("<script>alert('审核" + (flag ? "成功" : "失败") + "!');window.top.location.href='OrderShow';</script>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
