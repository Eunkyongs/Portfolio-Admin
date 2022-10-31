package notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoticeListViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NoticeListViewController() {
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
    		String pgno = req.getParameter("page");
    		NoticeSelectModel ns = new NoticeSelectModel();
    		ArrayList<NoticeSelectModel> noticelist = ns.noticelist(pgno);
    		req.setAttribute("no_list", noticelist);
    		req.setAttribute("ct", ns.tot);
    		req.setAttribute("pageview", ns.pageview);
    		RequestDispatcher rd = req.getRequestDispatcher("admin_notice.jsp");
    		rd.forward(req, resp);
    		
    	}catch(Exception e) {
    	}
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
