package _191209_swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JTableEx01 extends JFrame
{

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					JTableEx01 frame = new JTableEx01();
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
	public JTableEx01()
	{
		setTitle(getClass().getName());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 594, 270);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
			}
		});
		scrollPane.setViewportView(table);
		table.setBorder(UIManager.getBorder("Spinner.border"));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "2", "3", "4", "5"},
				{"6", "7", "8", "9", "10"},
				{"11", "12", "13", "14", "15"},
				{"16", "17", "18", "19", "20"},
				{"21", "22", "23", "24", "25"},
			},
			new String[] {
				"XX11", "XXXC", "New column", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
//		table.setModel(new CustomTableModel());
	}
}
