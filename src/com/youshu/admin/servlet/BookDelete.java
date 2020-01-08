package com.youshu.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youshu.admin.service.AdminBookService;
import com.youshu.common.util.Constants;

/**
 * Servlet implementation class BookDelete
 */
@WebServlet("/admin/BookDelete")
public class BookDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();
		
		String ISBN[] = request.getParameterValues("ISBN");
		boolean flag = new AdminBookService().delete(ISBN);
		
		out.print("<script>alert('删除" + (flag ? "成功" : "失败") + "!');window.top.location.href='BookShow';</script>");
	}

}
