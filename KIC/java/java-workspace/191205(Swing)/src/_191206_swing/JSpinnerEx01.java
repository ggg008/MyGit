package _191206_swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class JSpinnerEx01 extends JFrame
{

	private JPanel contentPane;
	private JSpinner spinner1;
	private JSpinner spinner2;
	private JSpinner spinner3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					JSpinnerEx01 frame = new JSpinnerEx01();
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
	public JSpinnerEx01()
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] items = new String[] {"사과", "\uC218\uBC27", "\uB538\uAE30", "\uD0A4\uC704", "done"};
		SpinnerListModel spinnerListModel = new SpinnerListModel(items);// 데이터를 저장하는 모델
		
		
		spinner1 = new JSpinner();
		spinner1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				System.out.println((String)spinner1.getValue());
			}
		});
		spinner1.setModel(spinnerListModel); 
		spinner1.setBounds(12, 10, 124, 41);
		contentPane.add(spinner1);
		
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
//				System.out.println((String)spinner1.getValue());
				System.out.println((Integer)spinner2.getValue());
				
			}
		});
		btnNewButton.setBounds(165, 10, 108, 41);
		contentPane.add(btnNewButton);
		
		spinner2 = new JSpinner();
		spinner2.setModel(new SpinnerNumberModel(50, 0, 100, 10));
		spinner2.setBounds(12, 61, 124, 41);
		contentPane.add(spinner2);
		
		spinner3 = new JSpinner();
		spinner3.setModel(new SpinnerDateModel(new Date(1575558000000L), new Date(952268400000L), new Date(1575558000000L), Calendar.DAY_OF_MONTH));
		spinner3.setBounds(12, 112, 124, 41);
		contentPane.add(spinner3);
	}
}
