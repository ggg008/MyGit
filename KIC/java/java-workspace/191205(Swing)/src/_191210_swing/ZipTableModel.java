package _191210_swing;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ZipTableModel extends AbstractTableModel
{
	private ArrayList<ZipTO> datas = null;
	private String[] columnNames = {"zipcode", "sido", "gugun", "dong", "ri", "bunji", "seq"};
	
	public ZipTableModel()
	{
		// TODO Auto-generated constructor stub
		ZipDAO dao = new ZipDAO();
		datas = dao.selectZip();
		
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
		
		ZipTO to = datas.get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			result = to.getZipcode();
			break;
		case 1:
			result = to.getSido();			
			break;
		case 2:
			result = to.getGugun();	
			break;
		case 3:
			result = to.getDong();	
			break;
		case 4:
			result = to.getRi();	
			break;
		case 5:
			result = to.getBunji();
			break;
		case 6:
			result = to.getSeq();	
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
		return this.columnNames[column];
	}

}
