package cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Resource;
import cn.util.DBUtil;

public class ResourceDao {
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
		public Integer addResource(Resource r) {
			conn = dbUtil.getConnection();
			String sql = "insert into tb_Resource (resoName,addTime,resource,itemName) values (?,?,?,?)";
			System.out.println(sql);
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, r.getResoName());
				ps.setString(2, r.getAddTime());
				ps.setString(3, r.getResource());
				ps.setString(4, r.getItemName());
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
		public Integer deleteResource(Resource r) {
			conn = dbUtil.getConnection();
			String sql = "delete from tb_Resource where id = " + r.getId();
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
		public Integer updateResource(Resource r) {
			conn = dbUtil.getConnection();

			String sql = "update tb_resource set resoName ='" + r.getResoName() + "',resource = '" + r.getResource() + "', ItemName = '"
					+ r.getItemName() + "' where id =" + r.getId();
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
		public Resource selectResourceByresoName(String resoName) {
			conn = dbUtil.getConnection();
			String sql = "select * from tb_resource where resoName = " + resoName;
			System.out.println(sql);
			Resource r = new Resource();
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					r.setId(rs.getInt(1));
					r.setItemName(rs.getString(2));
					r.setResource(rs.getString(3));
					r.setAddTime(rs.getString(4));
					r.setResoName(rs.getString(5));
					r.setNote(rs.getString(6));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbUtil.close();
			}
			return r;
		}

		/*
		 * 
		 * 查找所有项目
		 */
		public List<Resource> getall() {
			conn = dbUtil.getConnection();
			List<Resource> list = new ArrayList<>();
			String sql = "select * from tb_resource";
			Resource r = new Resource();
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					r.setId(rs.getInt(1));
					r.setItemName(rs.getString(2));
					r.setResource(rs.getString(3));
					r.setAddTime(rs.getString(4));
					r.setResoName(rs.getString(5));
					r.setNote(rs.getString(6));

					list.add(r);
					// System.out.println(resource);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbUtil.close();
			}
			return list;
		}

}
