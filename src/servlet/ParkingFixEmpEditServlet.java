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
import session.EmpService;
import session.ParkingService;


public class ParkingFixEmpEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB EmpService empBean;
	@EJB ParkingService parkingBean;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parkingSpaceId = request.getParameter("parkingSpaceId");
		ParkingSpace ps = parkingBean.findById(Integer.valueOf(parkingSpaceId));
		HttpSession session = request.getSession();
		session.setAttribute("parkingspace.edit", ps);
		request.setAttribute("parkingspace", ps);
		List<Employee> employees = empBean.findEmpWithoutParking();
		request.setAttribute("employees", employees);
		getServletContext().getRequestDispatcher("/parkingFixPerEmployee.jsp").forward(request, response);
	}

}
