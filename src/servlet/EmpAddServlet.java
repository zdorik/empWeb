package servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Department;
import entity.Employee;
import session.DeptService;
import session.EmpService;


public class EmpAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB EmpService empBean;
	@EJB DeptService deptBean;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		List<Department> departments = deptBean.findAll();
		request.setAttribute("departments", departments);
		getServletContext().getRequestDispatcher("/addEmployee.jsp").forward(request, response);
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long salary = Long.parseLong(request.getParameter("salary"));
		String name = request.getParameter("name");
		int deptId = Integer.valueOf(request.getParameter("department")); 
		Employee emp = new Employee();
		Department dept = deptBean.findById(deptId);
		emp.setName(name);
		emp.setSalary(salary);
		emp.setDepartment(dept);
		empBean.addEmployee(emp);
		response.sendRedirect("listEmployees");
	}
}
