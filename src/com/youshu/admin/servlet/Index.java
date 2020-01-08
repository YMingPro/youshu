package com.youshu.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youshu.admin.service.AdminIndexService;
import com.youshu.common.util.Constants;

/**
 * Servlet implementation class CountNumber
 */
@WebServlet("/admin/index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		
		AdminIndexService dao = new AdminIndexService();
		//总数量板块
		int visitCount = dao.getVisitCount();
		int bookCount = dao.getTotalCount("book");
		int orderCount = dao.getTotalCount("orders");
		int userCount = dao.getTotalCount("users");
		//信息板块
		String loginTime = dao.getLoginTime();
		String msgInfo = dao.getOrderMessage();
		//图表板块
		int[] userdate = dao.getUserTime();
		int[] orderdate = dao.getOrderTime();
		int[] visitdate = dao.getVisitTime();
		//今日板块
		int usertoday = dao.getUserToday();
		int ordertoday = dao.getOrderToday();
		int evaluationtoday = dao.getEvaluationToday();
		int visittoday = dao.getVisitToday();

		request.setAttribute("bookCount", bookCount);
		request.setAttribute("orderCount", orderCount);
		request.setAttribute("userCount", userCount);
		request.setAttribute("visitCount", visitCount);
		
		request.setAttribute("loginTime", loginTime);
		request.setAttribute("msgInfo", msgInfo);
		
		request.setAttribute("userdate", userdate);
		request.setAttribute("orderdate", orderdate);
		request.setAttribute("visitdate", visitdate);
		
		request.setAttribute("ordertoday", ordertoday);
		request.setAttribute("usertoday", usertoday);
		request.setAttribute("evaluationtoday", evaluationtoday);
		request.setAttribute("visittoday", visittoday);
		
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
