package cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Project;
import cn.bean.User;
import cn.util.DBUtil;

/*
 * 军辉  2018年12月19日下午3:34:18
 */
public class ProjectDao {
	// 数据库连接
	private Connection conn;

	// 将参数化的sql语句发送到数据库(可执行动态语句)
	private static PreparedStatement ps;

	// 执行sql语句后，此对象接收返回的单个结果
	private static ResultSet rs;

	// 记录数（此次数据库操作改变的行数）
	private Integer record;

	private DBUtil dbUtil = new DBUtil();

	/*
	 * 增加项目
	 */
	public Integer addProject(Project p) {
		conn = dbUtil.getConnection();
		String sql = "insert into tb_project (name,startTime,user,introduction) values (?,?,?,?)";
		System.out.println(sql);
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getStartTime());
			ps.setString(3, p.getUser());
			ps.setString(4, p.getIntroduction());
			record = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close();
		}
		return record;
	}

	/*
	 * 删除项目
	 */
	public Integer deleteProject(Project p) {
		conn = dbUtil.getConnection();
		String sql = "delete from tb_project where id = " + p.getId();
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
	 * 
	 * 
	 */
	public Integer updateProject(Project p) {
		conn = dbUtil.getConnection();

		String sql = "update tb_project set name ='" + p.getName() + "',user = '" + p.getUser() + "', introduction = '"
				+ p.getIntroduction() + "' where id =" + p.getId();
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
	 * 查找项目
	 */
	public Project selectProjectByname(String name) {
		conn = dbUtil.getConnection();
		String sql = "select * from tb_project where name = " + name;
		System.out.println(sql);
		Project p = new Project();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setStartTime(rs.getString(3));
				p.setUser(rs.getString(4));
				p.setIntroduction(rs.getString(5));
				p.setNote(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close();
		}
		return p;
	}

	/*
	 * 
	 * 查找所有项目
	 */
	public List<Project> getall() {
		conn = dbUtil.getConnection();
		List<Project> list = new ArrayList<>();
		String sql = "select * from tb_project";
		Project p = new Project();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setStartTime(rs.getString(3));
				p.setUser(rs.getString(4));
				p.setIntroduction(rs.getString(5));
				p.setNote(rs.getString(6));

				list.add(p);
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
