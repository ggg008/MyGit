package _191205_swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;

public class JButtonEx01 extends JFrame
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
					JButtonEx01 frame = new JButtonEx01();
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
	public JButtonEx01()
	{
		setTitle(this.getClass().getName());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("New button");
		btn1.setBounds(0, 0, 109, 23);
		contentPane.add(btn1);
		
		btn1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e)
			{
				// TODO Auto-generated method stub
				System.out.println("mouseReleased");
				
			}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub
				System.out.println("mousePressed");
			}
			
			@Override
			public void mouseExited(MouseEvent e)
			{
				// TODO Auto-generated method stub
				System.out.println("mouseExited");
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub
				System.out.println("mouseEntered");
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub
				System.out.println("mouseClicked");
				
			}
		});
		
		JButton btn2 = new JButton("<html><font color='red'>Hello</font><br/>하하</html>");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn2.setBounds(0, 33, 109, 47);
		contentPane.add(btn2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\acorn\\OneDrive\\java\\java-workspace\\191205(Swing)\\N모자.jpg"));
		btnNewButton.setBounds(0, 90, 70, 63);
		contentPane.add(btnNewButton);
	}

}
