package _191206_swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JOptionPaneEx01 extends JFrame
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					JOptionPaneEx01 frame = new JOptionPaneEx01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JOptionPaneEx01()
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("New button");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(JOptionPaneEx01.this, "난 메세지");
				JOptionPane.showMessageDialog(JOptionPaneEx01.this, "난 메세지", "난 타이틀", JOptionPane.WARNING_MESSAGE);	
//				JOptionPane.showMessageDialog(JOptionPaneEx01.this, "난 메세지2", "난 타이틀2", JOptionPane.INFORMATION_MESSAGE);				
			}
		});
		btn1.setBounds(12, 10, 97, 23);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("New button");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				JOptionPane.showConfirmDialog(JOptionPaneEx01.this, "난 메세지", "난 타이틀", JOptionPane.OK_CANCEL_OPTION);
				int result = JOptionPane.showConfirmDialog(JOptionPaneEx01.this, "난 메세지", "난 타이틀", JOptionPane.YES_NO_OPTION);
				System.out.println(result); //close: -1, yes : 0, no : 1, cancel : 2
				
				if(result == JOptionPane.YES_OPTION) {
					System.out.println("YES_OPTION");
				} else if (result == JOptionPane.NO_OPTION) {
					System.out.println("NO_OPTION");
				} else if (result == JOptionPane.CLOSED_OPTION) {
					System.out.println("CLOSED_OPTION");
				}
				
			}
		});
		btn2.setBounds(12, 43, 97, 23);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("New button");
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String msg = JOptionPane.showInputDialog("난메세지");
//				System.out.println(msg);
				
				if(msg != null) {
					System.out.println(msg);
				} else {
					System.out.println("취소 클릭");
				}
			}
		});
		btn3.setBounds(12, 74, 97, 23);
		contentPane.add(btn3);
	}

}
