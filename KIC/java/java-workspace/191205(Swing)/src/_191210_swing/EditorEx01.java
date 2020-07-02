package _191210_swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilePermission;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.AccessController;

public class EditorEx01 extends JFrame
{

	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					EditorEx01 frame = new EditorEx01();
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
	public EditorEx01()
	{
		setTitle(getClass().getName());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("자바 파일 열기");//필터 사용해서 자바파일만 거를수도 있음
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser("c:\\");
				FileNameExtensionFilter filter = new FileNameExtensionFilter(".java 파일", "java");
				fileChooser.setFileFilter(filter);
				fileChooser.setAcceptAllFileFilterUsed(false);
				
				int returnVal = fileChooser.showOpenDialog (EditorEx01.this);
			    if (returnVal == JFileChooser.APPROVE_OPTION) {
			       System.out.println ( "이 파일을 열도록 선택했습니다 :" + fileChooser.getSelectedFile().getName());
			       
			       String fPath = fileChooser.getSelectedFile().getAbsolutePath();
			       
			       textArea.setText(readJavaFile(fPath));
			    }
			}
		});
		btn1.setBounds(12, 10, 113, 23);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("자바 파일 저장");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser("c:\\");
				FileNameExtensionFilter filter = new FileNameExtensionFilter(".java 파일", "java");
				fileChooser.setFileFilter(filter);
				fileChooser.setAcceptAllFileFilterUsed(false);
				
				int returnVal = fileChooser.showSaveDialog(EditorEx01.this);
			    if (returnVal == JFileChooser.APPROVE_OPTION) {
				       System.out.println ( "이 파일을 저장하도록 했습니다 :" + fileChooser.getSelectedFile().getName());
				       
				       File cdir = new File("c:\\");
				       System.out.println(cdir.isDirectory());
				       System.out.println(cdir.canWrite());
				       
				       String fPath = fileChooser.getSelectedFile().getPath();
				       System.out.println(fPath);
				       
//				       AccessController.checkPermission(new FilePermission(fPath, "write"));
//				       fPath = fPath.concat(".java");
//				       
//				       System.out.println(fPath);
//				       
				       boolean isSave = EditorEx01.this.saveJavaFile(fPath, textArea.getText());

//				       if(isSave) {
//				    	   JOptionPane.showMessageDialog(EditorEx01.this, "저장완료");
//				       } else {
//				    	   JOptionPane.showMessageDialog(EditorEx01.this, "저장실패", "Error", JOptionPane.ERROR_MESSAGE);
//				       }
				    	   
			   	}				
			}
		});
		btn2.setBounds(137, 10, 113, 23);
		contentPane.add(btn2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 43, 770, 519);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
	
	public String readJavaFile(String fPath)
	{
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fPath),"UTF8"));) {
			
			String dataString = null;
			StringBuilder sb = new StringBuilder("");
			
			while((dataString = br.readLine()) != null ) {
//				System.out.println(dataString);				
				sb.append(dataString + "\n");
			}
			
			return sb.toString();
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return null;		
	}
	
	public boolean saveJavaFile(String fPath, String writeValue)
	{

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fPath))) {
			
			bw.write(writeValue);
			
			return true;
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//		catch(FileNotFoundException e) {
//			System.out.println("보안");
//		}
		
		return false;
	}
}
