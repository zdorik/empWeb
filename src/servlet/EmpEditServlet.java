package servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Department;
import entity.Employee;

import session.DeptService;
import session.EmpService;

public class EmpEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@EJB EmpService empBean;
	@EJB DeptService deptBean;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("empId");
		Employee emp = empBean.findById(Integer.valueOf(empId));
		HttpSession session = request.getSession();
		session.setAttribute("employee.edit", emp);
		request.setAttribute("employee", emp);
		List<Department> departments = deptBean.findAll();
		request.setAttribute("departments", departments);
		getServletContext().getRequestDispatcher("/editEmployee.jsp").forward(request, response);		
	}

}
