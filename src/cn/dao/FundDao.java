package cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Fund;
import cn.util.DBUtil;

public class FundDao {

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
		public Integer addFund(Fund f) {
			conn = dbUtil.getConnection();
			String sql = "insert into tb_fund (fund,addTime,itemName) values (?,?,?)";
			System.out.println(sql);
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, f.getFund());
				ps.setString(2, f.getAddTime());
				ps.setString(3, f.getItemName());
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
		public Integer deleteFund(Fund f) {
			conn = dbUtil.getConnection();
			String sql = "delete from tb_fund where id = " + f.getId();
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
		 * 修改经费通过查询Id
		 * 
		 */
		public Integer updateFund(Fund f) {
			conn = dbUtil.getConnection();

			String sql = "update tb_fund set fund ='" + f.getFund() + "',addTime = '" + f.getAddTime() + "', itemName = '"
					+ f.getItemName() + "' where id =" + f.getId();
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
		 * 查找项目经费
		 */
		public Fund selectFundByItemName(String itemName) {
			conn = dbUtil.getConnection();
			String sql = "select * from tb_fund where itemName = " + itemName;
			System.out.println(sql);
			Fund f = new Fund();
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					f.setId(rs.getInt(1));
					f.setFund(rs.getString(2));
					f.setAddTime(rs.getString(3));
					f.setItemName(rs.getString(4));
					f.setNote(rs.getString(5));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbUtil.close();
			}
			return f;
		}

		/*
		 * 
		 * 查找所有项目
		 */
		public List<Fund> getall() {
			conn = dbUtil.getConnection();
			List<Fund> list = new ArrayList<>();
			String sql = "select * from tb_fund";
			Fund f = new Fund();
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					f.setId(rs.getInt(1));
					f.setFund(rs.getString(2));
					f.setAddTime(rs.getString(3));
					f.setItemName(rs.getString(4));
					f.setNote(rs.getString(5));
					

					list.add(f);
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