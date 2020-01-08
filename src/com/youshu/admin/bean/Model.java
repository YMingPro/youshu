package com.youshu.admin.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Model {
	public Connection conn;
	public PreparedStatement psmt;
	public ResultSet rs;
	public String sql;
	public int resultCount;
	public boolean flag;
}
