
public class ProcessBuilderEx01 {
	public static void main(String[] args) throws Exception {//<-Exception있음을 발견 191112
		
		//자바 외부 프로그램을 실행
		ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\Internet Explorer\\iexplore.exe", "www.naver.com");//2번째 인자가 args와 동일
//		pb.start();

		//notePad
		
//		pb.command("C:\\windows\\system32\\notepad.exe", "C:\\Users\\kitcoop\\OneDrive\\java\\Class\\Day08_Java.java");		
//		pb.start();
		
		ProcessBuilder np = new ProcessBuilder("C:\\windows\\system32\\notepad.exe");
//		np.start();
		
		ProcessBuilder p = new ProcessBuilder("explorer.exe", "/select,C:\\directory\\selectedFile");
//		p.start();
		

		ProcessBuilder p2 = new ProcessBuilder("explorer.exe", ".\\bin");

		p2.start();
	}
}
