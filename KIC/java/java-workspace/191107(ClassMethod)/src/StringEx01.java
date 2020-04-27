
public class StringEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//문자열
		String strA = "Hello String";
		String str = "Hello String";//constant pool (상수저장공간)
		
		String str3 = new String("Hello String");//Heap <= 메모리 낭비
		
		System.out.println(strA);
		System.out.println(str3);
		

	}

}
