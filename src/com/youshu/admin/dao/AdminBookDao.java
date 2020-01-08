package com.youshu.admin.dao;

import java.util.List;

import com.youshu.admin.bean.BookBean;

public interface AdminBookDao {

	/**
	 * @param book 要添加的书本
	 * @return 是否添加成功的标记
	 * @throws Exception 有异常就抛出
	 */
	public boolean addBook(BookBean book, String[][] result) throws Exception;

	/**
	 * @param str 查找的关键词
	 * @return 返回所有符合的书本
	 * @throws Exception 有异常就抛出
	 */
	public List<BookBean> findAll(String str) throws Exception;

	/**
	 * @param ISBN 要更改的书本ISBN
	 * @param newBook 修改的书本
	 * @return 是否更新成功的标记
	 * @throws Exception 有异常就抛出
	 */
	public boolean updateBook(String ISBN, BookBean newBook) throws Exception;

	/**
	 * @param ISBN 要删除的书本ISBN
	 * @return 是否删除成功的标记
	 * @throws Exception 有异常就抛出
	 */
	public boolean deleteBook(String ISBN) throws Exception;

	/**
	 * @param ISBN 要更新库存的ISBN
	 * @return 是否更新成功的标记
	 * @throws Exception
	 */
	public boolean updateStock(String ISBN) throws Exception;

	
	/**
	 * @describe 检查重复
	 */
	public boolean checkExist(String ISBN)throws Exception;
}
