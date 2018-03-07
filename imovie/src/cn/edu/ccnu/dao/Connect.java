package cn.edu.ccnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Connect {
	/*
	 * 轻度封装jdbc的数据库操作
	 * 
	 * 使用PrepareStatement处理，防止注入攻击
	 */

	private static final String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;DatabaseName=db_imovie";
	//private static final String url = "jdbc:sqlserver://localhost:1433;DatabaseName=master";
	private static String user = "sa";
	private static String password = "root";

	private static Connection conn;
	private static PreparedStatement pstmt;

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(url, user, password);
	}

	/**
	 * executeQuery
	 * 
	 * @param sql
	 * @param params
	 * @return ResultSet
	 */
	public static ResultSet executeQuery(String sql, List<Object> params)
			throws SQLException {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		if (params != null && !params.isEmpty()) {
			for (int i = 0, index = 1; i < params.size(); i++) {
				pstmt.setObject(index++, params.get(i));
			}
		}
		return pstmt.executeQuery();
	}

	/**
	 * updateByPreparedStatement
	 * 
	 * @param sql
	 * @param params
	 * @return ResultSet
	 */
	public static int updateByPreparedStatement(String sql, List<Object> params)
			throws SQLException {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		if (params != null && !params.isEmpty()) {
			for (int i = 0, index = 1; i < params.size(); i++) {
				pstmt.setObject(index++, params.get(i));
			}
		}
		return pstmt.executeUpdate();
	}

	public static void close() {

		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
