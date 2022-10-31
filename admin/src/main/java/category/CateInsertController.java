package category;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basesetting.Time;
public class CateInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CateInsertController() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		String code = request.getParameter("code");
		String menucode_big = request.getParameter("bcode");
		String menuname_big = request.getParameter("bmenu");
		String menucode_small = request.getParameter("scode");
		String menuname_small = request.getParameter("smenu");
		String usecate = request.getParameter("usecate");
		
		if(menucode_small == null && menuname_small == null) {
			menucode_small="";
			menuname_small="";
		}
		
		Time time = new Time();
		String indate = time.now_datetime();
		
		ArrayList<String> data = new ArrayList<String>();
		data.add(code);
		data.add(menucode_big);
		data.add(menuname_big);
		data.add(menucode_small);
		data.add(menuname_small);
		data.add(usecate);
		data.add(indate);
		
		CateInsertModel cin = new CateInsertModel();
		cin.insert(data);
		
		String result = cin.result().intern();
		
		if(result=="ok") {
			pw.print("<script>alert('카테고리 등록이 완료 되었습니다.'); location.href='./admin_category_write.jsp';</script>");
		}else {
			pw.print("<script>alert('카테고리 등록에 실패 하였습니다. 분류코드를 확인하세요.'); history.go(-1);</script>");
		}
		
		
	}

}
