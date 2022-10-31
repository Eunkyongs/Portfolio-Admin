package reservation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class select2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public select2() {
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	resp.setContentType("text/html; charset=utf-8");
    	PrintWriter pw =resp.getWriter();

    	int n =0;
    	dbconfig dbc = null;
    	Connection c = null;
    	try {
    		dbc = new dbconfig();
    		c = dbc.getConnection();
    		String sql = "select * from reservation where rnm=? and rpw=? and rno=?";
    		
    		PreparedStatement ps = c.prepareStatement(sql);
    		ps.setString(1,"홍길동");
    		ps.setString(2, "a123456");
    		ps.setString(3, "123343");
    		
    		ResultSet rs = ps.executeQuery();
    		ArrayList<String> al = new ArrayList<String>(); 
    		while(rs.next()) {
    			
    			al.add(0,rs.getString("rnm"));
    			al.add(1,rs.getString("remail"));
    			al.add(2,rs.getString("rtel"));
    			/*
    			//배열에 추가하지않고 바로 세팅
    			req.setAttribute("rnm", rs.getString("rnm"));
    			req.setAttribute("remail", rs.getString("remail"));
    			req.setAttribute("rtel", rs.getString("rtel"));
    			*/
    		}
    		req.setAttribute("rnm", al.get(0));
    		req.setAttribute("remail", al.get(1));
    		req.setAttribute("rtel", al.get(2));
    		RequestDispatcher rd = req.getRequestDispatcher("./view.jsp");
    		rd.forward(req, resp);
    	}catch(Exception e){
    		
    	}
    
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
