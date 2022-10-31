package couponandpopup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import basesetting.*;

public class CouponSelectModel {
	String no = null;
	String couponname = null;
	String couponcate = null;
	String startdate = null;
	String enddate = null;
	String coupontype = null;
	String discount = null;
	String mincost = null;
	int tot=0;
	int pageview = 0;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getCouponname() {
		return couponname;
	}
	public void setCouponname(String couponname) {
		this.couponname = couponname;
	}
	public String getCouponcate() {
		return couponcate;
	}
	public void setCouponcate(String couponcate) {
		this.couponcate = couponcate;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getCoupontype() {
		return coupontype;
	}
	public void setCoupontype(String coupontype) {
		this.coupontype = coupontype;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getMincost() {
		return mincost;
	}
	public void setMincost(String mincost) {
		this.mincost = mincost;
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

	
	public ArrayList<CouponSelectModel> couponlist(String pgno) {
		int pageview = 5; // 한페이지당 보여지는 데이터 개수
		setPageview(pageview);
		int startpage = 0; //시작 페이지 값
		double pagenumber = 1; //페이징 개수
		String pno = pgno;
		Time t = new Time();
		String now = t.now_datetime();
		String ct = "select count(*) as ct from coupon where enddate >='"+ now +"'"; // 데이터의 총 개수 확인
		int total = 0;
		PreparedStatement psct = null;
		PreparedStatement ps = null;
		
		ArrayList<CouponSelectModel> list = new ArrayList<>();
		Connection con = null;
		try {
			DBConnect db = new DBConnect();
			con = db.cafe24();
			
			psct=con.prepareStatement(ct);
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
			
			String sql = "select * from coupon where enddate >='"+ now +"' order by no desc limit "+startpage+","+pageview;
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			DecimalFormat df = new DecimalFormat("###,###");
			while(rs.next()) {
				CouponSelectModel cs = new CouponSelectModel();
				cs.setNo(rs.getString("no"));
				cs.setCouponname(rs.getString("couponname"));
				cs.setCouponcate(rs.getString("couponcate"));
				cs.setStartdate(rs.getString("startdate"));
				cs.setEnddate(rs.getString("enddate"));
				cs.setCoupontype(rs.getString("coupontype"));
				
				int costs1 = Integer.parseInt(rs.getString("discount"));
				int costs2 = Integer.parseInt(rs.getString("mincost"));
				String discount = df.format(costs1);
				String mincost = df.format(costs2);
				cs.setDiscount(discount);
				cs.setMincost(mincost);
				list.add(cs);
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
