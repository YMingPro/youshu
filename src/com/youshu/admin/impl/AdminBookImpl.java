package com.youshu.admin.impl;

import java.util.ArrayList;
import java.util.List;

import com.youshu.admin.bean.BookBean;
import com.youshu.admin.bean.Model;
import com.youshu.admin.dao.AdminBookDao;
import com.youshu.common.db.ConnectionPool;
import com.youshu.common.util.Tools;

public class AdminBookImpl extends Model implements AdminBookDao {

	final static boolean VIEW = false;

	@Override
	public List<BookBean> findAll(String str) throws Exception {
		sql = "SELECT DISTINCT * FROM book";
		resultCount = 0;
		List<BookBean> list = new ArrayList<BookBean>();

		conn = ConnectionPool.getConnection();
		if (str != null && !str.equals("")) {
			sql += " WHERE Book_ISBN like ? or Book_Name like ? or Book_Author like ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%" + str + "%");
			psmt.setString(2, "%" + str + "%");
			psmt.setString(3, "%" + str + "%");
		} else {
			psmt = conn.prepareStatement(sql);
		}
		rs = psmt.executeQuery();
		while (rs.next()) {
			resultCount++;
			BookBean book = new BookBean();
			book.setBookISBN(rs.getString("Book_ISBN"));
			book.setBookName(rs.getString("Book_Name"));
			book.setBookAuthor(rs.getString("Book_Author"));
			book.setBookPublisher(rs.getString("Book_Publisher"));
			book.setBookPrice(rs.getDouble("Book_Price"));
			book.setBookInfo(rs.getString("Book_Info"));
			book.setBookStock(rs.getInt("Book_Stock"));
			list.add(book);
			if (VIEW)
				Tools.printModule(VIEW, book, rs);
		}

//		System.out.printf("总共有%d条记录\n", resultCount);

		ConnectionPool.closeConnection(conn, psmt, rs);
		return list;
	}

	@Override
	public boolean updateBook(String ISBN, BookBean newBook) throws Exception {
		sql = "UPDATE book SET Book_ISBN=?, Book_Name=?, Book_Author=?, Book_Publisher=?, Book_Price=?, Book_Info=?, Book_Stock=? WHERE Book_ISBN=?";
		conn = ConnectionPool.getConnection();
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, newBook.getBookISBN());
		psmt.setString(2, newBook.getBookName());
		psmt.setString(3, newBook.getBookAuthor());
		psmt.setString(4, newBook.getBookPublisher());
		psmt.setDouble(5, newBook.getBookPrice());
		psmt.setString(6, newBook.getBookInfo());
		psmt.setInt(7, newBook.getBookStock());
		psmt.setString(8, ISBN);
		resultCount = psmt.executeUpdate();

//		System.out.printf("更新%d条记录\n", resultCount);

		ConnectionPool.closeConnection(conn, psmt);
		return resultCount > 0 ? true : false;
	}

	@Override
	public boolean deleteBook(String ISBN) throws Exception {
		sql = "DELETE FROM book WHERE Book_ISBN=?";
		conn = ConnectionPool.getConnection();
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, ISBN);
		resultCount = psmt.executeUpdate();

//		System.out.printf("更新%d条记录\n", resultCount);

		ConnectionPool.closeConnection(conn, psmt);
		return resultCount > 0 ? true : false;
	}

	@Override
	public boolean addBook(BookBean book, String[][] result) throws Exception {
		String ISBN = null;
		flag = false;
		conn = ConnectionPool.getConnection();
		sql = "INSERT INTO book VALUES(?,?,?,?,?,?,?,null,null)";
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, book.getBookISBN());
		psmt.setString(2, book.getBookName());
		psmt.setString(3, book.getBookAuthor());
		psmt.setString(4, book.getBookPublisher());
		psmt.setDouble(5, book.getBookPrice());
		psmt.setString(6, book.getBookInfo());
		psmt.setInt(7, book.getBookStock());
		resultCount = psmt.executeUpdate();
		if (resultCount > 0) {
			ISBN = book.getBookISBN();
		} else {
			return false;
		}
//		System.out.printf("更新%d条记录\n", resultCount);

		if (ISBN != null) {
			int tip = new AdminPictureImpl().getTip(ISBN);
			sql = "INSERT INTO picture VALUES(?,?,?);";
			psmt = conn.prepareStatement(sql);
			for (String[] path : result) {
				psmt.setString(1, ISBN);
				psmt.setString(2, path[1]);
				psmt.setInt(3, ++tip);
				psmt.addBatch();
			}
			int[] res = psmt.executeBatch();
			for (int i : res) {
				flag = i > 0 ? true : false;
			}
		}
		
		ConnectionPool.closeConnection(conn,psmt);
		return flag;
	}

	@Override
	public boolean updateStock(String ISBN) throws Exception {
		conn = ConnectionPool.getConnection();
		sql = "UPDATE book SET Book_Stock=Book_Stock+1 WHERE  Book_ISBN=?";
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, ISBN);
		resultCount = psmt.executeUpdate();

		ConnectionPool.closeConnection(conn, psmt);
		return resultCount > 0 ? true : false;
	}

	@Override
	public boolean checkExist(String ISBN) throws Exception {
		sql = "select count(*) from book WHERE Book_ISBN=?";
		resultCount = 0;
		conn = ConnectionPool.getConnection();
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, ISBN);
		rs = psmt.executeQuery();
		while (rs.next()) {
			resultCount++;
		}

		ConnectionPool.closeConnection(conn, psmt, rs);
		return resultCount > 0 ? false : true;
	}

}
