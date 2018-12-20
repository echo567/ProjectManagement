package cn.test;
/*
 * 军辉  2018年12月19日上午10:25:08
 */

import java.util.Date;

import cn.bean.Project;
import cn.bean.User;
import cn.dao.ProjectDao;
import cn.dao.UserDao;

public class ProjectDaoTest {
	private ProjectDao projectDao = new ProjectDao();

	public static void main(String[] args) {
		ProjectDaoTest test = new ProjectDaoTest();
		 test.add();
		// test.getall();
		// test.update();
//		test.delete();

	}

	public void add() {

		Project p = new Project(null, "name", "startTime", "user", "introduction", null);
		System.out.println(projectDao.addProject(p));
	}

	public void update() {
		Project p = projectDao.selectProjectByname("name");
		System.out.println("修改之前的" + p);
		// p.setId(2222);
		p.setName("1233221");
		p.setNote("note");
		System.out.println("修改之后的：" + p);
		projectDao.updateProject(p);
	}

	public void getall() {
		System.out.println(projectDao.getall());
	}

	public void delete() {
		Project p = projectDao.selectProjectByname("name");
		System.out.println(projectDao.deleteProject(p));
	}
}
