import java.util.Enumeration;
import java.util.Properties;

public class P537PropertiesEx01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.setProperty("timeout", "30");
		props.setProperty("language", "kr");
		props.setProperty("size", "10");
		
		System.out.println(props.getProperty("size"));
		System.out.println(props.getProperty("language"));
		
		System.out.println("\n전체데이터 접근 Enumeration");
		Enumeration e = props.propertyNames();
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());			
		}
		
		System.out.println();
		System.err.println();
		
		//02
		System.out.println("--Ex02--");
		System.out.println("시스템 프로퍼티로 자바환경설정 가져와 보기");
		Properties props2 = System.getProperties();
		Enumeration e2 = props2.propertyNames();
		while (e2.hasMoreElements()) {
			String key = (String)e2.nextElement();			
			System.out.println(key + " : " + props2.getProperty(key));			
		}
	}

}
