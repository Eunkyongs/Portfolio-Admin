package couponandpopup;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CouponPopupViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CouponPopupViewController() {
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	String pgno = req.getParameter("page");
    	CouponSelectModel cs = new CouponSelectModel();
    	ArrayList<CouponSelectModel> couponlist = cs.couponlist(pgno);
    	req.setAttribute("couponlist", couponlist);
    	req.setAttribute("ct", cs.tot);
    	req.setAttribute("pageview", cs.pageview);
    	RequestDispatcher rd = req.getRequestDispatcher("admin_shopping.jsp");
    	rd.forward(req, resp);
    
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
