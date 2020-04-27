package content;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import java.util.Set;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import guis.StudentInfoView;
import guis.StudentLoginView;
import guis.StudentMainView;
import models.ClientFileInfoModel;
import models.ClientStudentInfoModel;
import models.FileInfoTO;
import models.StudentInfoTO;

public class MyClassStudentContent
{   
	public static void main(String[] args)
	{
		StudentLoginView.getInstance().setVisible(true);
		MyClassCilent.getInstance();
	}
	
	public static void failConnetion()
	{
		var result = JOptionPane.showConfirmDialog(StudentLoginView.getInstance(), "서버에 연결 실패", "메세지", JOptionPane.CLOSED_OPTION);
		
		if(0 <= result) {
			StudentLoginView.getInstance().dispose();
		}

	}
	
	public static void recvErrMsg(String errmsg)
	{
		errmsg = errmsg.replaceAll(MyClassEnums.hrErrJoin, "");
		
		JOptionPane.showConfirmDialog(StudentLoginView.getInstance().getJoinView(), errmsg, "메세지", JOptionPane.CLOSED_OPTION);
		

	}
	
	public static void recvSuccessMsg(String msg)
	{
		msg = msg.replaceAll(MyClassEnums.hrSucJoin, "");
		
		int result = JOptionPane.showConfirmDialog(StudentLoginView.getInstance().getJoinView(), msg, "메세지", JOptionPane.CLOSED_OPTION);
		
		if(0 <= result) {
			var joinView =  StudentLoginView.getInstance().getJoinView();
			if(joinView != null)
				joinView.dispose();
		}
	}
	
	
    public static void reqLogin(String stuID)
    {	
    	
    	MyClassCilent.getInstance().reqLogin(stuID);
    } 
    
    public static void failLogin(String msg)
    {
    	msg = msg.replaceAll(MyClassEnums.hrFailLogin, "");
    	
    	JOptionPane.showMessageDialog(StudentLoginView.getInstance(), msg, "메세지", JOptionPane.CLOSED_OPTION);
    } 
    
    public static void successLogin(String msg)
    {
    	msg = msg.replaceAll(MyClassEnums.hrSucLogin, "");
    	
    	MyClassCilent.getInstance().setName(msg);
    	
    	StudentLoginView.getInstance().dispose();
    	StudentMainView.getInstance().setVisible(true);
    }
    
    public static void reqFileDownload(FileInfoTO reqFileTo)
    {	
    	MyClassCilent.getInstance().reqDownloadFile(reqFileTo);
    } 
    
    public static void recvFileList(String infos)
	{
    	var datas = ClientFileInfoModel.getInstance().getDatas();
		datas.clear();
		
		String[] strArray = infos.split(MyClassEnums.hrFileList);
		
		for(String str : strArray) {

			if(str.equals(""))
				continue;
			
			var sr = new StringReader(str);
			
			Properties props = new Properties();
			try {
				props.load(sr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Set<String> keys = props.stringPropertyNames();
			for (String key : keys) {
				System.out.println(key + " : " + props.getProperty(key));
			}
			
			FileInfoTO to = new FileInfoTO(props);
//			System.out.println("추가 === " + to.getFileName());
			datas.add(to);
		}
		
		MyClassStudentContent.resetSMVFileTable();
	} 
    
    public static void recvTeacherMessage(String msg)
    {
    	msg = msg.replaceAll(MyClassEnums.hrTeacherMsg, "");
    	
    	StudentMainView.getInstance().setTextArea(msg);
    } 
    
    public static void reqFirstWriteMyInfo()
    {
//    	System.out.println("가입신청");
    	StudentInfoView dialog = new StudentInfoView(StudentInfoView.INFO_JOIN, null, StudentLoginView.getInstance());
    	StudentLoginView.getInstance().setJoinView(dialog);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setModal(true);
		dialog.setVisible(true);
		
    } 
    
    public static void reqSetJoinMyInfo(StudentInfoTO joinTo)
    {	
    	MyClassCilent.getInstance().reqSetJoinMyInfo(joinTo);
    } 
    
    public static void showMyInfo()
    {	
    	StudentInfoTO myInfo = ClientStudentInfoModel.getInstance().getStudentInfo(MyClassCilent.getInstance().getName());

    	StudentInfoView dialog = new StudentInfoView(StudentInfoView.INFO_EDIT_STUDENT, myInfo, StudentMainView.getInstance());
    	StudentLoginView.getInstance().setJoinView(dialog);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setModal(true);
		dialog.setVisible(true);
    } 
	
    public static void showStuInfo(int selIndex)
	{
//		System.out.println("call infoChange : " + selIndex );
    	
    	ClientStudentInfoModel csim = ClientStudentInfoModel.getInstance();
    	
		StudentInfoView dialog = new StudentInfoView(StudentInfoView.INFO_VIEW_STUDENT, csim.getRow(selIndex), StudentMainView.getInstance());
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setModal(true);
		dialog.setVisible(true);
		
	}
    
    public static void reqSetMyInfo(StudentInfoTO changedTo)
    {
    	MyClassCilent.getInstance().reqChangeMyInfo(changedTo);    	
    } 
	
	public static void resetSMVStuTable()
	{
		StudentMainView.getInstance().refreshStuTable();
	}
	
	public static void resetSMVFileTable()
	{
		StudentMainView.getInstance().refreshFileTable();
	}
	
	public static void recvClientModelStuInfo(String infos)
	{	
		var datas = ClientStudentInfoModel.getInstance().getDatas();
		datas.clear();
		
		String[] strArray = infos.split(MyClassEnums.hrClientStudents);
		
		int number = 0;
		for(String str : strArray) {

			if(str.equals(""))
				continue;
			
			var sr = new StringReader(str);
			
			Properties props = new Properties();
			try {
				props.load(sr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			Set<String> keys = props.stringPropertyNames();
//			for (String key : keys) {
//				System.out.println(key + " : " + props.getProperty(key));
//			}
			
			StudentInfoTO to = new StudentInfoTO(props);
			to.setStuNum(++number);
			datas.add(to);
		}
		
		MyClassStudentContent.resetSMVStuTable();
	}
	
	public static void openDownloadFolder()
	{	
		var path =  MyClassCilent.getInstance().getDownDir();
		path =  path.replaceAll("/", "\\\\");
		
		System.out.println(path);
		
		File checkDir = new File(path);
		if(!checkDir.exists()) {
			System.out.println("없는파일");
			checkDir.mkdirs();
		}

		ProcessBuilder p2 = new ProcessBuilder("explorer.exe", path);

		try {
			p2.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    
}
