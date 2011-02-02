package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import session.EmpService;

public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB EmpService empBean;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("empId");
		empBean.deleteEmployee(Integer.valueOf(empId));
		response.sendRedirect("listEmployees");
	}

}
