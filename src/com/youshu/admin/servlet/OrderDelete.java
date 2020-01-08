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

/**
 * Servlet implementation class BackDeleteOrder
 */
@WebServlet("/admin/OrderDelete")
public class OrderDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();
		
		String OID[] = request.getParameterValues("OID");
		String ISBN[] = request.getParameterValues("ISBN");
		boolean flag = new AdminOrderService().delete(OID, ISBN);
		
		out.print("<script>alert('删除" + (flag ? "成功" : "失败") + "!');window.top.location.href='OrderShow';</script>");
	}
}
