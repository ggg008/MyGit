package _191211_swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.DropMode;
import javax.swing.ScrollPaneConstants;

public class JMenuBarEx01 extends JFrame
{

	private JPanel contentPane;
	private JTextArea textArea;
	private JTree tree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					JMenuBarEx01 frame = new JMenuBarEx01();
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
	public JMenuBarEx01()
	{
		setTitle(getClass().getName());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Consolas", Font.PLAIN, 10));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mntmNewMenuItem.setFont(new Font("Consolas", Font.PLAIN, 10));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//엔터키를 눌렀을때
				System.out.println("actionPerformed");
				
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu.addSeparator();
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mntmNewMenuItem_1.setFont(new Font("Consolas", Font.PLAIN, 10));
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("pressed");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mnNewMenu.addSeparator();
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mntmNewMenuItem_2.setFont(new Font("Consolas", Font.PLAIN, 10));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		mnNewMenu_1.setFont(new Font("Consolas", Font.PLAIN, 10));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		mntmNewMenuItem_3.setFont(new Font("Consolas", Font.PLAIN, 10));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		mnNewMenu_1.addSeparator();
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("New menu item");
		mntmNewMenuItem_4.setFont(new Font("Consolas", Font.PLAIN, 10));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		mnNewMenu_1.addSeparator();
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("New menu item");
		mntmNewMenuItem_5.setFont(new Font("Consolas", Font.PLAIN, 10));
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("Source");
		mnNewMenu_2.setFont(new Font("Consolas", Font.PLAIN, 10));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("New menu item");
		mntmNewMenuItem_6.setFont(new Font("Consolas", Font.PLAIN, 10));
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		mnNewMenu_2.addSeparator();
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("New menu item");
		mntmNewMenuItem_7.setFont(new Font("Consolas", Font.PLAIN, 10));
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		mnNewMenu_2.addSeparator();
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("New menu item");
		mntmNewMenuItem_8.setFont(new Font("Consolas", Font.PLAIN, 10));
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(195, 10, 164, 44);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap (true);
		
		tree = new JTree();
		tree.setBounds(12, 10, 141, 210);
		contentPane.add(tree);
	}
}
