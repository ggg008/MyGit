package _191205_swing;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class JuminCheckEx01 extends JFrame
{

	private JPanel contentPane;
	private JTextField tfJumin1;
	private JPasswordField tfJumin2;
	private JLabel lbl2;
	private JButton btn1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					JuminCheckEx01 frame = new JuminCheckEx01();
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
	public JuminCheckEx01()
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 154);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfJumin1 = new JTextField();
		tfJumin1.setBounds(12, 10, 203, 21);
		contentPane.add(tfJumin1);
		tfJumin1.setColumns(10);
		
		tfJumin2 = new JPasswordField();
		tfJumin2.setColumns(10);
		tfJumin2.setBounds(227, 10, 203, 21);
		contentPane.add(tfJumin2);
		
		JLabel lbl1 = new JLabel("출력결과 :");
		lbl1.setVerticalAlignment(SwingConstants.TOP);
		lbl1.setBounds(12, 49, 61, 38);
		contentPane.add(lbl1);
		
		lbl2 = new JLabel("");
		lbl2.setVerticalAlignment(SwingConstants.TOP);
		lbl2.setBounds(75, 49, 473, 38);
		contentPane.add(lbl2);
		
		btn1 = new JButton("검사하기");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String jumin = tfJumin1.getText() + new String(tfJumin2.getPassword());
				
				int bits[] = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };
				
				int sum = 0;
				for(int i = 0; i < bits.length; ++i) {
					sum += Integer.parseInt(jumin.substring(i, i + 1)) * bits[i];
				}
				
				
				int lastNum = Integer.parseInt(jumin.substring(12, 13));
				int resultNum = (11 - (sum % 11)) % 10;
				
				if(lastNum == resultNum) {
					lbl2.setText("맞음");					
				} else {
					lbl2.setText("틀림");					
				}
								
			}
		});
		
		btn1.setBounds(442, 9, 97, 23);
		contentPane.add(btn1);
	}

}
