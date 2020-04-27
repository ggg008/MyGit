package guis;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import content.MyClassStudentContent;
import content.MyClassTeacherContent;
import models.StudentInfoTO;



public class StudentInfoView extends JDialog
{
	public static final int INFO_JOIN = 0;
	public static final int INFO_EDIT_STUDENT = 1;
	public static final int INFO_EDIT_SUPERMANAGER = 2;
	public static final int INFO_DETAILVIEW_SUPERMANAGER = 3;
	public static final int INFO_VIEW_STUDENT = 4;
	
	
	private int infoType = -1;
	
	private StudentInfoTO tempTo = null;

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldID;
	private JTextField textFieldAddress;
	private JTextField textFieldPhone;
	private JTextField textFieldJumin;
	private JTextField textFieldName;
	private JTextArea textAreaPS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try {
			StudentInfoView dialog = new StudentInfoView(StudentInfoView.INFO_EDIT_SUPERMANAGER, null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StudentInfoView(int infoType, StudentInfoTO info, JFrame mainView)
	{
		this.tempTo = info;
		String title = "";
		int height = 382;
		
		this.infoType = infoType;
		
		
		setResizable(false);
		setBounds(100, 100, 236, 382);
		
				
		Toolkit tk = Toolkit.getDefaultToolkit(); // 구현된 Toolkit 객체 를 얻는다.
		Dimension screenSize = tk.getScreenSize(); // 화면의 크기를 구한다.
		setLocation(screenSize.width/2 - this.getWidth()/2, screenSize.height/2 - this.getHeight()/2);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(41, 10, 179, 31);
			contentPanel.add(panel);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel lblNewLabel = new JLabel("아이디 : ");
				panel.add(lblNewLabel);
				lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
			}
			{
				textFieldID = new JTextField();
				panel.add(textFieldID);
				textFieldID.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(53, 46, 167, 31);
			contentPanel.add(panel);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel label = new JLabel("이름 : ");
				label.setHorizontalAlignment(SwingConstants.LEFT);
				panel.add(label);
			}
			{
				textFieldName = new JTextField();
				textFieldName.setColumns(10);
				panel.add(textFieldName);
			}
		}
		{
			JPanel panelJumin = new JPanel();
			panelJumin.setEnabled(false);
			panelJumin.setBounds(5, 82, 215, 31);
			contentPanel.add(panelJumin);
			panelJumin.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel label = new JLabel("주민등록번호 : ");
				label.setHorizontalAlignment(SwingConstants.LEFT);
				panelJumin.add(label);
			}
			{
				textFieldJumin = new JTextField();
				textFieldJumin.setColumns(10);
				panelJumin.add(textFieldJumin);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(29, 118, 191, 31);
			contentPanel.add(panel);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel label = new JLabel("전화번호 : ");
				label.setHorizontalAlignment(SwingConstants.LEFT);
				panel.add(label);
			}
			{
				textFieldPhone = new JTextField();
				textFieldPhone.setColumns(10);
				panel.add(textFieldPhone);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(53, 154, 167, 31);
			contentPanel.add(panel);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel label = new JLabel("주소 : ");
				label.setHorizontalAlignment(SwingConstants.LEFT);
				panel.add(label);
			}
			{
				textFieldAddress = new JTextField();
				textFieldAddress.setColumns(10);
				panel.add(textFieldAddress);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(12, 221, 208, 89);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel label = new JLabel("비고사항 : ");
				label.setBounds(22, 11, 60, 15);
				label.setHorizontalAlignment(SwingConstants.LEFT);
				panel.add(label);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(86, 6, 116, 73);
				panel.add(scrollPane);
				{
					textAreaPS = new JTextArea();
					textAreaPS.setLineWrap(true);
					scrollPane.setViewportView(textAreaPS);
				}
			}
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 202, 208, 2);
		contentPanel.add(separator);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("완료");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						
						StudentInfoTO newTo = new StudentInfoTO();
						var siView = StudentInfoView.this;
						
						newTo.setStuID(siView.textFieldID.getText());
						newTo.setName(siView.textFieldName.getText());
						newTo.setJumin(siView.textFieldJumin.getText());
						newTo.setPhoneNumber(siView.textFieldPhone.getText());
						newTo.setHomeAddress(siView.textFieldAddress.getText());
						newTo.setPs(siView.textAreaPS.getText());
						
						
						if(StudentInfoView.this.infoType == INFO_EDIT_SUPERMANAGER) {							
							MyClassTeacherContent.setStuInfo(newTo);
						} else if(StudentInfoView.this.infoType == INFO_JOIN) {							
							MyClassStudentContent.reqSetJoinMyInfo(newTo);
							return;
						}  else if(StudentInfoView.this.infoType == INFO_EDIT_STUDENT) {							
							MyClassStudentContent.reqSetMyInfo(newTo);
						} 
						
						
						StudentInfoView.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("취소");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						StudentInfoView.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		if(tempTo != null) {
			textFieldID.setText(this.tempTo.getStuID());
			textFieldName.setText(this.tempTo.getName());
			textFieldJumin.setText(this.tempTo.getJumin());
			textFieldPhone.setText(this.tempTo.getPhoneNumber());
			textFieldAddress.setText(this.tempTo.getHomeAddress());
			textAreaPS.setText(this.tempTo.getPs());
		}
		
		textFieldID.setEditable(true);
		textFieldName.setEditable(true);
		textFieldJumin.setEditable(true);
		textFieldPhone.setEditable(true);
		textFieldAddress.setEditable(true);
		textAreaPS.setEditable(true);

		
		
		switch (this.infoType) {
		case INFO_JOIN:
			title = "가입정보입력";
			height = 265;
			break;
		case INFO_EDIT_STUDENT:
			title = "내정보수정";
			height = 265;
			textFieldID.setEditable(false);
			textFieldJumin.setEditable(false);
			textAreaPS.setEditable(false);
			break;			
		case INFO_EDIT_SUPERMANAGER:
			title = "학생정보수정";
			height = 382;
			textFieldJumin.setEditable(true);
			break;			
		case INFO_VIEW_STUDENT:
			title = "학생정보";
			height = 265;
			
			textFieldID.setEditable(false);
			textFieldName.setEditable(false);
			textFieldJumin.setEditable(false);	
			
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < textFieldJumin.getText().length(); ++i) {
				sb.append("*");
			}
			textFieldJumin.setText(sb.toString());			
			
			textFieldPhone.setEditable(false);
			textFieldAddress.setEditable(false);
			textAreaPS.setEditable(false);
			
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.infoType);
		}
		
		setTitle(title);
		setSize(this.getWidth(), height);
		if(mainView != null)
			setLocation(mainView.getX() + mainView.getWidth()/2 - this.getWidth()/2, mainView.getY() + mainView.getHeight()/2 - this.getHeight()/2);
		
	}
}

