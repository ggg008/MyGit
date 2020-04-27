package _191209_swing;

import java.util.Vector;

import javax.swing.DefaultComboBoxModel;

public class ZipSearchComboBoxModel extends DefaultComboBoxModel<String>
{
	private Vector<String> datas;
	
	public ZipSearchComboBoxModel(String strDong)
	{
		ZipSearchDAO dao = new ZipSearchDAO();
		datas = new Vector<String>(dao.searchZips(strDong));
	}
	
	@Override
	public int getSize()
	{
		// TODO Auto-generated method stub
		System.out.println("getSize()");
		return datas.size();
	}

	@Override
	public String getElementAt(int index)
	{
		// TODO Auto-generated method stub
		System.out.println("getElementAt()");
		return datas.get(index);
	}
	
}
