package cn.test;
/*
 * 军辉  2018年12月19日上午10:25:08
 */

import cn.bean.User;
import cn.dao.UserDao;

public class UserDaoTest {
	private UserDao userDao = new UserDao();

	public static void main(String[] args) {
		UserDaoTest userDaoTest = new UserDaoTest();
		/*
		 * User user = new User("123", "123"); userDaoTest.add(user);
		 * userDaoTest.finaAll();
		 */
		// userDaoTest.select();
		//userDaoTest.delete();
		userDaoTest.finaAll();
	}

	public void add(User user) {
		userDao.addUser(user);// 可用
	}

	public void finaAll() {
		System.out.println(userDao.getall());// 可用
	}

	public void update(User user) {
		userDao.updateUserById(user);
	}

	public void select() {
		User user = userDao.selectUserByName("123");// 可用
		System.out.println("修改之前的" + user);
		user.setPassword("111111111111111111");
		userDao.updateUserById(user);// 可用
		System.out.println("修改之后的" + user);

	}

	public void delete() {
		User user = userDao.selectUserByName("123");// 可用
		userDao.deleteUserById(user.getUserId());
	}

}
