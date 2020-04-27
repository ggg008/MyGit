package _191209_swing;

import javax.swing.AbstractListModel;

public class CustomListModel extends AbstractListModel<String>
{
	String[] datas = null;
		
	
	public CustomListModel()
	{
		this.datas = new String[] {"사과", "딸기", "수박", "키위", "딸기", "수박", "키위", "딸기", "수박", "키위"};
	}

	@Override
	public int getSize()
	{
		// TODO Auto-generated method stub
		return datas.length;
	}

	@Override
	public String getElementAt(int index)
	{
		// TODO Auto-generated method stub
		return datas[index];
	}

}
