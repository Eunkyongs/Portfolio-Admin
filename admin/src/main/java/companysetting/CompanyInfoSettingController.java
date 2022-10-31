package companysetting;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basesetting.*;
public class CompanyInfoSettingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CompanyInfoSettingController() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		String home_title = request.getParameter("home_title");
		String mail = request.getParameter("mail");
		String usepoint = request.getParameter("usepoint");
		String join_point = request.getParameter("join_point");
		String join_level = request.getParameter("join_level");
		
		String company = request.getParameter("company");
		String bn = request.getParameter("bn");
		String ceo = request.getParameter("ceo");
		String tel = request.getParameter("tel");
		String mos = request.getParameter("mos");
		String vacc = request.getParameter("vacc");
		String zip = request.getParameter("zip");
		String address = request.getParameter("address");
		String infomanager = request.getParameter("infomanager");
		String infomail = request.getParameter("infomail");
		
		String bank_name = request.getParameter("bank_name");
		String bank_account = request.getParameter("bank_account");
		String creditcard = request.getParameter("creditcard");
		String cellphone = request.getParameter("cellphone");
		String giftcard = request.getParameter("giftcard");
		String minpoint = request.getParameter("minpoint");
		String maxpoint = request.getParameter("maxpoint");
		String cashreceipt = request.getParameter("cashreceipt");
		String shipping_company = request.getParameter("shipping_company");
		String shipping_cost = request.getParameter("shipping_cost");
		String shipping_date = request.getParameter("shipping_date");
		
		Time time = new Time();
		String indate = time.now_datetime();
		
		String []set_join = {home_title,mail,usepoint,join_point,join_level,indate};
		String []set_info = {company,bn,ceo,tel,mos,vacc,zip,address,infomanager,infomail,indate};
		String []set_pay = {bank_name, bank_account, creditcard, cellphone,giftcard,minpoint,maxpoint,cashreceipt,shipping_company,shipping_cost,shipping_date,indate};
		
		CompanyInfoInsertModel insert = new CompanyInfoInsertModel();
		insert.set_join_in(set_join);
		insert.set_info_in(set_info);
		insert.set_pay_in(set_pay);
		
		String []result=insert.re();
				
		if(result[0]=="ok" && result[1]=="ok" && result[2]=="ok") {
			pw.print("<script>alert('저장완료'); location.href='setting';</script>");
		}else {
			pw.print("<script>alert('저장실패'); history.go(-1);</script>");
		}
		
		
	}

}
