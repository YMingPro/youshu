package com.youshu.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youshu.admin.bean.UserBean;
import com.youshu.admin.service.AdminUserService;
import com.youshu.common.util.Constants;

@WebServlet("/admin/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();
		
		// 接收数据
		String UID = request.getParameter("UID");
		UserBean user = new UserBean();
		user.setUserId(request.getParameter("UID"));
		user.setUserSex(request.getParameter("userSex"));
		user.setUserName(request.getParameter("userName"));

		boolean flag = new AdminUserService().update(UID, user);
		out.print("<script>alert('修改" + (flag ? "成功" : "失败") + "!');window.top.location.href='UserShow';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
