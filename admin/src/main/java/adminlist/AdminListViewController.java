package adminlist;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminListViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdminListViewController() {
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
    		AdminListModel ld = new AdminListModel();
    		ld.adminlist();
    		ArrayList<AdminListModel> list = ld.adminlist();
    		req.setAttribute("list", list);
    		RequestDispatcher rd = req.getRequestDispatcher("./admin_main.jsp");
    		rd.forward(req, resp);
    		
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
