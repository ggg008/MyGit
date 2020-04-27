package _191206_swing;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class JComboBoxEx01 extends JFrame
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					JComboBoxEx01 frame = new JComboBoxEx01();
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
	public JComboBoxEx01()
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {//SELECTED 와 DESELECTED 연속 발생
				if(e.getStateChange() == ItemEvent.SELECTED) {
					System.out.println(comboBox.getSelectedItem());					
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"으아아아"}));
		comboBox.setBounds(12, 10, 118, 23);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String[] items = new String[] {"사과", "딸기", "수박"};
				DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(items);// 데이터를 저장하는 모델
				comboBox.setModel(model);
			}
		});
		btnNewButton.setBounds(142, 10, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
//				System.out.println(comboBox.getItemAt(comboBox.getSelectedIndex()));
				System.out.println(comboBox.getSelectedIndex());
				System.out.println((String)comboBox.getSelectedItem());
				
			}
		});
		btnNewButton_1.setBounds(142, 43, 97, 23);
		contentPane.add(btnNewButton_1);
	}
}
