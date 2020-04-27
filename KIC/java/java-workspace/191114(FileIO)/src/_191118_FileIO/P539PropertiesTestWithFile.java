package _191118_FileIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;
import java.util.Set;

public class P539PropertiesTestWithFile
{
	private final static String PROP_FILE_PATH = "./config.txt";//이름은 아무렇게 해도 된다(중요한건 파일은 코드가 해석한다는것)
	
	private static void saveToFile()
	{
		Properties props = new Properties();
		
		props.setProperty("id", "andy");
		props.setProperty("pass", "1234");
		props.setProperty("addr", "192.168.0.2");
		props.setProperty("이름", "홍길동");
		System.out.println("저장전 속성 확인 : " + props);
		
		try(FileWriter output = new FileWriter(PROP_FILE_PATH)) {
			props.store(output, "System Config");			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private static void loadFromFile() {
		Properties props = new Properties();
		try (FileReader input = new FileReader(PROP_FILE_PATH)) {
			props.load(input);
			Set<String> keys = props.stringPropertyNames();
			for(String key : keys) {
				System.out.println(key + " : " + props.getProperty(key));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
//		saveToFile();
		loadFromFile();
		
	}

}
