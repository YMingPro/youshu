package com.youshu.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.youshu.admin.bean.PictureBean;
import com.youshu.admin.service.AdminPictureService;
import com.youshu.common.util.Constants;
import com.youshu.common.util.Upload;

@WebServlet("/admin/BookImgUpdate")
public class BookImgUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(Constants.encodingFormat);
		response.setContentType("text/html;charset=" + Constants.encodingFormat);
		PrintWriter out = response.getWriter();

		// 实例化Upload
		Upload upload = new Upload(getServletContext(), request, response, getServletConfig());
		SmartUpload su = new SmartUpload();
		boolean flag = true;
		try {
			// 执行upload方法
			su = upload.upload();
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		if (flag) {
			// 获取Upload的Request
			Request req = upload.getRequest();
			// 获取CID
			String ISBN = req.getParameter("ISBN");
			// 获取imgDelId String[]
			String[] imgDelId = req.getParameterValues("imgDelId");

			// 根据imgDelId 获取旧图片路径
			List<PictureBean> oldComPicture = new AdminPictureService().SelectPictureByTip(ISBN, imgDelId);
			// 实例化要删除的图片path数组
			String[] oldPath = new String[oldComPicture.size()];
			for (int i = 0; i < oldComPicture.size(); i++) {
				oldPath[i] = oldComPicture.get(i).getPath();
				System.out.println("!!" + oldPath[i]);
			}
			Integer filesNum = su.getFiles().getCount();
			// 实例化结果集
			String[][] result = new String[filesNum][];
			try {
				result = upload.save(su);
			} catch (Exception e) {
				e.printStackTrace();
				flag = false;
			}
			if (flag && filesNum == result.length) {
				// 添加到数据库

				flag = new AdminPictureService().UpdateComPicture(ISBN, imgDelId, result);
				if (flag) {
					upload.delete(oldPath);
				} else {
					upload.delete(result);
				}
			} else {
				// 删除刚上传的图片
				upload.delete(result);
				flag = false;
			}
			out.print("<script>alert('修改" + (flag ? "成功" : "失败") + "!');window.location.href='BookImgOne?ISBN="
					+ ISBN + "';</script>");
		} else {
			out.print("<script>alert('修改失败!');window.top.location.href='BookShow';</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
