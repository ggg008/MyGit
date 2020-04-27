package _191210_swing;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class EmpTableModel extends AbstractTableModel
{
	//*추상클래스는 자식으로 완성된다
	// JTable - 2차원 구조
	// 2차원 배열
	// == ArrayList<ArrayList>
	// == ArrayList<TO>
	
	private ArrayList<EmpTO> datas = null;
	private String[] columnNames = {"empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno"};
	
	public EmpTableModel()
	{
		// TODO Auto-generated constructor stub
		// 가상데이터		
//		datas = new ArrayList<EmpTO>();
//		EmpTO to = new EmpTO();
//		to.setEmpno("7369");
//		to.setEname("SMITH");
//		to.setJob("CLERK");
//		to.setMgr("7902");
//		to.setHiredate("2010-12-17");
//		to.setSal("800.00");
//		to.setComm("");
//		to.setDeptno("20");
//		
//		datas.add(to);		
		

		EmpDAO dao = new EmpDAO();
		datas = dao.selectEmp();
		
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
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		// TODO Auto-generated method stub
		
		String result = "";
		
		EmpTO to = datas.get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			result = to.getEmpno();
			break;
		case 1:
			result = to.getEname();			
			break;
		case 2:
			result = to.getJob();	
			break;
		case 3:
			result = to.getMgr();	
			break;
		case 4:
			result = to.getHiredate();	
			break;
		case 5:
			result = to.getSal();
			break;
		case 6:
			result = to.getComm();	
			break;
		case 7:
			result = to.getDeptno();	
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
		return columnNames[column];
	}

}
