import java.io.IOException;

public class UnPgExceptionThrowsPB {

	public static void main(String[] args) throws IOException{//<-main에서 하면 JVM에 던진다 : 비추천 방법 : 주로 귀찮을때
		// TODO Auto-generated method stub
		// Exception Handling 기법
		ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\Internet Explorer\\iexplore.exe", "www.naver.com");
		
		// note: //리눅스, \\윈도우 표현
		try {			
			pb.start();
		} catch (IOException e) {
			// TODO: handle exception
			
		}
		//드래그 블록후 -> surround with ->
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//기본값이나 자주쓰지 않음 주로 getMessage
		}
	}

}
