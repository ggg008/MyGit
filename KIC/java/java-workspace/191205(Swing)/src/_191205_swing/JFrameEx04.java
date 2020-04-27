package _191205_swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class JFrameEx04 extends JFrame
{

	private JPanel contentPane;
	private JLabel lbl1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					JFrameEx04 frame = new JFrameEx04();
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
	public JFrameEx04()
	{
		setResizable(false);
		setBackground(Color.PINK);
		setTitle("난 제목글2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl1 = new JLabel("난 라벨");
		lbl1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl1.setForeground(new Color(153, 51, 0));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(12, 10, 200, 51);
		contentPane.add(lbl1);
		
		lbl1.setText("새로운 라벨\r\nddd");
		System.out.println(lbl1.getText());
		
		
		
		JLabel lbl2 = new JLabel("<html><font color='red'>Hello</font><br/>하하</html>");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setBounds(12, 71, 200, 35);
		contentPane.add(lbl2);
	}
}
