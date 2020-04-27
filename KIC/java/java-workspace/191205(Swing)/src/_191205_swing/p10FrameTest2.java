package _191205_swing;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class p10FrameTest2
{

	public static void main(String[] args)
	{
		// 정중앙 포지션 얻기
		// TODO Auto-generated method stub
		JFrame f = new JFrame("Login");
		f.setSize(300, 200);
		
		Toolkit tk = Toolkit.getDefaultToolkit(); // 구현된 Toolkit 객체 를 얻는다.
		Dimension screenSize = tk.getScreenSize(); // 화면의 크기를 구한다.
		
		// 화면크기의 절반값에서 Frame 크기의 절반값을 뺀 위치로 하면
		// Frame이 화면 가운데 위치하게 된다.		
		f.setLocation(screenSize.width/2 - f.getWidth()/2, screenSize.height/2 - f.getHeight()/2);
		f.setVisible(true); // 생성한 Frame을 화면에 보이도록 한다.
				
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
