package com.youshu.common.db;

import java.sql.*;

public class ConnectionPool {
	private static final String Driver = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://115.29.239.199:3306/youshu_system?useSSL=false";// useUnicode=true&characterEncoding=utf-8&&allowPublicKeyRetrieval=true
//	private static final String URL = "jdbc:mysql://localhost:3306/youshu_system?useSSL=false";// useUnicode=true&characterEncoding=utf-8&&allowPublicKeyRetrieval=true
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	public static Connection conn = null;

	// 两个主要的操作，获得数据库和关闭数据库
	public static Connection getConnection() {
		try {
			Class.forName(Driver); // 用反射加载数据库驱动
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
//            System.out.println("\033[34;1m"+"连接成功"+ "\033[0m");
		} catch (Exception e) {
			System.out.println("SQL驱动程序初始失败");
			e.printStackTrace();
		}
		return conn; // 取得数据库的连接
	}

	public static void closeConnection() { // 关闭数据库
		if (conn != null) {
			try {
				conn.close(); // 数据库关闭
//                System.out.println("\033[34;1m"+"关闭成功"+ "\033[0m");
			} catch (Exception e) {
				System.out.println("数据库关闭失败");
				e.printStackTrace();
			}
		}
	}

	public static void closeConnection(Connection conn, PreparedStatement psmt) { // 关闭数据库
		if (psmt != null) {
			try {
				psmt.close(); // 数据库关闭
//                System.out.println("\033[34;1m"+"关闭成功"+ "\033[0m");
			} catch (Exception e) {
//                System.out.println("数据库关闭失败");
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close(); // 数据库关闭
//                System.out.println("\033[34;1m"+"关闭成功"+ "\033[0m");
			} catch (Exception e) {
				System.out.println("数据库关闭失败");
				e.printStackTrace();
			}
		}
	}

	public static void closeConnection(Connection conn, PreparedStatement psmt, ResultSet rs) { // 关闭数据库
		if (rs != null) {
			try {
				rs.close(); // 数据库关闭
//                System.out.println("\033[34;1m"+"关闭成功"+ "\033[0m");
			} catch (Exception e) {
//                System.out.println("数据库关闭失败");
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close(); // 数据库关闭
//                System.out.println("\033[34;1m"+"关闭成功"+ "\033[0m");
			} catch (Exception e) {
//                System.out.println("数据库关闭失败");
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close(); // 数据库关闭
//                System.out.println("\033[34;1m"+"关闭成功"+ "\033[0m");
			} catch (Exception e) {
				System.out.println("数据库关闭失败");
				e.printStackTrace();
			}
		}
	}

	public static void closeConnection(PreparedStatement psmt) { // 关闭数据库
		if (psmt != null) {
			try {
				psmt.close(); // 数据库关闭
//                System.out.println("\033[34;1m"+"关闭成功"+ "\033[0m");
			} catch (Exception e) {
//                System.out.println("数据库关闭失败");
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close(); // 数据库关闭
//                System.out.println("\033[34;1m"+"关闭成功"+ "\033[0m");
			} catch (Exception e) {
				System.out.println("数据库关闭失败");
				e.printStackTrace();
			}
		}
	}

	public static void closeConnection(ResultSet rs) { // 关闭数据库
		if (rs != null) {
			try {
				rs.close(); // 数据库关闭
//                System.out.println("\033[34;1m"+"关闭成功"+ "\033[0m");
			} catch (Exception e) {
//                System.out.println("数据库关闭失败");
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close(); // 数据库关闭
//                System.out.println("\033[34;1m"+"关闭成功"+ "\033[0m");
			} catch (Exception e) {
				System.out.println("数据库关闭失败");
				e.printStackTrace();
			}
		}
	}

	public static void closeConnection(PreparedStatement psmt, ResultSet rs) { // 关闭数据库
		if (psmt != null) {
			try {
				psmt.close(); // 数据库关闭
//                System.out.println("\033[34;1m"+"关闭成功"+ "\033[0m");
			} catch (Exception e) {
//                System.out.println("数据库关闭失败");
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close(); // 数据库关闭
//                System.out.println("\033[34;1m"+"关闭成功"+ "\033[0m");
			} catch (Exception e) {
//                System.out.println("数据库关闭失败");
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close(); // 数据库关闭
//                System.out.println("\033[34;1m"+"关闭成功"+ "\033[0m");
			} catch (Exception e) {
				System.out.println("数据库关闭失败");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ConnectionPool.getConnection();
		ConnectionPool.closeConnection();
	}
}
