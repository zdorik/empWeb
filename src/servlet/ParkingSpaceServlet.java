package servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.ParkingSpace;
import session.ParkingService;

public class ParkingSpaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB ParkingService parkingBean;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ParkingSpace> parkingSpaces = parkingBean.findAll();
		request.setAttribute("parkingSpaces", parkingSpaces);
		getServletContext().getRequestDispatcher("/listParkingSpaces.jsp").forward(request, response);
	}

}
