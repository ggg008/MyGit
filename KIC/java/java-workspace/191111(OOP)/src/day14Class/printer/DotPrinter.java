package day14Class.printer;

public class DotPrinter implements Printer {
	@Override
	public void print(String fileName) {
		// TODO Auto-generated method stub
		System.out.printf("Dot Printer로 출력중 : %s\n", fileName);
	}
}
