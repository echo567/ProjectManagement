package cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Result;
import cn.util.DBUtil;

public class ResultDao {
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
		public Integer addResult(Result r) {
			conn = dbUtil.getConnection();
			String sql = "insert into tb_result (resultName,resultTime,beginName,resultDescribe,resultAttachment) values (?,?,?,?,?)";
			System.out.println(sql);
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, r.getResultName());
				ps.setString(2, r.getResultTime());
				ps.setString(3, r.getBeginName());
				ps.setString(4, r.getResultDescribe());
				ps.setString(5, r.getResultAttachment());
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
		public Integer deleteResult(Result r) {
			conn = dbUtil.getConnection();
			String sql = "delete from tb_result where id = " + r.getId();
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
		public Integer updateResult(Result r) {
			conn = dbUtil.getConnection();

			String sql = "update tb_result set resultName ='" + r.getResultName() + "',beginName = '" + r.getBeginName() + "', resultDescribe = '"
					+ r.getResultDescribe() + "',resultAttachment = '" + r.getResultAttachment() + "' where id =" + r.getId();
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
		public Result selectResultByresultName(String resultName) {
			conn = dbUtil.getConnection();
			String sql = "select * from tb_result where resultName = " + resultName;
			System.out.println(sql);
			Result r = new Result();
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					r.setId(rs.getInt(1));
					r.setResultName(rs.getString(2));
					r.setResultDescribe(rs.getString(3));
					r.setResultTime(rs.getString(4));
					r.setResultAttachment(rs.getString(5));
					r.setBeginName(rs.getString(6));
	
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
		public List<Result> getall() {
			conn = dbUtil.getConnection();
			List<Result> list = new ArrayList<>();
			String sql = "select * from tb_result";
			Result r = new Result();
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					r.setId(rs.getInt(1));
					r.setResultName(rs.getString(2));
					r.setResultDescribe(rs.getString(3));
					r.setResultTime(rs.getString(4));
					r.setResultAttachment(rs.getString(5));
					r.setBeginName(rs.getString(6));

					list.add(r);
					// System.out.println(beginName);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbUtil.close();
			}
			return list;
		}

}
