package _191210_swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JDialogEx01 extends JFrame
{

	private JPanel contentPane;
	private JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					JDialogEx01 frame = new JDialogEx01();
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
	public JDialogEx01()
	{
		setTitle(getClass().getName());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// JFrame 에서 JDialog 초기화
				// JDialog에서 처리결과 -> JFrame
				// setter/getter 메서드
				
				
				SubDialogEx01 dialog = new SubDialogEx01();
				
				dialog.setData("초기화데이터");
				
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				System.out.println("1");
				dialog.setModal(true);
				System.out.println("2");
				dialog.setVisible(true);
				System.out.println("3");
				
				System.out.println(dialog.getData());
			}
		});
		btnNewButton.setBounds(12, 10, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Color color = JColorChooser.showDialog(JDialogEx01.this, "팔레트", Color.RED);
//				System.out.println(color);
				if(color == null) {
					System.out.println("취소나 X 선택");					
				} else {
					System.out.println(color.toString());
					System.out.println(color.getRed());
					System.out.println(color.getGreen());
					System.out.println(color.getBlue());
				}
			}
		});
		btnNewButton_1.setBounds(12, 43, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("전경색");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {				
				Color color = JColorChooser.showDialog(JDialogEx01.this, "전경색", Color.RED);

				if(color != null) {
					lbl.setForeground(color);
				}
			}
		});
		btnNewButton_2.setBounds(12, 76, 97, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("배경색");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {				
				Color color = JColorChooser.showDialog(JDialogEx01.this, "배경색", Color.RED);
				

				if(color != null) {
					lbl.setBackground(color);
				}
			}
		});
		btnNewButton_3.setBounds(121, 76, 97, 23);
		contentPane.add(btnNewButton_3);
		
		lbl = new JLabel("색상 바꾸기");
		lbl.setBackground(Color.WHITE);
		lbl.setOpaque(true);
		lbl.setBounds(231, 80, 193, 15);
		contentPane.add(lbl);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 파일 2옵션, 열기 / 저장
				JFileChooser fileChooser = new JFileChooser("c:\\MyCloud");//특정위치 지정
				int result = fileChooser.showOpenDialog(JDialogEx01.this);
				
				if(result == JFileChooser.APPROVE_OPTION) {
					System.out.println("정상");
					
					System.out.println(fileChooser.getSelectedFile().getAbsolutePath());//File IO
					
				} else if (result == JFileChooser.CANCEL_OPTION) {
					System.out.println("취소");					
				} else {
					
				}				
			}
		});
		btnNewButton_4.setBounds(12, 109, 97, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser("c:\\MyCloud");//특정위치 지정
				int result = fileChooser.showSaveDialog(JDialogEx01.this);
				
				if(result == JFileChooser.APPROVE_OPTION) {					
					System.out.println(fileChooser.getSelectedFile().getAbsolutePath());//이 경로를 File IO을 이용해서...
					
				} 
			}
		});
		btnNewButton_5.setBounds(121, 109, 97, 23);
		contentPane.add(btnNewButton_5);
	}
}
