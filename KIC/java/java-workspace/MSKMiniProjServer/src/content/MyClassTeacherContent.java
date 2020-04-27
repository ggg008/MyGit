package content;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import guis.StudentInfoView;
import guis.TeacherMainView;
import models.FileInfoDAO;
import models.FileInfoModel;
import models.FileInfoTO;
import models.JoinStudentInfoDAO;
import models.JoinStudentInfoModel;
import models.MsgDAO;
import models.StudentInfoDAO;
import models.StudentInfoModel;
import models.StudentInfoTO;

public class MyClassTeacherContent
{
	public static void main(String[] args)
	{
		TeacherMainView.getInstance().setVisible(true);
		MyClassServer.getInstance();
	}
	
    public static void showStuInfo(int selIndex)
	{
//		System.out.println("call infoChange : " + selIndex );
    	
    	StudentInfoModel sim = StudentInfoModel.getInstance();
    	
		StudentInfoView dialog = new StudentInfoView(StudentInfoView.INFO_EDIT_SUPERMANAGER, sim.getRow(selIndex), TeacherMainView.getInstance());
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setModal(true);
		dialog.setVisible(true);
		
	}
    
    public static void kickStudent(int selIndex)
	{
//		System.out.println("call kickHim : " + selIndex );

    	var delTo = StudentInfoModel.getInstance().getRow(selIndex);
    	
    		
    	
		int result = JOptionPane.showConfirmDialog(TeacherMainView.getInstance(), "정말 삭제하시겠습니까?", "메세지", JOptionPane.OK_CANCEL_OPTION);

		
		if(result == JOptionPane.YES_OPTION) {

	    	if(delTo != null && delTo.isConnect()) {
	    		JOptionPane.showMessageDialog(TeacherMainView.getInstance(), "접속중인 학생은 삭제할수 없습니다!", "메세지", JOptionPane.ERROR_MESSAGE);
	    		return;
	    	}
			if(delTo != null) {
				StudentInfoDAO dao = new StudentInfoDAO();
				dao.deleteStuInfo(delTo);
			}
		}
		
	}
    
    public static String insertJoinStuInfo(StudentInfoTO joinTo)
    {
    	var jstuModel = JoinStudentInfoModel.getInstance();
    	var stuModel = StudentInfoModel.getInstance();
    	
    	for(int i = 0; i < jstuModel.getRowCount(); ++i) {
    		var row = jstuModel.getRow(i);
    		if( row.getStuID().equals(joinTo.getStuID()) ) {
    			return "이미있는 아이디입니다";
    		} else if( row.getJumin().equals(joinTo.getJumin()) ) {
    			return "이미있는 주민번호입니다";
    		}	
    	}

    	for(int i = 0; i < stuModel.getRowCount(); ++i) {
    		var row = stuModel.getRow(i);
    		if( row.getStuID().equals(joinTo.getStuID()) ) {
    			return "이미있는 아이디입니다";
    		} else if( row.getJumin().equals(joinTo.getJumin()) ) {
    			return "이미있는 주민번호입니다";
    		}	
    	}
    	
    	JoinStudentInfoDAO dao = new JoinStudentInfoDAO();
    	dao.insertJoinStuInfo(joinTo);
    	
    	return "";
    }
	
	public static void setStuInfo(StudentInfoTO to)
	{
		StudentInfoDAO dao = new StudentInfoDAO();
		dao.updateStuInfo(to);
	}
	
	public static void setSimpleStuInfo(StudentInfoTO to)
	{
		StudentInfoDAO dao = new StudentInfoDAO();
		dao.updateSimpleStuInfo(to);
	}
	
	public static void resetTMVStuTable()
	{
		TeacherMainView.getInstance().refreshStuTable();
	}
	
	public static void resetFileTable()
	{
		TeacherMainView.getInstance().refreshfileTable();
	}

	public static void sendStuInfoList(ArrayList<StudentInfoTO> stus)
    {	
    	StringBuffer sb = new StringBuffer();
		for(StudentInfoTO stu : stus) {
	    	String info = String.format(MyClassEnums.hrClientStudents + "\n stuNum=%s\n stuID=%s\n name=%s\n jumin=%s\n phoneNumber=%s\n isConnect=%b\n homeAddress=%s\n ipAddress=%s\n joinDate=%s\n ps=%s\n",
	    			stu.getStuNum(), stu.getStuID(), stu.getName(), stu.getJumin(), stu.getPhoneNumber(), stu.isConnect(), stu.getHomeAddress(), stu.getIpAddress(), stu.getJoinDate(), stu.getPs());
	    	sb.append(info);
    	}
    	MyClassServer.getInstance().sendToAll(sb.toString());
    } 

	public static void sendFileInfoList(ArrayList<FileInfoTO> filelists)
    {	
    	StringBuffer sb = new StringBuffer();
		for(FileInfoTO fl : filelists) {
	    	String info = String.format(MyClassEnums.hrFileList + "\n fileKey=%d\n fileName=%s\n downloadNum=%s\n uploadDate=%s\n",
	    			fl.getFileKey(), fl.getFileName(), fl.getDownloadNum(), fl.getUploadDate());
	    	sb.append(info);
    	}
    	MyClassServer.getInstance().sendToAll(sb.toString());
    } 
	
	public static void sendFile(int fileKey, String userID )
	{
		FileInfoModel.getInstance().resetModel();
		var fileInfo = FileInfoModel.getInstance().getFileInfoByKey(fileKey);
		
		
		File sendFile = new File(fileInfo.getFileFullPath());
		
//		System.out.println("파일의 바이트 크기 : " + sendFile.length());
		
		String msg = String.format("%s\n%s\n%s\n", MyClassEnums.hrFileDown, "fileName="+ sendFile.getName(), "fileSize="+sendFile.length());
		
		MyClassServer.getInstance().sendMsg(userID, msg);
		
		try {
			MyClassServer.getInstance().sendFile(userID, new DataInputStream(new FileInputStream(sendFile)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		fileInfo.setDownloadNum( String.valueOf(Integer.parseInt(fileInfo.getDownloadNum()) + 1) );
		FileInfoDAO dao = new FileInfoDAO();
		dao.updateFileInfo(fileInfo);
		
//		System.out.println(sendFile.exists());
		
//		File sendFile = new FileInputStream(sendFile);
		
//		var sendFile = new DataInputStream();
//		if(sendFile.)
		
//		BufferedInputStream bis = new DataInputStream(new FileInputStream(file));
	}
	
	public static void approveJoinStu(int selIdx)
	{
		var jsim = JoinStudentInfoModel.getInstance();
		StudentInfoTO jstu = jsim.getRow(selIdx);
		 
		StudentInfoDAO dao = new StudentInfoDAO();
		dao.insertStuInfo(jstu);
		
		JoinStudentInfoDAO jdao = new JoinStudentInfoDAO();
		jdao.deleteJoinStuInfo(jstu);
		
		JoinStudentInfoModel.getInstance();
		StudentInfoModel.getInstance();
	}
	
	public static void unapproveJoinStu(int selIdx)
	{
		var jsim = JoinStudentInfoModel.getInstance();
		StudentInfoTO jstu = jsim.getRow(selIdx);
		 
		JoinStudentInfoDAO jdao = new JoinStudentInfoDAO();
		jdao.deleteJoinStuInfo(jstu);
		
		JoinStudentInfoModel.getInstance();
	}
	
	public static void logoutUser(String userName)
	{
		var sim = StudentInfoModel.getInstance();
		for(int i = 0; i < sim.getRowCount(); ++i) {
			if(sim.getRow(i).getStuID().equals(userName)) {
				sim.getRow(i).setConnect(false);
				MyClassTeacherContent.resetTMVStuTable();
				return;
			}
		}
			
	}
	
	public static void sendTeacherMsg()
	{
		String teacherMsg = TeacherMainView.getInstance().getTextAreaText();
		
		teacherMsg = MyClassEnums.hrTeacherMsg + teacherMsg;
//		System.out.println("================================================"+teacherMsg);
		MyClassServer.getInstance().sendToAll(teacherMsg);
	}
	
	public static String loadTeacherMsg()
	{
		MsgDAO dao = new MsgDAO();
		
		return dao.loadTeacherMsg();
	}
	
	public static void saveTeacherMsg()
	{
		MsgDAO dao = new MsgDAO();
		
		dao.saveTeacherMsg(TeacherMainView.getInstance().getTextAreaText());
	}
	
	
	public static void uploadFileList(File file)
	{
		var fim = FileInfoModel.getInstance();

		String path = file.getAbsolutePath();

		path = path.substring(0, 1).toUpperCase() + path.substring(1);
		
		var existFile = fim.getFileInfo(path);
		
		if(existFile != null) {
			JOptionPane.showMessageDialog(TeacherMainView.getInstance(), "이미 업로드된 파일입니다", "메세지", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		FileInfoTO newFileInfo = new FileInfoTO();
		
		int unusedKey = 0;
		for(int keyFinder = 0; keyFinder < fim.getRowCount() + 1; ++keyFinder) {
			FileInfoTO haveKeyFile = fim.getFileInfoByKey(keyFinder);
			if(haveKeyFile == null) {
				unusedKey = keyFinder;
				break;
			}
		}
		
		newFileInfo.setFileKey(unusedKey);
		
		
		
		newFileInfo.setFileFullPath(path);
		newFileInfo.setFileName(file.getName());
		
		String uploadDate = String.format("%d-%d-%d", 
				Calendar.getInstance().get(Calendar.YEAR), 
				Calendar.getInstance().get(Calendar.MONTH), 
				Calendar.getInstance().get(Calendar.DAY_OF_MONTH) 
				);
		newFileInfo.setUploadDate(uploadDate);
		newFileInfo.setDownloadNum(String.valueOf(0));
		
		FileInfoDAO dao = new FileInfoDAO();
		dao.insertFileInfo(newFileInfo);	
		FileInfoModel.getInstance();
	}
	
	public static void deleteFileList(int selIdx)
	{
		if(selIdx == -1)
			return;
		
		var row = FileInfoModel.getInstance().getFileInfo(selIdx);
		if(row == null) {
			JOptionPane.showMessageDialog(TeacherMainView.getInstance(), "존재하지않는 파일입니다", "메세지", JOptionPane.WARNING_MESSAGE);
			return;
		}		
		
		var existFile = FileInfoModel.getInstance().getFileInfoByKey(row.getFileKey());
		if(existFile == null) {
			JOptionPane.showMessageDialog(TeacherMainView.getInstance(), "존재하지않는 파일입니다", "메세지", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		FileInfoDAO dao = new FileInfoDAO();
		dao.deleteFileInfo(existFile);	
	}
	
	
}
