package com.youshu.admin.service;

import java.util.List;

import com.youshu.admin.bean.BookBean;
import com.youshu.admin.dao.AdminBookDao;
import com.youshu.admin.impl.AdminBookImpl;
import com.youshu.admin.impl.AdminPictureImpl;

public class AdminBookService {

	AdminBookDao dao = new AdminBookImpl();
	List<BookBean> list;
	BookBean book;
	boolean flag;

	public boolean add(BookBean book, String[][] result) {
		try {
			flag = dao.addBook(book, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List<BookBean> findAll() {
		try {
			list = dao.findAll("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public BookBean findOne(String str) {
		try {
			book = dao.findAll(str).get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	public List<BookBean> find(String str) {
		try {
			list = dao.findAll(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean update(String ISBN, BookBean newBook) {
		try {
			flag = dao.updateBook(ISBN, newBook);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean delete(String[] ISBN) {
		flag = true;
		try {
			for (int i = 0; i < ISBN.length; i++) {
				if (!dao.deleteBook(ISBN[i])) {
					flag = false;
					break;
				}
				if (!new AdminPictureImpl().deletePicture(ISBN[i])) {
					flag = false;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean updateStock(String ISBN) {
		try {
			flag = dao.updateStock(ISBN);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean checkExist(String ISBN) {
		try {
			flag = dao.checkExist(ISBN);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
