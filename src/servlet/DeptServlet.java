package servlet;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import session.DeptService;
import entity.Department;


public class DeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB DeptService deptBean;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		List<Department> departments = deptBean.findAll();
		request.setAttribute("departments", departments);
		getServletContext().getRequestDispatcher("/listDepartments.jsp").forward(request, response);
	}	

}
