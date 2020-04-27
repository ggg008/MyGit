import java.util.Date;

public class DateEx01 {

	public static void main(String[] args) {	
		//현재시간(날짜/시간)이 저장된 클래스		
		Date d = new Date();
		
		System.out.println(d);
		System.out.println(d.toString()); // 오버라이드
		System.out.println(d.toLocaleString()); 
		
		//사용법
		System.out.println("년 : " + (d.getYear() + 1900));
		System.out.println("월 : " + (d.getMonth() + 1));
		System.out.println("일 : " + d.getDate());
		System.out.println("요일 : " + d.getDay());
		
		System.out.println("시간 : " + d.getHours());
		
		//02
		System.out.println("\nEx02");
		
		// 2019. 12. 25
		Date d2 = new Date(2019-1900, 12-1, 25);
		
		System.out.println(d2.toLocaleString());
		System.out.println(d2.getDay());
		
		// 2019-2-마지막날
		d2 = new Date(2019-1900, 3-1, 0/*1일 전날*/);
		System.out.println(d2.toLocaleString());
		

		//03
		System.out.println("\nEx03");
		Date d3 = new Date();
		
		//timeStamp
		System.out.println(d3.getTime());
		System.out.println(System.currentTimeMillis());
		
		d3 = new Date(System.currentTimeMillis());
		System.out.println(d3.toLocaleString());
	}

}
