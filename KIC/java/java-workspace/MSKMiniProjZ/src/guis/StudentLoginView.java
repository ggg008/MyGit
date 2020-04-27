package guis;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import content.MyClassStudentContent;

public class StudentLoginView extends JFrame
{
	private static StudentLoginView slv = null;
	
	private JPanel contentPane;
	private JTextField textFiled;
	private StudentInfoView joinView = null;
	
	
	public StudentInfoView getJoinView()
	{
		return joinView;
	}

	public void setJoinView(StudentInfoView joinView)
	{
		System.out.println("조인뷰 셋");
		this.joinView = joinView;
	}

	private final String hint = "아이디를 입력하세요.";
	private boolean showingHint = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					StudentLoginView frame = new StudentLoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static StudentLoginView getInstance()
	{
		if(slv == null)
			slv = new StudentLoginView();
	
		return slv;
	}

	/**
	 * Create the frame.
	 */
	private StudentLoginView()
	{	
		setTitle("마이클래스 로그인");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 257, 162);
				
		Toolkit tk = Toolkit.getDefaultToolkit(); // 구현된 Toolkit 객체 를 얻는다.
		Dimension screenSize = tk.getScreenSize(); // 화면의 크기를 구한다.
		setLocation(screenSize.width/2 - this.getWidth()/2, screenSize.height/2 - this.getHeight()/2);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFiled = new JTextField();
		textFiled.setText(hint);
		textFiled.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println("--------------");
//				System.out.println(textFiled.getText());
//				System.out.println(hint);
//				System.out.println("--------------");
				if(textFiled.getText().contains(hint)) {
					textFiled.setText("");
					showingHint = false;
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (textFiled.getText().equals("")) {
					textFiled.setText(hint);
					showingHint = true;
				}
			}
		});
		textFiled.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textFiled.getText().isEmpty()) {
					textFiled.setText(hint);
					showingHint = true;
				}
			}
		});
		textFiled.setBounds(11, 21, 217, 27);
		contentPane.add(textFiled);
		
		
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		    	if(textFiled.getText().equals("") || textFiled.getText().equals(hint)) {

		        	JOptionPane.showMessageDialog(StudentLoginView.getInstance(), "아이디를 입력해 주세요", "메세지", JOptionPane.CLOSED_OPTION);
		    		return;
		    	}
				MyClassStudentContent.reqLogin(textFiled.getText());
			}
		});
		btnNewButton.setBounds(12, 67, 97, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("가입신청");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyClassStudentContent.reqFirstWriteMyInfo();
			}
		});
		btnNewButton_1.setBounds(132, 67, 97, 36);
		contentPane.add(btnNewButton_1);
				
	}
}
