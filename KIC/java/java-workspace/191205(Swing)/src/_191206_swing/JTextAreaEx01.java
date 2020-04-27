package _191206_swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class JTextAreaEx01 extends JFrame
{

	private JPanel contentPane;
	private JTextField textField;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					JTextAreaEx01 frame = new JTextAreaEx01();
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
	public JTextAreaEx01()
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 53, 200, 150);
		contentPane.add(scrollPane);
		
		JTextArea txtArea = new JTextArea();
		scrollPane.setViewportView(txtArea);
		txtArea.setEditable(false);
		txtArea.setText("Hello\r\nHello\r\n");
		
		textField = new JTextField();
		textField.setBounds(12, 10, 200, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btn1 = new JButton("New button");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!textField.getText().equals("")) {				
					txtArea.append(textField.getText() + "\n");
					textField.setText("");
				}
			}
		});
		btn1.setBounds(224, 9, 97, 23);
		contentPane.add(btn1);
	}
}
