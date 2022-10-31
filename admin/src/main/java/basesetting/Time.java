package basesetting;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
	
	String now = null;
	
	public String now_datetime() {
		
		LocalDateTime ldt = LocalDateTime.now(); 
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		this.now = ldt.format(df);
		return now;
	}
	
	

}
