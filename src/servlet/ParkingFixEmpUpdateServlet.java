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
import entity.ParkingSpace;

import session.EmpService;
import session.ParkingService;

public class ParkingFixEmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB EmpService empBean;
	@EJB ParkingService parkingBean;	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int empId = Integer.valueOf(request.getParameter("employee")); 
		HttpSession session = request.getSession();
		ParkingSpace ps = (ParkingSpace)session.getAttribute("parkingspace.edit");
		Employee emp = empBean.findById(empId);
		ps.setEmployee(emp);
		parkingBean.updateParkingSpace(ps);
		response.sendRedirect("listParkingSpaces");
	}
}
