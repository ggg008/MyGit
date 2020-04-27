package _191211_swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EditorEx01 extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorEx01 frame = new EditorEx01();
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
	public EditorEx01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uD30C\uC77C \uAD00\uB9AC", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(9, 11, 761, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn1 = new JButton("자바 파일 열기");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser( "c:\\java" );
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Java Source File", "java");
				fileChooser.setFileFilter(filter);
				
				
				int flag = fileChooser.showOpenDialog(EditorEx01.this);
				if( flag == JFileChooser.APPROVE_OPTION ) {
					EditorDAO dao = new EditorDAO();
					textArea.setText(dao.readFile(fileChooser.getSelectedFile()).toString());
				}
			}
		});
		btn1.setBounds(12, 24, 137, 23);
		panel.add(btn1);
		
		JButton btn2 = new JButton("자바 파일 저장");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser( "c:\\java" );
				
				// flag - 출력 구분
				int flag = fileChooser.showSaveDialog(EditorEx01.this);
				if( flag == JFileChooser.APPROVE_OPTION ) {
					EditorDAO dao = new EditorDAO();
					boolean result = dao.writeFile(fileChooser.getSelectedFile(), textArea.getText());
					if( result ) {
						JOptionPane.showMessageDialog(EditorEx01.this, "저장 성공", "파일 저장", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(EditorEx01.this, "저장 실패", "파일 저장", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btn2.setBounds(161, 24, 137, 23);
		panel.add(btn2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 82, 760, 470);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
