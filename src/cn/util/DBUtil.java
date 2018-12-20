package cn.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 * 军辉  2018年12月19日上午9:05:11
 */
public class DBUtil {
	// 建立连接
	private static Connection conn;

	// 将参数化的sql语句发送到数据库(可执行动态语句)
	private static PreparedStatement ps;

	// 执行sql语句后，此对象接收返回的单个结果
	private static ResultSet rs;

	/*
	 * 获取数据库连接
	 */
	public Connection getConnection() {

		InputStream in = getClass().getClassLoader().getResourceAsStream("mysql.properties");
		Properties properties = new Properties();
		try {
			properties.load(in);
			in.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String name = properties.getProperty("name");
		String password = properties.getProperty("password");
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, name, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}
public static void main(String[] args) {
	DBUtil dbutil=new DBUtil();
	System.out.println(dbutil.getConnection());
}
	public static void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
