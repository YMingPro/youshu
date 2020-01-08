package com.youshu.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youshu.admin.bean.BookBean;
import com.youshu.admin.service.AdminBookService;

@WebServlet("/admin/BookOne")
public class BookOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收数据
		String ISBN = request.getParameter("ISBN");
		// 向dao层拿到数据
		BookBean book= new AdminBookService().findOne(ISBN);
		// 转发页面
		request.setAttribute("book", book);
		request.getRequestDispatcher("booksModify.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
