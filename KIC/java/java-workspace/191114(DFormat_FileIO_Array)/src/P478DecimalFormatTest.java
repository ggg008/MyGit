import java.text.DecimalFormat;
import java.text.ParseException;

public class P478DecimalFormatTest
{
	public static void main(String[] args) throws ParseException
	{
		//형식화 클래스
		//문자열 포맷(형식) 처리
		double orgNum = 1234.5;
		
		String formatString = "\u00A4\u00A4#,###.#";
		
		DecimalFormat df = new DecimalFormat(formatString);
		System.out.println(df.format(orgNum));
		
		String orgStr = df.format(orgNum);
		double parsed = (double)df.parse(orgStr);
		System.out.println(parsed);
		
		df.applyPattern("#.#%");
		System.out.println(df.format(parsed));
				
	}
}
