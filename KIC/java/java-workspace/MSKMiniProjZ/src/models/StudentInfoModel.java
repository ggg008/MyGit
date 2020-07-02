package models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class StudentInfoModel extends AbstractTableModel
{
	private static StudentInfoModel sim = null;
	
	private ArrayList<StudentInfoTO> datas = new ArrayList<StudentInfoTO>();
	
	private String[] namesTeacher = {
			"번호", "아이디", "이름", "주민등록번호", "전화번호", "비고", "접속여부", "가입일자", "집주소", "ip"
	};
	
	boolean[] columnEditables = new boolean[] {
			false, false, false, false, false, false, false, false, false, false, false
	};

	private StudentInfoModel()
	{
		// TODO Auto-generated constructor stub
	}
	
	public static StudentInfoModel getInstance()
	{	
		if(sim == null)
			sim = new StudentInfoModel();
	
		sim.resetModel();
		return sim;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		// TODO Auto-generated method stub
		
		String result = "";
		
		StudentInfoTO to = datas.get(rowIndex);
		String name = this.getColumnName(columnIndex);
		
		switch (name) {
		case "번호":
			result = String.valueOf(to.getStuNum());
			break;
		case "아이디":
			result = to.getStuID();			
			break;
		case "이름":
			result = to.getName();	
			break;
		case "주민등록번호":
			result = to.getJumin();	
			break;
		case "비고":
			result = to.getPs();	
			break;
		case "집주소":
			result = to.getHomeAddress();
			break;
		case "전화번호":
			result = to.getPhoneNumber();	
			break;
		case "가입일자":
			result = to.getJoinDate();	
			break;
		case "ip":
			result = to.getIpAddress();	
			break;
		case "접속여부":
			result = to.isConnect() ? "O" : "X";	
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
		
		return result;
	}
	
	@Override
	public int getRowCount()
	{
		// TODO Auto-generated method stub
		return datas.size();
	}

	@Override
	public int getColumnCount()
	{
		// TODO Auto-generated method stub
		return namesTeacher.length;
	}


	@Override
	public String getColumnName(int column)
	{
		// TODO Auto-generated method stub
		return namesTeacher[column];
	}
	
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}
	
	public void resetModel()
	{
		StudentInfoDAO dao = new StudentInfoDAO(); 
		ArrayList<StudentInfoTO> list = dao.selectStuInfos();
		
		if(datas == null || datas.size() <= 0) {
			datas = list;
		} else {
			for(StudentInfoTO to : list) {
				StudentInfoTO existTo = this.getStudentInfo(to.getStuID());
				if(existTo != null) {
					existTo.setStudentInfoTO(to);
				} else {
					datas.add(to);
				}
				
			}
		}
		
		int number = 0;
		for(StudentInfoTO to : datas) {
			to.setStuNum(++number);
		}
	}
	
	public void setData(StudentInfoTO setTo)
	{
		for(StudentInfoTO to : datas) {
			if(to.getJumin() == setTo.getJumin()) {
				to = setTo;
			}
		}
			
	}
	
	public StudentInfoTO getRow(int idx)
	{
		return datas.get(idx);
	}
	
	public ArrayList<StudentInfoTO> getDatas()
	{
		return datas;
	}
	
	public StudentInfoTO getStudentInfo(String userID)
	{
		for(StudentInfoTO to : datas){
			if(to.getStuID().equals(userID))
				return to;
		}
		return null;
	}
}
