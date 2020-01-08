package com.youshu.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.youshu.admin.bean.BookBean;
import com.youshu.admin.service.AdminBookService;
import com.youshu.common.util.Constants;
import com.youshu.common.util.Upload;

@WebServlet("/admin/BookAdd")
public class BookAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();

		BookBean book = new BookBean();
		// 实例化Upload
		Upload upload = new Upload(getServletContext(), request, response, getServletConfig());
		SmartUpload su = new SmartUpload();
		boolean flag = true;
		boolean f = false;
		try {
			// 执行upload方法
			su = upload.upload();
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		if (flag) {
			Integer filesNum = su.getFiles().getCount();
			if (filesNum > 0) {
				String[][] result = new String[filesNum][];
				try {
					result = upload.save(su);
				} catch (Exception e) {
					e.printStackTrace();
					flag = false;
				}
				if (flag && filesNum == result.length) {
					// 获取Upload的Request
					Request req = upload.getRequest();
					// 添加到数据库
					AdminBookService dao = new AdminBookService();
					if (dao.checkExist(req.getParameter("ISBN"))) {
						f = false;
					} else {
						f = true;
						// 接收数据
						book.setBookISBN(req.getParameter("ISBN"));
						book.setBookName(req.getParameter("bookName"));
						book.setBookAuthor(req.getParameter("bookAuthor"));
						book.setBookPublisher(req.getParameter("bookPublisher"));
						book.setBookInfo(req.getParameter("bookInfo"));
						book.setBookPrice(Double.valueOf(req.getParameter("bookPrice")));
						book.setBookStock(Integer.valueOf(req.getParameter("bookStock")));

						flag = dao.add(book, result);
						if (!flag) {
							upload.delete(result);
						}
					}

				} else {
					// 删除刚上传的图片
					upload.delete(result);
					flag = false;
				}
			} else {
				flag = false;
			}
		}
		if (flag) {

			out.print("<script>alert('添加成功');window.top.location.href='BookShow';</script>");

		} else {
			if (f) {
				out.print("<script>alert('该书已存在!');window.location.href='booksAdd.jsp';</script>");
			} else {

				out.print("<script>alert('添加失败!');window.location.href='booksAdd.jsp';</script>");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
