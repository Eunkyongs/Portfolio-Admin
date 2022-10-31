package category;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CateListViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CateListViewController() {
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			CateSelectModel cs = new CateSelectModel();
			String pgno = req.getParameter("page");
			String search_select = req.getParameter("search_select");
			String search_cate= req.getParameter("search_cate");
			ArrayList<CateSelectModel> catelist = cs.catelist(pgno, search_select, search_cate);
			req.setAttribute("catelist", catelist);
		 	req.setAttribute("ct", cs.tot);
	    	req.setAttribute("pageview", cs.pageview);
			RequestDispatcher rd = req.getRequestDispatcher("admin_category.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
