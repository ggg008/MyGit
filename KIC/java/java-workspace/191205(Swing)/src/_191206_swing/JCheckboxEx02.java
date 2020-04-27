package _191206_swing;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class JCheckboxEx02 extends JFrame
{

	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					JCheckboxEx02 frame = new JCheckboxEx02();
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
	public JCheckboxEx02()
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("사과");
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					System.out.println("선택됨");
				} else {
					System.out.println("선택안됨");
				}
					
			}
		});
		chckbxNewCheckBox.setBounds(8, 6, 115, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("수박");
		chckbxNewCheckBox_1.setBounds(8, 31, 115, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("딸기");
		chckbxNewCheckBox_2.setBounds(8, 56, 115, 23);
		contentPane.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("키위");
		chckbxNewCheckBox_3.setBounds(8, 81, 115, 23);
		contentPane.add(chckbxNewCheckBox_3);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				textArea.setText("");//빈값으로 초기화
				
				if(chckbxNewCheckBox.isSelected()) {
					textArea.append(chckbxNewCheckBox.getText() + "\n");
				}  
				if (chckbxNewCheckBox_1.isSelected()) {
					textArea.append(chckbxNewCheckBox_1.getText() + "\n");					
				}  
				if (chckbxNewCheckBox_2.isSelected()) {
					textArea.append(chckbxNewCheckBox_2.getText() + "\n");					
				}
				if (chckbxNewCheckBox_3.isSelected()) {
					textArea.append(chckbxNewCheckBox_3.getText() + "\n");					
				}
			}
		});
		btnNewButton.setBounds(131, 6, 97, 23);
		contentPane.add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setBounds(8, 110, 220, 332);
		contentPane.add(textArea);
	}

}
