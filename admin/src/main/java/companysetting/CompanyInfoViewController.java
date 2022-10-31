package companysetting;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class CompanyInfoViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CompanyInfoViewController() {
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	resp.setContentType("text/html; charset=utf-8");
    	try {
				CompanyInfoSelectModel sl = new CompanyInfoSelectModel();
				CompanyInfoSelectModel sl2 = sl.getter();
				req.setAttribute("home_title", sl2.home_title);
				req.setAttribute("mail",sl2.mail);
				req.setAttribute("usepoint", sl2.usepoint);
				req.setAttribute("join_point", sl2.join_point);
				req.setAttribute("join_level", sl2.join_level);
				req.setAttribute("company", sl2.company);
				req.setAttribute("bn", sl2.bn);
				req.setAttribute("ceo", sl2.ceo);
				req.setAttribute("tel", sl2.tel);
				req.setAttribute("mos", sl2.mos);
				req.setAttribute("vacc", sl2.vacc);
				req.setAttribute("zip", sl2.zip);
				req.setAttribute("address", sl2.address);
				req.setAttribute("infomanager", sl2.infomanager);
				req.setAttribute("infomail", sl2.infomail);
				req.setAttribute("bank_name", sl2.bank_name);
				req.setAttribute("bank_account", sl2.bank_account);
				req.setAttribute("creditcard", sl2.creditcard);
				req.setAttribute("cellphone", sl2.cellphone);
				req.setAttribute("giftcard", sl2.giftcard);
				req.setAttribute("minpoint", sl2.minpoint);
				req.setAttribute("maxpoint", sl2.maxpoint);
				req.setAttribute("cashreceipt", sl2.cashreceipt);
				req.setAttribute("shipping_company", sl2.shipping_company);
				req.setAttribute("shipping_cost", sl2.shipping_cost);
				req.setAttribute("shipping_date", sl2.shipping_date);
		   		RequestDispatcher rd2 = req.getRequestDispatcher("admin_config.jsp");
		   		rd2.forward(req, resp);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		try {
    		}catch(Exception e) {
    		}
    	}
    }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
