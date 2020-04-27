package _191205_swing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameEx03 extends JFrame
{
	private JPanel contentPane;
	
	public JFrameEx03()
	{
		// TODO Auto-generated constructor stub
		this.setTitle("제목 " + this.getClass().getName());		
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(10, 10));
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
			
		
		
		JButton btn1 = new JButton("버튼 1");
		JButton btn2 = new JButton("버튼 2");
		JButton btn3 = new JButton("버튼 3");
		JButton btn4 = new JButton("버튼 4");
		JButton btn5 = new JButton("버튼 5");
		btn5.setBackground(Color.WHITE);
		
		
		contentPane.add(btn1, "North");
		contentPane.add(btn2, "South");
		contentPane.add(btn3, "West");
		contentPane.add(btn4, "East");
		contentPane.add(btn5, "Center");
		
	}
	

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		JFrameEx03 frame = new JFrameEx03();
		frame.setVisible(true);
	}

}
