package guis;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import content.MyClassStudentContent;
import models.ClientFileInfoModel;
import models.ClientStudentInfoModel;

public class StudentMainView extends JFrame
{
	private static StudentMainView smv = null;

	private JPanel contentPane;
	private JTable studentsTable;
	private JTable filesTable;
	private JTabbedPane tabbedPane;
	private JTextArea textArea;
	private JButton btnDownload;
	
	private String downBtnText = "";
	private int mentNum = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					StudentMainView frame = new StudentMainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static StudentMainView getInstance()
	{
		if(smv == null)
			smv = new StudentMainView();
	
		return smv;
	}

	/**
	 * Create the frame.
	 */
	private StudentMainView()
	{
		setTitle("마이클래스");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);

		Toolkit tk = Toolkit.getDefaultToolkit(); // 구현된 Toolkit 객체 를 얻는다.
		Dimension screenSize = tk.getScreenSize(); // 화면의 크기를 구한다.
		setLocation(0, screenSize.height/2 - this.getHeight()/2);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setSelectedIndex(-1);
		tabbedPane.setBounds(0, 20, 622, 422);
		contentPane.add(tabbedPane);
		
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 470, 375);
		panel.add(scrollPane);
		
		studentsTable = new JTable();
		studentsTable.setModel(ClientStudentInfoModel.getInstance());
		studentsTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
//					System.out.println("doubleclick " + studentsTable.getSelectedRow());
					MyClassStudentContent.showStuInfo(studentsTable.getSelectedRow());
				}
			}
		});
		scrollPane.setViewportView(studentsTable);
		
		JButton button = new JButton("내정보수정");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyClassStudentContent.showMyInfo();
			}
		});
		button.setBounds(493, 10, 112, 39);
		panel.add(button);
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 10, 470, 375);
		panel_1.add(scrollPane_1);
		
		filesTable = new JTable();
		filesTable.setModel(ClientFileInfoModel.getInstance());
		scrollPane_1.setViewportView(filesTable);
		
		btnDownload = new JButton("    다운로드");
		btnDownload.setHorizontalAlignment(SwingConstants.LEFT);
		btnDownload.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(filesTable.getSelectedRow() == -1)
					return;
				
				MyClassStudentContent.reqFileDownload(ClientFileInfoModel.getInstance().getFileInfo(filesTable.getSelectedRow()));
			}
		});
		btnDownload.setBounds(493, 10, 112, 39);
		panel_1.add(btnDownload);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 10, 593, 375);
		panel_2.add(scrollPane_2);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane_2.setViewportView(textArea);
		textArea.setLineWrap(true);
        
		
		tabbedPane.setTitleAt(0, "학생목록");
		tabbedPane.setTitleAt(1, "파일보기");
		tabbedPane.setTitleAt(2, "전파메세지");
		
		downBtnText = btnDownload.getText();
		
		studentsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		filesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton button_1 = new JButton("폴더열기");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MyClassStudentContent.openDownloadFolder();
			}
		});
		button_1.setBounds(493, 59, 112, 39);
		panel_1.add(button_1);

	}
    
    public void refreshStuTable()
	{
    	ClientStudentInfoModel.getInstance().fireTableDataChanged();	
	}
    
    public void refreshFileTable()
	{
    	ClientFileInfoModel.getInstance().fireTableDataChanged();	
	}

	public void setTextArea(String text)
	{
		this.textArea.setText(text);
	}
	
	public void setDownloading(boolean isDownloading)
	{
		tabbedPane.setEnabled(!isDownloading);
		btnDownload.setEnabled(!isDownloading);
		
		btnDownload.setText(isDownloading ? downBtnText : downBtnText);
		mentNum = 0;
	}
	
	public void setDownloadMent()
	{
		++mentNum;
		StringBuffer sb = new StringBuffer(downBtnText);
		
		int s = mentNum % 5;
		for (int i = 0; i < s; ++i) {
			sb.append(".");
		}
//		if(mentNum <= 44)
//			mentNum = 0;
		
		
		btnDownload.setText(sb.toString());
	}
}
