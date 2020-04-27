package _191205_swing;

import javax.swing.JFrame;

public class JFrameEx01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		JFrame frame = new JFrame();

		frame.setTitle("난 제목줄");
		
		// 크기와 사이즈 셋
		frame.setSize(720, 360);
		frame.setLocation(100, 100);

		frame.setVisible(true);

		
		//my
		while (true) {
			if (!frame.isActive())
				System.exit(0);
		}

	}

}
