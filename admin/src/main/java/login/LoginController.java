package login;

import java.io.*;
import java.sql.*;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter prw = response.getWriter();
		String id = request.getParameter("aid");
		String pw = request.getParameter("apw");
		
		try {
			LoginModel lm = new LoginModel();
			String[] lm2 = lm.getter(id,pw);
			if(lm2[0].equals("no")) {
				prw.write("<script>alert('아이디와 패스워드를 다시한번 확인해 주세요.'); history.go(-1);</script>");
			}else if(lm2[3].equals("N")) {
				prw.write("<script>alert('미승인된 관리자 입니다. 승인 후 이용해 주세요.'); history.go(-1);</script>");
			}else {
				LoginAccessModel ac = new LoginAccessModel();
				ac.aa(id);
				String result=ac.getter();
				
				if(result =="ok") {
					HttpSession session = request.getSession();
					session.setAttribute("id", lm2[1]);
					session.setAttribute("name", lm2[2]);//name
					
					prw.print("<script>alert('로그인 하셨습니다.'); location.href='./adminlist';</script>");
				}else {
					throw new Exception("error");
				}
			}
			
		}catch(Exception e) {
			System.out.println(e);
			prw.write("<script>alert('DB연결오류.'); history.go(-1);</script>");
		}finally {
			try {
			}catch(Exception e) {
				
			}
		}
	}

}
