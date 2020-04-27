package _191206_swing;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JProgressBarEx01 extends JFrame
{

	private JPanel contentPane;
	private JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					JProgressBarEx01 frame = new JProgressBarEx01();
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
	public JProgressBarEx01()
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setValue(50);
		progressBar.setBounds(12, 10, 610, 14);
		contentPane.add(progressBar);
		
		JButton btn1 = new JButton("감소");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				progressBar.setValue(progressBar.getValue() - 10);
			}
		});
		btn1.setBounds(12, 34, 97, 23);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("증가");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				progressBar.setValue(progressBar.getValue() + 10);//쓰레드로 많이 사용
			}
		});
		btn2.setBounds(525, 34, 97, 23);
		contentPane.add(btn2);
	}
}
