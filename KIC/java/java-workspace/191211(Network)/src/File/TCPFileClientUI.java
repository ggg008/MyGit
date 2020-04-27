package File;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TCPFileClientUI extends JFrame {

	private JPanel contentPane;
	private JLabel lbl;

	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;

	Socket socket = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TCPFileClientUI frame = new TCPFileClientUI();
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
	public TCPFileClientUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn1 = new JButton("서버 연결");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					System.out.println( "서버와 연결 중입니다." );
					socket = new Socket( "localhost", 7777 );
					System.out.println( "서버와 연결되었습니다." );
					
					btn1.setEnabled( false );
					btn2.setEnabled( true );
					btn4.setEnabled( true );
					
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn1.setBounds(12, 10, 500, 23);
		contentPane.add(btn1);
		
		btn2 = new JButton("파일 찾기");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser( "c:\\" );
				int result = fileChooser.showOpenDialog( TCPFileClientUI.this );
				if( result == JFileChooser.APPROVE_OPTION ) {
					lbl.setText(fileChooser.getSelectedFile().getAbsolutePath() );
					btn3.setEnabled( true );
				} else if( result == JFileChooser.CANCEL_OPTION ) {
				} else {
				}
			}
		});
		btn2.setEnabled(false);
		btn2.setBounds(415, 43, 97, 23);
		contentPane.add(btn2);
		
		btn3 = new JButton("서버 전송");
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BufferedOutputStream bos = null;
				BufferedInputStream bis = null;
				
				try {
					bos = new BufferedOutputStream( socket.getOutputStream());                
					bis = new BufferedInputStream( new FileInputStream( lbl.getText() ) );

					int data = 0;
					while( ( data = bis.read()) != -1 ) {
						bos.write( data );
					}
					
					JOptionPane.showMessageDialog( TCPFileClientUI.this, "서버로 전송 완료", "메시지", JOptionPane.INFORMATION_MESSAGE);

					lbl.setText( "" );
					btn3.setEnabled( false );
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					if( bis != null ) try { bis.close(); } catch( IOException e1 ) {}
					if( bos != null ) try { bos.close(); } catch( IOException e1 ) {}
				}
			}
		});
		btn3.setEnabled(false);
		btn3.setBounds(12, 74, 500, 23);
		contentPane.add(btn3);
		
		btn4 = new JButton("서버 연결 종료");
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					socket.close();
					
					btn1.setEnabled( true );
					btn2.setEnabled( false );
					btn3.setEnabled( false );
					btn4.setEnabled( false );
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn4.setEnabled(false);
		btn4.setBounds(12, 106, 500, 23);
		contentPane.add(btn4);
		
		lbl = new JLabel("");
		lbl.setBounds(12, 43, 391, 23);
		contentPane.add(lbl);
	}
}
