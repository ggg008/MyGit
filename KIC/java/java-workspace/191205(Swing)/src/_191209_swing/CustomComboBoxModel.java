package _191209_swing;

import javax.swing.DefaultComboBoxModel;

public class CustomComboBoxModel extends DefaultComboBoxModel<String>
{
	private String[] datas = null;
	
	public CustomComboBoxModel()
	{
		datas = new String[] {"사과", "수박", "딸기", "키위"};		
	}

	@Override
	public int getSize()
	{
		// TODO Auto-generated method stub
		System.out.println("getSize() 호출");
		return datas.length;
	}

	@Override
	public String getElementAt(int index)
	{
		// TODO Auto-generated method stub
		System.out.println("getElementAt() 호출");		
		return datas[index];
	}
	
	
}
