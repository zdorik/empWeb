package servlet;

import java.io.IOException;
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


public class EmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@EJB EmpService empBean;
	@EJB DeptService deptBean;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		long salary = Long.parseLong(request.getParameter("salary"));
		String name = request.getParameter("name");
		int deptId = Integer.valueOf(request.getParameter("department")); 
		HttpSession session = request.getSession();
		Employee emp = (Employee)session.getAttribute("employee.edit");
		Department dept = deptBean.findById(deptId);
		emp.setName(name);
		emp.setSalary(salary);
		emp.setDepartment(dept);
		empBean.updateEmployee(emp);
		response.sendRedirect("listEmployees");
	}

}
