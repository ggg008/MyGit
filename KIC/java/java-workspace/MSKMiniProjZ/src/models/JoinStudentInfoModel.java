package models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class JoinStudentInfoModel extends AbstractTableModel
{
	private static JoinStudentInfoModel jsim = null;
	
	private ArrayList<StudentInfoTO> datas = null;
	
	private String[] names = {
			"번호", "아이디", "이름", "주민등록번호", "전화번호", "집주소", "신청일자"
	};
	
	boolean[] columnEditables = new boolean[] {
			false, false, false, false, false, false, false, false
	};

	private JoinStudentInfoModel()
	{
		// TODO Auto-generated constructor stub
	}
	
	public static JoinStudentInfoModel getInstance()
	{
		if(jsim == null)
			jsim = new JoinStudentInfoModel();
	
		jsim.resetModel();
		return jsim;
	}
	
	public void resetModel()
	{
		JoinStudentInfoDAO dao = new JoinStudentInfoDAO(); 
		datas = dao.selectJoinStuInfos();
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
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		// TODO Auto-generated method stub
		
		String result = "";
		
		StudentInfoTO to = datas.get(rowIndex);
		
		var name = getColumnName(columnIndex);
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
		case "전화번호":
			result = to.getPhoneNumber();	
			break;
		case "집주소":
			result = to.getHomeAddress();
			break;
		case "비고":
			result = to.getPs();	
			break;
		case "신청일자":
			result = to.getJoinDate();	
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
		
		return result;
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
}
