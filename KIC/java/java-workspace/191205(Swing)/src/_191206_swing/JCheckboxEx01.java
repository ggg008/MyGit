package _191206_swing;

import java.awt.EventQueue;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JCheckboxEx01 extends JFrame
{

	private JPanel contentPane;
	private JCheckBox chckbx3;
	private JCheckBox chckbx2;
	private JCheckBox chckbx1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					JCheckboxEx01 frame = new JCheckboxEx01();
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
	public JCheckboxEx01()
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		chckbx1 = new JCheckBox("사과");
		chckbx1.setSelected(true);
		chckbx1.setBounds(8, 6, 59, 23);
		contentPane.add(chckbx1);
		
		chckbx2 = new JCheckBox("수박");
		chckbx2.setBounds(8, 31, 59, 23);
		contentPane.add(chckbx2);
		
		chckbx3 = new JCheckBox("딸기");
		chckbx3.setBounds(8, 56, 59, 23);
		contentPane.add(chckbx3);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println(chckbx1.getText() + " " + chckbx1.isSelected());
				System.out.println(chckbx2.getText() + " " + chckbx2.isSelected());
				System.out.println(chckbx3.getText() + " " + chckbx3.isSelected());
			}
		});
		btnNewButton.setBounds(75, 6, 97, 23);
		contentPane.add(btnNewButton);
	}
}
