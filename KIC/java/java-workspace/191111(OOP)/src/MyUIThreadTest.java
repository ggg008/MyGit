import java.util.Random;

import javax.swing.JOptionPane;

public class MyUIThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int first = random.nextInt(9) + 1;
		int second = random.nextInt(9) + 1;
		
		for(int i = 3; i > 0; --i) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ignore) {
				// TODO: handle exception
				System.out.println("count down : " + i);
			}
			String result = JOptionPane.showInputDialog(first + "*" + second + "?");
			System.out.println("입력 : " + result + ", 정답은: " + (first * second));			
		}
	}

}
