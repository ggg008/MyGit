package _191209_swing;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class CustomComboBoxModel2 extends DefaultComboBoxModel<String>
{
	private ArrayList<String> datas = null;
	
	public CustomComboBoxModel2()
	{
		datas = new ArrayList<String>();
		datas.add("사과");
		datas.add("수박");
		datas.add("딸기");
		datas.add("키위");		
	}

	@Override
	public int getSize()
	{
		// TODO Auto-generated method stub
		System.out.println("getSize() 호출");
		return datas.size();
	}

	@Override
	public String getElementAt(int index)
	{
		// TODO Auto-generated method stub
		System.out.println("getElementAt() 호출");		
		return datas.get(index);
	}
	
	
}
