package com.youshu.admin.impl;

import java.util.ArrayList;
import java.util.List;

import com.youshu.admin.bean.Model;
import com.youshu.admin.bean.PictureBean;
import com.youshu.admin.dao.AdminPictureDao;
import com.youshu.common.db.ConnectionPool;

public class AdminPictureImpl extends Model implements AdminPictureDao {

	int tip;

	@Override
	public boolean addPicture(PictureBean picture) throws Exception {// 添加商品图片
		tip = getTip(picture.getISBN());
		conn = ConnectionPool.getConnection();
		sql = "INSERT INTO picture VALUES(?,?,?)";
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, picture.getISBN());
		psmt.setString(2, picture.getPath());
		psmt.setInt(1, ++tip);
		resultCount = psmt.executeUpdate();

		ConnectionPool.closeConnection(conn, psmt);
		return resultCount >= 1 ? true : false;
	}

	@Override
	public boolean deletePicture(String ISBN) throws Exception {
		sql = "DELETE FROM picture WHERE ISBN=?";
		conn = ConnectionPool.getConnection();
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, ISBN);
		resultCount = psmt.executeUpdate();

//		System.out.printf("删除%d条记录\n", resultCount);

		ConnectionPool.closeConnection(conn, psmt);
		return resultCount >= 0 ? true : false;
	}

	public PictureBean selectPictureOne(String ISBN) throws Exception {// 根据主键ISBN查询
		PictureBean picture = new PictureBean();
		conn = ConnectionPool.getConnection();
		sql = "SELECT * FROM picture WHERE ISBN=?";
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, ISBN);
		rs = psmt.executeQuery();
		while (rs.next()) {
			picture.setISBN(rs.getString(1));
			picture.setTip(rs.getInt(3));
			picture.setPath(rs.getString(2));
		}

		ConnectionPool.closeConnection(conn, psmt, rs);
		return picture;
	}

	/** DDD */
	public List<PictureBean> SelectPictureAll(String ISBN) throws Exception {// 查询图书图片
		List<PictureBean> list = new ArrayList<>();
		conn = ConnectionPool.getConnection();
		sql = "SELECT * FROM picture WHERE ISBN =? ";
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, ISBN);
		rs = psmt.executeQuery();
		while (rs.next()) {
			PictureBean picture = new PictureBean();
			picture.setISBN(rs.getString(1));
			picture.setTip(rs.getInt(3));
			picture.setPath(rs.getString(2));
			list.add(picture);
		}

		ConnectionPool.closeConnection(conn, psmt, rs);
		return list;
	}

	public List<PictureBean> SelectPictureByTip(String ISBN, String[] tips) throws Exception {// 查询图片,根据tip
		List<PictureBean> list = new ArrayList<PictureBean>();
		if (tips != null && tips.length > 0) {
			conn = ConnectionPool.getConnection();
			sql = "SELECT * FROM picture WHERE ISBN='" + ISBN + "' AND tip in (";
			for (int i = 0; i < tips.length; i++) {
				if (i != 0) {
					sql += ",";
				}
				sql += "?";
			}
			sql += ")";
			psmt = conn.prepareStatement(sql);
			for (int i = 1; i <= tips.length; i++) {
				psmt.setString(i, tips[i - 1]);
			}
			rs = psmt.executeQuery();
			while (rs.next()) {
				PictureBean picture = new PictureBean();
				picture.setISBN(rs.getString(1));
				picture.setTip(rs.getInt(3));
				picture.setPath(rs.getString(2));
				list.add(picture);
			}
		}

		ConnectionPool.closeConnection(conn, psmt, rs);
		return list;
	}

	public boolean UpdateComPicture(String ISBN, String[] imgDelId, String[][] result) throws Exception {
		flag = false;
		if (imgDelId != null && imgDelId.length > 0) {
			conn = ConnectionPool.getConnection();
			sql = "DELETE FROM picture WHERE ISBN='" + ISBN + "' AND tip = ?";
			psmt = conn.prepareStatement(sql);
			for (String s : imgDelId) {
				psmt.setString(1, s);
				psmt.addBatch();
			}
			int[] t = psmt.executeBatch();
			for (int i : t)
				if (i < 0)
					return false;
			flag = true;
		}

		if (result != null && result.length > 0) {
			tip = getTip(ISBN);
			sql = "INSERT INTO picture VALUES(?,?,?);";
			conn = ConnectionPool.getConnection();
			psmt = conn.prepareStatement(sql);
			for (String[] path : result) {
				psmt.setString(1, ISBN);
				psmt.setString(2, path[1]);
				psmt.setInt(3, ++tip);
				psmt.addBatch();
			}
			int[] t = psmt.executeBatch();
			for (int i : t)
				if (i < 0)
					return false;
			flag = true;
		}

		ConnectionPool.closeConnection(conn, psmt);
		return flag;
	}

	public int getTip(String ISBN) throws Exception {
		sql = "select count(*) from picture where ISBN=?";
		conn = ConnectionPool.getConnection();
		psmt = null;
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, ISBN);
		rs = psmt.executeQuery();
		tip = rs.next() ? rs.getInt(1) : 0;

		ConnectionPool.closeConnection(conn, psmt, rs);
		return tip;
	}
}
