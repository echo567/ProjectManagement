package cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Plan;
import cn.util.DBUtil;

public class PlanDao {
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
		public Integer addPlan(Plan p) {
			conn = dbUtil.getConnection();
			String sql = "insert into tb_plan (itemName,planTime,planDescribe,percent) values (?,?,?,?)";
			System.out.println(sql);
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1,p.getItemName());
				ps.setString(2, p.getPlanTime());
				ps.setString(3, p.getPlanDescribe());
				ps.setString(4, p.getPercent());
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
		public Integer deletePlan(Plan p) {
			conn = dbUtil.getConnection();
			String sql = "delete from tb_plan where id = " + p.getId();
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
		public Integer updateplan(Plan p) {
			conn = dbUtil.getConnection();

			String sql = "update tb_plan set itemName = '" +p.getItemName() +"', planTime ='" + p.getPlanTime() + "',planDescribe = '" + p.getPlanDescribe()
			+ "' where id =" + p.getId();
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
		public Plan selectPlanByPlanTime(String planTime) {
			conn = dbUtil.getConnection();
			String sql = "select * from tb_plan where planTime = " + planTime;
			System.out.println(sql);
			Plan p = new Plan();
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					p.setId(rs.getInt(1));
					p.setItemName(rs.getString(2));
					p.setPlanTime(rs.getString(3));
					p.setPlanDescribe(rs.getString(4));
					p.setPercent(rs.getString(5));
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
		public List<Plan> getall() {
			conn = dbUtil.getConnection();
			List<Plan> list = new ArrayList<>();
			String sql = "select * from tb_plan";
			Plan p = new Plan();
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					p.setId(rs.getInt(1));
					p.setItemName(rs.getString(2));
					p.setPlanTime(rs.getString(3));
					p.setPlanDescribe(rs.getString(4));
					p.setPercent(rs.getString(5));
					p.setNote(rs.getString(6));

					list.add(p);
					// System.out.println(Percent);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbUtil.close();
			}
			return list;
		}

}
