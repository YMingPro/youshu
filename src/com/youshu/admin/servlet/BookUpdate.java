package com.youshu.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youshu.admin.bean.BookBean;
import com.youshu.admin.service.AdminBookService;
import com.youshu.common.util.Constants;

/**
 * Servlet implementation class BookUpdate
 */
@WebServlet("/admin/BookUpdate")
public class BookUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();
		// 接收数据
		BookBean book = new BookBean();
		book.setBookISBN(request.getParameter("bookISBN"));
		book.setBookName(request.getParameter("bookName"));
		book.setBookAuthor(request.getParameter("bookAuthor"));
		book.setBookPublisher(request.getParameter("bookPublisher"));
		book.setBookInfo(request.getParameter("bookInfo"));
		book.setBookPrice(Double.valueOf(request.getParameter("bookPrice")));
		book.setBookStock(Integer.valueOf(request.getParameter("bookStock")));
		String ISBN = request.getParameter("ISBN");

		boolean flag = new AdminBookService().update(ISBN, book);
		out.print("<script>alert('修改" + (flag ? "成功" : "失败") + "!');window.top.location.href='BookShow';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
