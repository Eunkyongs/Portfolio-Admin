package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import basesetting.DBConnect;

public class ProductSelectModel {
	String no = null;
	String productcode = null;
	String img = null;
	String productname=null;
	String cate = null;
	String cost = null;
	String discountcost = null;
	String discountrate = null;
	String stock = null;
	String sales= null;
	String soldout = null;
	int tot=0;
	int pageview = 0;

	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getProductcode() {
		return productcode;
	}
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getDiscountcost() {
		return discountcost;
	}
	public void setDiscountcost(String discountcost) {
		this.discountcost = discountcost;
	}
	public String getDiscountrate() {
		return discountrate;
	}
	public void setDiscountrate(String discountrate) {
		this.discountrate = discountrate;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getSales() {
		return sales;
	}
	public void setSales(String sales) {
		this.sales = sales;
	}
	public String getSoldout() {
		return soldout;
	}
	public void setSoldout(String soldout) {
		this.soldout = soldout;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public int getPageview() {
		return pageview;
	}
	public void setPageview(int pageview) {
		this.pageview = pageview;
	}
	
	public ArrayList<ProductSelectModel> productlist(String pgno, String search_select, String search_p){
		int pageview = 10; // 한페이지당 보여지는 데이터 개수
		setPageview(pageview);
		int startpage = 0; //시작 페이지 값
		double pagenumber = 1; //페이징 개수
		String pno = pgno;
		String ct = null;
		int total = 0;
		PreparedStatement psct = null;
		PreparedStatement ps = null;
		
		ArrayList<ProductSelectModel> list = new ArrayList<>();
		DBConnect db = new DBConnect();
		Connection con = null;
		try {
			con = db.cafe24();
			
			// 데이터의 총 개수 확인
			if(search_select.equals("p_name")) { //상품명
				ct="select count(*) as ct from product where p_name like '%"+search_p+"%'";
				psct=con.prepareStatement(ct);
			}else if(search_select.equals("p_code")) { //상품코드
				ct="select count(*) as ct from product where b_code like '%"+search_p+"%' or s_code like '%"+search_p+"%' or p_code like '%"+search_p+"%'";
				psct=con.prepareStatement(ct);
			}else { //전체
				ct = "select count(*) as ct from product"; 
				psct=con.prepareStatement(ct);
			}
			ResultSet rsct = psct.executeQuery();
			
			while(rsct.next()){
			total = rsct.getInt("ct");
			}
			
			setTot(total);
			
			if(pno==null || pno == ""){
				startpage = 0;
			}else{//페이지 2번부터 적용되는 사항
				startpage = (Integer.parseInt(pno)-1)*pageview;
			}
			
			//페이징 총 개수 파악
			if(total % pageview == 0){
				pagenumber=total/pageview;
			}else{
				pagenumber=(total/pageview)+1;
			}
			
			String sql = null;
			
			//검색	
			if(search_select.equals("p_name")) {//상품명
				sql="select * from product join category on product.b_code = category.b_code where p_name like '%"+search_p+"%' group by pidx order by pidx desc limit "+startpage+","+pageview;
				ps = con.prepareStatement(sql);
			}else if(search_select.equals("p_code")) { //상품코드
				sql="select * from product join category on product.b_code = category.b_code where product.b_code like '%"+search_p+"%' or product.s_code like '%"+search_p+"%' or p_code like '%"+search_p+"%' group by pidx order by pidx desc limit "+startpage+","+pageview;
				ps = con.prepareStatement(sql);
			}else { //전체
				sql = "select * from category join product on product.b_code = category.b_code group by pidx order by pidx desc limit "+startpage+","+pageview;
				ps = con.prepareStatement(sql);
			}
			ResultSet rs = ps.executeQuery();
			DecimalFormat df = new DecimalFormat("###,###");
			while(rs.next()) {
				ProductSelectModel sp = new ProductSelectModel();
				sp.setNo(rs.getString("pidx"));
				sp.setProductcode(rs.getString("p_code"));
				sp.setImg(rs.getString("p_img1"));
				sp.setProductname(rs.getString("p_name"));
				sp.setCate(rs.getString("b_name"));
				
				int costs1 = Integer.parseInt(rs.getString("p_money"));
				int costs2 = Integer.parseInt(rs.getString("p_salemoney"));
				String p_money = df.format(costs1);
				String p_salemoney = df.format(costs2);
				sp.setCost(p_money);
				sp.setDiscountcost(p_salemoney);
//				sp.setCost(rs.getString("p_money"));
//				sp.setDiscountcost(rs.getString("p_salemoney"));
				sp.setDiscountrate(rs.getString("p_sale"));
				sp.setStock(rs.getString("p_ea"));
				sp.setSales(rs.getString("p_use"));
				sp.setSoldout(rs.getString("p_sold"));
				list.add(sp);
			}
		}catch(Exception e) {
			
		}finally {
			try {
				con.close();
			}catch(Exception e) {
				
			}
		}
		
		return list;
	}
	

		
}
