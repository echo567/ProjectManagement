package cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.Project;
import cn.dao.ProjectDao;

/**
 * Servlet implementation class ProjectServlet
 */
@WebServlet("/projectServlet")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProjectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private ProjectDao projectDao = new ProjectDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");
		System.out.println(op);

		if ("toAdd".equals(op)) {
			System.out.println("增加项目");
			toAdd(request, response);
		} else if ("toList".equals(op)) {
			System.out.println("查看所有项目");
			toList(request, response);
		} else if ("toUpdate".equals(op)) {
			System.out.println("修改项目信息");
			toUpdate(request, response);
			System.out.println();
		} else if ("toDelete".equals(op)) {
			toDelete(request, response);
		} else if ("toUpdatePage".equals(op)) {
			toUpdatePage(request, response);
		} else if ("toSelect".equals(op)) {
			toSelect(request, response);
		}

	}

	private void toSelect(HttpServletRequest request, HttpServletResponse response) {
		try {
		String name = request.getParameter("name");
		Project p = projectDao.selectProjectByname(name);
		if (p.getId() != null) {
			request.setAttribute("p", p);
		} else {
			request.setAttribute("msg", "不存在此名称的项目");
		}
		
			request.getRequestDispatcher("/project/projectSelect.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void toDelete(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		if (projectDao.deleteProject(id) > 0) {
			request.setAttribute("msg", "删除项目成功");

		} else {
			request.setAttribute("msg", "修改项目成功");
		}
		toList(request, response);
	}

	private void toUpdatePage(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			Project p = projectDao.selectProjectById(id);
			request.setAttribute("p", p);

			request.getRequestDispatcher("/project/projectUpdate.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void toUpdate(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name").trim();
		String startTime = request.getParameter("startTime").trim();
		String user = request.getParameter("user").trim();
		String introduction = request.getParameter("introduction").trim();
		Project p = new Project(id, name, startTime, user, introduction);
		if (projectDao.updateProject(p) > 0) {
			request.setAttribute("msg", "修改项目成功");
		} else {
			request.setAttribute("msg", "修改项目成功");
		}
		toUpdatePage(request, response);
	}

	private void toList(HttpServletRequest request, HttpServletResponse response) {

		try {
			List<Project> list = projectDao.getall();
			System.out.println(list);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/project/projectList.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void toAdd(HttpServletRequest request, HttpServletResponse response) {
		try {
			String name = request.getParameter("name").trim();
			String startTime = request.getParameter("startTime").trim();
			String user = request.getParameter("user").trim();
			String introduction = request.getParameter("introduction").trim();
			System.out.println(name + " " + startTime + " " + user + " " + introduction);
			if (name == null) {
				System.out.println("项目增加失败");
				request.setAttribute("msg", "项目增加失败");
				request.getRequestDispatcher("/project/projectAdd.jsp").forward(request, response);
				return;
			}
			Project p = new Project(name, startTime, user, introduction);
			System.out.println("项目增加成功");
			int result = projectDao.addProject(p);
			if (result > 0) {
				request.setAttribute("msg", "项目增加成功");
			} else {
				request.setAttribute("msg", "项目增加失败");
			}

			request.getRequestDispatcher("/project/projectAdd.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
