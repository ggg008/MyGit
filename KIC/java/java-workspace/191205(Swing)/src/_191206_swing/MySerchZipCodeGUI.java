package _191206_swing;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MySerchZipCodeGUI extends JFrame
{

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					MySerchZipCodeGUI frame = new MySerchZipCodeGUI();
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
	public MySerchZipCodeGUI()
	{
		setTitle(this.getClass().getName());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(506, 13, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 482, 432);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("동검색");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
								
				String strSearchDong = textField.getText();
				
				if(!SeachUtil.getType(strSearchDong)) {
					JOptionPane.showMessageDialog(MySerchZipCodeGUI.this, "한글로 입력해주세요", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				try {
					
					ArrayList<String> resultList = SeachUtil.searchDong(strSearchDong);
					
					textArea.setText("");
					
					for(String result : resultList) {
						textArea.append(result + "\n");
					}
					
					
					if(resultList.size() <= 0) {
						textArea.append("검색어 ["+ strSearchDong +"] 조건에 맞는 결과값이 없습니다.");
					} else {
						textArea.append("검색어 ["+ strSearchDong +"] 검색결과, 총 " + resultList.size() + "개의 결과를 찾았습니다.");
					}
						
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(506, 43, 116, 23);
		contentPane.add(btnNewButton);
	}


}
