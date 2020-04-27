import java.util.Scanner;

public class ScannerEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "One-true-false-100-true-korea";
		
		//=StringTokenizer
		Scanner scan = new Scanner(str);
		//Delimiter == 구분자
		scan.useDelimiter("-");
		
//		System.out.println(scan.next());
//		System.out.println(scan.next());
		while (scan.hasNext()) {
			System.out.println(scan.next());			
		}
		
		scan.close();
		
	}

}
