
public class SystemEx01 {
	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		System.out.println(osName);
		String userName = System.getProperty("user.name");
		System.out.println(userName);
		String javaVersion = System.getProperty("java.runtime.name");
		System.out.println(javaVersion);
		
		String systemPath = System.getenv("path");
		System.out.println(systemPath);
	}
}
