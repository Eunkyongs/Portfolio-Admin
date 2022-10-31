package category;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CateDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CateDeleteController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
	
		String ck[] = request.getParameterValues("cate_ck"); // 체크된 체크박스의 no값

		CateDeleteModel del= new CateDeleteModel();
		del.del(ck);
		
		String result=del.result_del().intern();
		
		if(result=="ok") {
			pw.print("<script>alert('삭제완료'); location.href='category?page=1&search_select=&search_cate=';</script>");
		}else {
			pw.print("<script>alert('삭제할 카테고리를 체크해 주세요.'); history.go(-1);</script>");
		}
	}

}
