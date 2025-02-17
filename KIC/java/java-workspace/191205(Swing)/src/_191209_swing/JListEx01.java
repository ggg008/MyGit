package _191209_swing;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class JListEx01 extends JFrame
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
					JListEx01 frame = new JListEx01();
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
	public JListEx01()
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 560, 203);
		contentPane.add(scrollPane);
		
		JList<String> list = new JList<String>();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				System.out.println(list.getSelectedIndex());
				System.out.println(list.getSelectedValue().toString());
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
//		list.setModel(new AbstractListModel() {
//			String[] values = new String[] {"사과", "딸기", "수박", "키위", "딸기", "수박", "키위", "딸기", "수박", "키위"};
//			public int getSize() {
//				return values.length;
//			}
//			public Object getElementAt(int index) {
//				return values[index];
//			}
//		});
		
		list.setModel(new CustomListModel());
		
		list.setSelectedIndex(5);
		
	}
}
