package com.youshu.admin.dao;

import com.youshu.admin.bean.EvaluationBean;

import java.util.List;

public interface AdminEvaluateDao {

	
	/**
	 * @param str 要查找的关键词
	 * @return 返回一个列表
	 * @throws Exception 有异常就抛出
	 */
	public List<EvaluationBean> findAll(String str) throws Exception;

	/**
	 * @param orderId 主键
	 * @param ISBN 主键
	 * @return 删除是否成功
	 * @throws Exception 有异常就抛出
	 */
	public boolean deleteEvaluate(String orderId, String ISBN) throws Exception;

}
