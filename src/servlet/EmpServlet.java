package servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Employee;

import session.EmpService;



public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB EmpService empBean;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		List<Employee> employees = empBean.findAll();
		request.setAttribute("employees", employees);
		getServletContext().getRequestDispatcher("/listEmployees.jsp").forward(request, response);
	}

}
