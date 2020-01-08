package com.youshu.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youshu.admin.bean.UserBean;
import com.youshu.admin.service.AdminUserService;

@WebServlet("/admin/UserOne")
public class UserOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收数据
		String UID = request.getParameter("UID");
		UserBean user= new AdminUserService().findOne(UID);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("usersModify.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
