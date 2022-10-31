package companysetting;
import java.util.*;

import basesetting.DBConnect;

import java.sql.*;
public class CompanyInfoSelectModel {
	String home_title;
	String mail;
	String usepoint;
	String join_point;
	String join_level;
	
	String company;
	String bn;
	String ceo;
	String tel;
	String mos;
	String vacc;
	String zip;
	String address;
	String infomanager;
	String infomail;
	
	String bank_name;
	String bank_account;
	String creditcard;
	String cellphone;
	String giftcard;
	String minpoint;
	String maxpoint;
	String cashreceipt;
	String shipping_company;
	String shipping_cost;
	String shipping_date;
	
	public String getHome_title() {
		return home_title;
	}
	public void setHome_title(String home_title) {
		this.home_title = home_title;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getUsepoint() {
		return usepoint;
	}
	public void setUsepoint(String usepoint) {
		this.usepoint = usepoint;
	}
	public String getJoin_point() {
		return join_point;
	}
	public void setJoin_point(String join_point) {
		this.join_point = join_point;
	}
	public String getJoin_level() {
		return join_level;
	}
	public void setJoin_level(String join_level) {
		this.join_level = join_level;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBn() {
		return bn;
	}
	public void setBn(String bn) {
		this.bn = bn;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMos() {
		return mos;
	}
	public void setMos(String mos) {
		this.mos = mos;
	}
	public String getVacc() {
		return vacc;
	}
	public void setVacc(String vacc) {
		this.vacc = vacc;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInfomanager() {
		return infomanager;
	}
	public void setInfomanager(String infomanager) {
		this.infomanager = infomanager;
	}
	public String getInfomail() {
		return infomail;
	}
	public void setInfomail(String infomail) {
		this.infomail = infomail;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_account() {
		return bank_account;
	}
	public void setBank_account(String bank_account) {
		this.bank_account = bank_account;
	}
	public String getCreditcard() {
		return creditcard;
	}
	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getGiftcard() {
		return giftcard;
	}
	public void setGiftcard(String giftcard) {
		this.giftcard = giftcard;
	}
	public String getMinpoint() {
		return minpoint;
	}
	public void setMinpoint(String minpoint) {
		this.minpoint = minpoint;
	}
	public String getMaxpoint() {
		return maxpoint;
	}
	public void setMaxpoint(String maxpoint) {
		this.maxpoint = maxpoint;
	}
	public String getCashreceipt() {
		return cashreceipt;
	}
	public void setCashreceipt(String cashreceipt) {
		this.cashreceipt = cashreceipt;
	}
	public String getShipping_company() {
		return shipping_company;
	}
	public void setShipping_company(String shipping_company) {
		this.shipping_company = shipping_company;
	}
	public String getShipping_cost() {
		return shipping_cost;
	}
	public void setShipping_cost(String shipping_cost) {
		this.shipping_cost = shipping_cost;
	}
	public String getShipping_date() {
		return shipping_date;
	}
	public void setShipping_date(String shipping_date) {
		this.shipping_date = shipping_date;
	}
	
	public CompanyInfoSelectModel getter() {
		CompanyInfoSelectModel sl = null;
		Connection con = null; 
		try {
			DBConnect db = new DBConnect();
			con = db.cafe24();
			String sql = "select * from set_join, set_info, set_pay order by set_join.no desc, set_info.no desc, set_pay.no desc limit 1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				sl = new CompanyInfoSelectModel();
				sl.setHome_title(rs.getString("home_title"));
				sl.setMail(rs.getString("mail"));
				sl.setUsepoint(rs.getString("usepoint"));
				sl.setJoin_point(rs.getString("join_point"));
				sl.setJoin_level(rs.getString("join_level"));
				
				sl.setCompany(rs.getString("company"));
				sl.setBn(rs.getString("bn"));
				sl.setCeo(rs.getString("ceo"));
				sl.setTel(rs.getString("tel"));
				sl.setMos(rs.getString("mos"));
				sl.setVacc(rs.getString("vacc"));
				sl.setZip(rs.getString("zip"));
				sl.setAddress(rs.getString("address"));
				sl.setInfomanager(rs.getString("infomanager"));
				sl.setInfomail(rs.getString("infomail"));
				
				sl.setBank_name(rs.getString("bank_name"));
				sl.setBank_account(rs.getString("bank_account"));
				sl.setCreditcard(rs.getString("creditcard"));
				sl.setCellphone(rs.getString("cellphone"));
				sl.setGiftcard(rs.getString("giftcard"));
				sl.setMinpoint(rs.getString("minpoint"));
				sl.setMaxpoint(rs.getString("maxpoint"));
				sl.setCashreceipt(rs.getString("cashreceipt"));
				sl.setShipping_company(rs.getString("shipping_company"));
				sl.setShipping_cost(rs.getString("shipping_cost"));
				sl.setShipping_date(rs.getString("shipping_date"));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				con.close();
			}catch(Exception e) {
			}
		}
		return sl;
	}
}
