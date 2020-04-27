package _191209_swing;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ZipSearchEx02 extends JFrame
{

	private JPanel contentPane;
	private JTextField textField;
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
					ZipSearchEx02 frame = new ZipSearchEx02();
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
	public ZipSearchEx02()
	{
		this.setTitle(this.getClass().getName());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC6B0\uD3B8\uBC88\uD638 \uAC80\uC0C9\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 10, 599, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(93, 20, 385, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("찾기");
		btnNewButton.addMouseListener(new MouseAdapter() {//익명클래스
			@Override
			public void mousePressed(MouseEvent e) {
				String strDong = textField.getText();
				if( strDong.length() < 2) {
					JOptionPane.showMessageDialog(ZipSearchEx02.this, "2자 이상 입력하셔야 됩니다");
				} else {
//					JOptionPane.showMessageDialog(ZipSearchEx02.this, "정상");
					textArea.setText("");
					
					String url = "jdbc:mysql://127.0.0.1:3306/employees";
//					String url = "jdbc:mysql://192.168.0.18:3306/employees";
					String user = "root";
					String password = "123456";
					
					Connection conn = null;					
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					try {
						Class.forName("org.mariadb.jdbc.Driver");
						conn = DriverManager.getConnection(url, user, password);
						
						String sql = "select * from zipcode where dong like ?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, strDong + "%");
						
						rs = pstmt.executeQuery();
						while(rs.next()) {
							String zipcode = rs.getString("zipcode");
							String sido = rs.getString("sido");
							String gugun = rs.getString("gugun");
							String dong = rs.getString("dong");
							String ri = rs.getString("ri");
							String bunji = rs.getString("bunji");
							
							String address = String.format("[%s] %s %s %s %s %s", zipcode, sido, gugun, dong, ri, bunji);
							
							textArea.append(address + "\n");
						}
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} finally {
						if(rs != null) try {rs.close();} catch (Exception e2) {}
						if(pstmt != null) try {pstmt.close();} catch (Exception e2) {}
						if(conn != null) try {conn.close();} catch (Exception e2) {}
					}
					
					
				}
				
				
			}
		});
		btnNewButton.setBounds(490, 19, 97, 23);
		panel.add(btnNewButton);
		
		JLabel label = new JLabel("동 이름 입력 :");
		label.setBounds(14, 23, 82, 15);
		panel.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 77, 596, 350);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}
}
