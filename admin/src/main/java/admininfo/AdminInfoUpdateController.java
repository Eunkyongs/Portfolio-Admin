package admininfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminInfoUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdminInfoUpdateController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pr = response.getWriter();
		
		String id = request.getParameter("userid");
		String pass=request.getParameter("pw1");
		String name=request.getParameter("username");
		String email=request.getParameter("useremail");
		String tel1 =request.getParameter("tel1");
		String tel2 =request.getParameter("tel2");
		String tel3 =request.getParameter("tel3");
		String part =request.getParameter("part");
		String position = request.getParameter("duty");
		String tel = tel1+tel2+tel3;
		
		String[] data = {id,pass,name,email,tel,part,position};
		AdminInfoUpdateModel up  = new AdminInfoUpdateModel();
		String result = up.info_update(data);
		
		if(result == "ok" ) {
			pr.print("<script>alert('관리자 정보수정이 완료되었습니다.'); location.href='./admin_info.jsp';</script>");
		}
		else {
			pr.print("<script>alert('관리자 정보수정에 실패했습니다.'); history.go(-1);</script>");
		}
		
		
	}

	
}
