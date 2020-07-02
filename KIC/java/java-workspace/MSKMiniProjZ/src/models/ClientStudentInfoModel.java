package models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class ClientStudentInfoModel extends AbstractTableModel
{
	private static ClientStudentInfoModel sim = null;
	
	private ArrayList<StudentInfoTO> datas = null;
	
	private String[] names = {
			"번호", "이름", "전화번호", "접속여부", "가입일자", "집주소", "ip"
	};
	
	boolean[] columnEditables = new boolean[] {
			false, false, false, false, false, false, false
	};

	private ClientStudentInfoModel()
	{
		// TODO Auto-generated constructor stub
		datas = new ArrayList<StudentInfoTO>();
	}
	
	public static ClientStudentInfoModel getInstance()
	{	
		if(sim == null)
			sim = new ClientStudentInfoModel();
	
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
		return names.length;
	}


	@Override
	public String getColumnName(int column)
	{
		// TODO Auto-generated method stub
		return names[column];
	}
	
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
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
