package _191205_swing;

import javax.swing.JFrame;

public class JFrameEx02 extends JFrame
{
	public JFrameEx02()
	{
		// TODO Auto-generated constructor stub
		
		this.setTitle(this.getClass().getName() + " 난 제목줄 2 " + this.getName());
		
		// 프레임 설정
		
//		this.setSize(1024, 648);
//		this.setLocation(100, 100);
		this.setBounds(100, 100, 1027, 768);
		
		
		
		// x -> 버튼 클릭하면 - 프로그램 종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		JFrameEx02 frame = new JFrameEx02();
		frame.setVisible(true);
		
		
	}
}
