package _191205_swing;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

public class JTextFieldEx01 extends JFrame
{

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lbl1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					JTextFieldEx01 frame = new JTextFieldEx01();
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
	public JTextFieldEx01()
	{
		setTitle(getClass().getName());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 10, 331, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.out.println(textField.getText());
//				lbl1.setText(textField.getText());		
				
//				lbl1.setText("암호 : " + passwordField.getText()); // deprecated
				lbl1.setText("암호 : " + new String(passwordField.getPassword())); // new // return값이 char[]로 바뀌었음을 생각
			}
		});
		btnNewButton.setBounds(355, 9, 97, 23);
		contentPane.add(btnNewButton);

		lbl1 = new JLabel("New label");
		lbl1.setBounds(12, 145, 440, 15);
		contentPane.add(lbl1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(12, 41, 331, 21);
		contentPane.add(passwordField);
	}
}
