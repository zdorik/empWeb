package servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import entity.Employee;
import entity.ParkingSpace;
import entity.Project;

import session.EmpService;
import session.ProjService;


public class AssignEmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB ProjService projectBean;
	@EJB EmpService empBean;
	@Resource UserTransaction tx;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		try {
			tx.begin();
			int empId = Integer.valueOf(request.getParameter("employee")); 
			HttpSession session = request.getSession();
			int projectId = Integer.valueOf(session.getAttribute("projectid.edit").toString());
			projectBean.assignEmployeeProject(projectId, empId);
			response.sendRedirect("listProjects");
		} catch (NotSupportedException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} finally {
			try {
				tx.commit();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (RollbackException e) {
				e.printStackTrace();
			} catch (HeuristicMixedException e) {
				e.printStackTrace();
			} catch (HeuristicRollbackException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
	}
}
