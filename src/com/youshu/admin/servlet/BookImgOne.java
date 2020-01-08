package com.youshu.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youshu.admin.bean.PictureBean;
import com.youshu.admin.service.AdminPictureService;

@WebServlet("/admin/BookImgOne")
public class BookImgOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ISBN = request.getParameter("ISBN");
		// 向dao层拿到数据
		List<PictureBean> list = new AdminPictureService().SelectPictureAll(ISBN);
		// 转发页面
		request.setAttribute("ISBN", ISBN);
		request.setAttribute("list", list);
		request.getRequestDispatcher("booksPicModify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
