import java.util.Calendar;
import java.util.Date;

public class CalendarEx01 {
	public static void main(String[] args) {
		// p453
		Calendar c = Calendar.getInstance();

		System.out.println(c.toString());
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH) + 1);
		System.out.println(c.get(Calendar.DATE));

		// 일요일 : 1 :api마다 차이점이 있음을 유의
		System.out.println(c.get(Calendar.DAY_OF_WEEK));

		// 요일

		System.out.println((c.get(Calendar.DAY_OF_WEEK)));

		switch (c.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			System.out.println("SunDay");
			break;
		case 2:
			System.out.println("MonDay");
			break;
		case 3:
			System.out.println("TuesDay");
			break;
		case 4:
			System.out.println("WednesDay");
			break;
		case 5:
			System.out.println("ThursDay");
			break;
		case 6:
			System.out.println("FriDay");
			break;
		case 7:
			System.out.println("SaturDay");
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + c.get(Calendar.DAY_OF_WEEK));
		}
		// 더짧게
		String[] weeksArray = { "Sun", "Mon", "Tues", "Wednes", "Thurs", "Fri", "Satur" };
		System.out.println(weeksArray[c.get(Calendar.DAY_OF_WEEK) - 1] + "Day");

		System.out.println(c.getActualMinimum(Calendar.DATE));
		System.out.println(c.getActualMaximum(Calendar.DATE));

		System.out.println(c.getActualMinimum(Calendar.MONTH));
		System.out.println(c.getActualMaximum(Calendar.MONTH));

		Calendar c2 = Calendar.getInstance();
		c2.set(2018, 12 - 1, 1);
		System.out.println(c.get(Calendar.YEAR));

		c2.set(2020, 1 - 1, 1 - 1);// 2019 12 31
		Date d = c2.getTime();
		System.out.println(d.toLocaleString());

		// p458
		System.out.println("\np458 CalenarOperTest");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 29);
		System.out.println("first : " + printSimpleCalendar(cal));
		cal.add(Calendar.DATE, 20);
		System.out.println("after 20day add : " + printSimpleCalendar(cal));
		cal.roll(Calendar.DATE, -20);
		System.out.println("after -20 roll : " + printSimpleCalendar(cal));

	}

	public static String printSimpleCalendar(Calendar c) {
		int month = c.get(Calendar.MONTH);
		int date = c.get(Calendar.DATE);
		return String.format("%d월 %d일", month, date);
	}
}
