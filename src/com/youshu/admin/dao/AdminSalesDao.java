package com.youshu.admin.dao;

public interface AdminSalesDao {

	/**
	 * @return 返回总营业额
	 * @throws Exception 有异常就抛出
	 */
	public Double getAmount() throws Exception;

	/**
	 * @param date1 起始日期
	 * @param date2 终止日期
	 * @return 返回区间营业额
	 * @throws Exception 有异常就抛出
	 */
	public Double getDateRangeAmount(String date1, String date2) throws Exception;
}
