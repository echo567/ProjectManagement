package cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.User;

import cn.util.DBUtil;

public class UserDao {
	// 数据库连接
	private Connection conn;

	// 将参数化的sql语句发送到数据库(可执行动态语句)
	private static PreparedStatement ps;

	// 执行sql语句后，此对象接收返回的单个结果
	private static ResultSet rs;

	// 记录数（此次数据库操作改变的行数）
	private Integer record;

	private DBUtil dbUtil = new DBUtil();

	public Integer addUser(User user) {
		conn = dbUtil.getConnection();
		String sql = "insert into t_user(userName,userPassword) values (?,?)";
		System.out.println(sql);
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			record = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close();
		}
		return record;
	}

	/*
	 * (根据id删除用户)
	 * 
	 */
	public Integer deleteUserById(Integer id) {
		conn = dbUtil.getConnection();
		String sql = "delete from t_user where userId = " + id;
		System.out.println(sql);
		try {
			ps = conn.prepareStatement(sql);
			record = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close();
		}
		return record;
	}

	/*
	 * (根据id更新用户资料)
	 * 
	 */

	public Integer updateUserById(User user) {
		conn = dbUtil.getConnection();

		String sql = "update t_user set userName ='" + user.getUserName() + "',userPassword = '" + user.getPassword()
				+ "' where userId =" + user.getUserId();
		System.out.println(sql);
		try {
			ps = conn.prepareStatement(sql);
			record = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close();
		}
		return record;
	}

	/*
	 * (根据id查找用户)
	 * 
	 */
	public User selectUserById(Integer id) {
		conn = dbUtil.getConnection();
		String sql = "select * from t_user where id = " + id;
		System.out.println(sql);
		User user = new User();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close();
		}
		return user;
	}

	/*
	 * (根据name查找用户)
	 * 
	 */
	public User selectUserByName(String userName) {
		conn = dbUtil.getConnection();
		String sql = "select * from t_user where userName = '" + userName + "'";
		System.out.println(sql);
		User user = new User();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close();
		}
		return user;

	}

	/*
	 * (查找所有用户)
	 * 
	 */
	public List<User> getall() {
		conn = dbUtil.getConnection();
		List<User> list = new ArrayList<>();
		String sql = "select * from t_user";
		User user = new User();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);

				/* user = new User(id, name, password); */
				list.add(user);
				// System.out.println(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close();
		}
		return list;
	}
}
