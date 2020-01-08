package com.youshu.admin.dao;

import java.util.List;

import com.youshu.admin.bean.OrderBean;

public interface AdminOrderDao {

	/**
	 * @param str 查找的关键词
	 * @return 返回所有符合的订单
	 * @throws Exception 有异常就抛出
	 */
	public List<OrderBean> findAll(String str) throws Exception;

	/**
	 * @describe 发货方法
	 * @param orderId 主键
	 * @param ISBN  主键
	 * @param logisticsNo 填上快递单
	 * @return 返回修改是否成功
	 * @throws Exception 有异常就抛出
	 */
	public boolean updateOut(String orderId, String ISBN, String logisticsNo) throws Exception;

	/**
	 * @describe退货方法
	 * @param orderId  主键
	 * @param ISBN 主键
	 * @param returnConfirm 修改取消状态
	 * @return 返回修改是否成功
	 * @throws Exception 有异常就抛出
	 */
	public boolean updateCancel(String orderId, String ISBN, boolean returnConfirm) throws Exception;

	/**
	 * @param orderId 要删除的订单id
	 * @return 是否删除成功的标记
	 * @throws Exception 有异常就抛出
	 */
	public boolean deleteOrder(String orderId, String ISBN) throws Exception;

	/**
	 * @describe 检查是否有重复的单号
	 * @param logisticsNo 查找的单号
	 * @return 如果有单号则返回失败
	 * @throws Exception 有异常就抛出
	 */
	public boolean checkExist(String logisticsNo) throws Exception;
}
