package product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductListViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ProductListViewController() {
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	ProductSelectModel ps = new ProductSelectModel();
    	String pgno = req.getParameter("page");
		String search_select = req.getParameter("search_select");
		String search_p= req.getParameter("search_p");
    	ArrayList<ProductSelectModel> productlist = ps.productlist(pgno, search_select, search_p);
		req.setAttribute("productlist", productlist);
	 	req.setAttribute("ct", ps.tot);
    	req.setAttribute("pageview", ps.pageview);
    	
    	RequestDispatcher rd = req.getRequestDispatcher("admin_product.jsp");
    	rd.forward(req, resp);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
