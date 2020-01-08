package com.youshu.admin.dao;

import java.util.List;

import com.youshu.admin.bean.PictureBean;

public interface AdminPictureDao {

	/**
	 * @describe 获取ISBN图片的tip总量
	 */
	public int getTip(String ISBN) throws Exception;

	/**
	 * @describe 添加图片
	 */
	public boolean addPicture(PictureBean comPicture) throws Exception;

	/**
	 * @describe 按ISBN查找
	 * @return 返回一个Bean
	 */
	public PictureBean selectPictureOne(String ISBN) throws Exception;

	/**
	 * @describe 按ISBN查找
	 * @return 返回一个列表
	 */
	public List<PictureBean> SelectPictureAll(String ISBN) throws Exception;

	/**
	 * @describe 精确查找某张图片
	 */
	public List<PictureBean> SelectPictureByTip(String ISBN, String[] tip) throws Exception;

	/**
	 * @describe 更新图片
	 */
	public boolean UpdateComPicture(String ISBN, String[] imgDelId, String[][] result) throws Exception;

	/**
	 * @describe 删除图片
	 */
	public boolean deletePicture(String ISBN) throws Exception;
}
