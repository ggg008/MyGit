package _191209_swing;

import javax.swing.table.AbstractTableModel;

public class CustomTableModel extends AbstractTableModel
{
	private String[][] datas = null;
	
	private String[] names = {
			"XX11", "XXXC", "New column", "New column", "New column"
	};

	public CustomTableModel()
	{
		// TODO Auto-generated constructor stub
		datas = new String[][]{
			{"1", "2", "3", "4", "5"},
			{"6", "7", "8", "9", "10"},
			{"11", "12", "13", "14", "15"},
			{"16", "17", "18", "19", "20"},
			{"21", "22", "23", "24", "25"},
		};
	}
	
	
	@Override
	public int getRowCount()
	{
		// TODO Auto-generated method stub
		return datas.length;
	}

	@Override
	public int getColumnCount()
	{
		// TODO Auto-generated method stub
		return datas[0].length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		// TODO Auto-generated method stub
		return datas[rowIndex][columnIndex];
	}


	@Override
	public String getColumnName(int column)
	{
		// TODO Auto-generated method stub
		return names[column];
	}

}
