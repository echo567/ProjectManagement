package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bean.User;
import cn.dao.UserDao;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private UserDao userDao = new UserDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");
		System.out.println(op);
		if ("toLogin".equals(op)) {
			toLogin(request, response);
		} else if ("toRegister".equals(op)) {
			toRegister(request, response);
		} else if ("toUpdate".equals(op)) {
			toUpdate(request, response);
		} else if ("logout".equals(op)) {
			logout(request, response);
		} else {
			PrintWriter pw = response.getWriter();
			pw.println("参数不正确，请检查后重新请求");
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			session.invalidate();

			response.sendRedirect("login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void toUpdate(HttpServletRequest request, HttpServletResponse response) {
		try {
			Integer userId = Integer.parseInt(request.getParameter("userId"));
			User userDatabase = userDao.selectUserById(userId);
			String userName = request.getParameter("userName");
			String userPassword = request.getParameter("userPassword");

			if (userName != null) {
				userDatabase.setUserName(userName);
			}
			if (userPassword != "") {
				userDatabase.setPassword(userPassword);
			}

			if (userDao.updateUserById(userDatabase) > 0) {
				HttpSession session = request.getSession();
				session.setAttribute("user", userDatabase);
				request.setAttribute("msg", "修改个人资料成功");
			} else {
				request.setAttribute("msg", "修改个人资料失败");
			}

			request.getRequestDispatcher("/user/userUpdate.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void toRegister(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		try {
			User user1 = userDao.selectUserByName(name);
			if (user1.getUserId() != null) {
				System.out.println("用户名已存在");
				request.setAttribute("msg", "用户名已存在，请更换用户名重新注册");
				request.getRequestDispatcher("register.jsp").forward(request, response);
				return;

			}
			User user = new User(name, password);
			userDao.addUser(user);
			request.setAttribute("msg", "注册成功");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void toLogin(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		try {

			User user = userDao.selectUserByName(name);
			if (user.getUserName() == null) {
				request.setAttribute("msg", "用户不存在");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			} else if (!(password).equals(user.getPassword())) {
				request.setAttribute("msg", "密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				// request.setAttribute("user", user);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
