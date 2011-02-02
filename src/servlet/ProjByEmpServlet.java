package servlet;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import entity.Project;
import session.EmpService;
import session.ProjService;

public class ProjByEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource UserTransaction tx;
	@EJB ProjService projBean;
	@EJB EmpService empBean;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.valueOf(request.getParameter("empId"));
		try {
			tx.begin();
			List<Project> projects = projBean.projectsByEmp(empId);
			request.setAttribute("projects", projects);
			request.setAttribute("employee", empBean.findById(empId));
			getServletContext().getRequestDispatcher("/projectsByEmp.jsp").forward(request, response);
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
