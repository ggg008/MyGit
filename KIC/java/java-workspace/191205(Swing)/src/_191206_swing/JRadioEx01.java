package _191206_swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JRadioEx01 extends JFrame
{

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					JRadioEx01 frame = new JRadioEx01();
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
	public JRadioEx01()
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtn1 = new JRadioButton("사과");
		rdbtn1.setSelected(true);
		buttonGroup.add(rdbtn1);
		rdbtn1.setBounds(8, 6, 121, 23);
		contentPane.add(rdbtn1);
		
		JRadioButton rdbtn2 = new JRadioButton("수박");
		buttonGroup.add(rdbtn2);
		rdbtn2.setBounds(8, 31, 121, 23);
		contentPane.add(rdbtn2);
		
		JRadioButton rdbtn3 = new JRadioButton("딸기");
		buttonGroup.add(rdbtn3);
		rdbtn3.setBounds(8, 56, 121, 23);
		contentPane.add(rdbtn3);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(8, 85, 219, 202);
		contentPane.add(textArea);
		
		JButton btn = new JButton("New button");
		btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				textArea.setText("");//빈값으로 초기화
				
				if(rdbtn1.isSelected()) {
					textArea.append(rdbtn1.getText() + "\n");
				}  
				else if (rdbtn2.isSelected()) {
					textArea.append(rdbtn2.getText() + "\n");					
				}  
				else if (rdbtn3.isSelected()) {
					textArea.append(rdbtn3.getText() + "\n");					
				}
				
			}
		});
		btn.setBounds(137, 6, 97, 23);
		contentPane.add(btn);
	}
}
