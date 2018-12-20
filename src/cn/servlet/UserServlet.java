package cn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

		String anction = request.getParameter("op");
		System.out.println(anction);
		if ("toLogin".equals(anction)) {
			toLogin(request, response);
		} else if ("toRegister".equals(anction)) {
			toRegister(request, response);
		}
	}

	private void toRegister(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		try {
			if (name == null || password == null) {
				request.setAttribute("msg", "姓名或密码不能为空");
				request.getRequestDispatcher("register.jsp").forward(request, response);
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
			if (name == null || password == null) {
				request.setAttribute("msg", "姓名或密码不能为空");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}

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
