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
import session.ProjService;

public class ProjServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB ProjService projBean;
	@Resource UserTransaction tx;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			tx.begin();
			List<Project> projects = projBean.findAll();
			request.setAttribute("projects", projects);
			getServletContext().getRequestDispatcher("/listProjects.jsp").forward(request, response);
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
