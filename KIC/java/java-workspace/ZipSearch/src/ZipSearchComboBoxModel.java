import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class ZipSearchComboBoxModel extends DefaultComboBoxModel<String> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> datas;
	
	public ZipSearchComboBoxModel(String strDong) {
		// TODO Auto-generated constructor stub
		ZipSearchDAO dao = new ZipSearchDAO();
		datas = dao.searchZips(strDong);
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return datas.size();
	}
	
	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return datas.get(index);
	}
}
