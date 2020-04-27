import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P480SimpleDateFormatTest
{

	public static void main(String[] args) throws ParseException// 쓰로우스를 호출함을 유의
	{
		// TODO Auto-generated method stub

		String source = "2020년 12월 25일";
		System.out.println(source + "를 요일정보까지 출력하려면");

		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");

		Date parsed = format.parse(source);
		format.applyPattern("yyyy년 MM월 dd일(E)");
		System.out.println(format.format(parsed));

	}

}
