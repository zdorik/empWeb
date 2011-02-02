package servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Employee;
import entity.ParkingSpace;
import entity.Project;

import session.EmpService;
import session.ProjService;

public class AssignEmpEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB ProjService projectBean;
	@EJB EmpService empBean;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int projectId = Integer.valueOf(request.getParameter("projectId"));
		Project project = projectBean.findById(projectId);
		HttpSession session = request.getSession();
		session.setAttribute("projectid.edit", projectId);
		request.setAttribute("project", project);
		List<Employee> employees = empBean.findEmpForProject(projectId);
		request.setAttribute("employees", employees);
		getServletContext().getRequestDispatcher("/assignEmployee.jsp").forward(request, response);
	}
}
