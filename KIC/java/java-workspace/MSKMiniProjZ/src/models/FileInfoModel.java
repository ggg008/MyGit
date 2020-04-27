package models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class FileInfoModel extends AbstractTableModel
{
	private static FileInfoModel fim = null;
	
	
	ArrayList<FileInfoTO> fileDatas = new ArrayList<FileInfoTO>();
	
	private String[] fileNames = {
			"파일경로", "파일이름", "다운로드횟수", "업로드날짜"
	};
	
	boolean[] columnEditables = new boolean[] {
			false, false, false, false, false
	};

	private FileInfoModel()
	{
		// TODO Auto-generated constructor stub
		this.resetModel();
	}
	
	public static FileInfoModel getInstance()
	{	
		if(fim == null)
			fim = new FileInfoModel();
		
		return fim;
	}

	@Override
	public int getRowCount()
	{
		// TODO Auto-generated method stub
		return fileDatas.size();
	}

	@Override
	public int getColumnCount()
	{
		// TODO Auto-generated method stub
		return fileNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		String result = "";
		
		FileInfoTO to = fileDatas.get(rowIndex);
		
		var name = getColumnName(columnIndex);
		switch (name) {
		case "key":
			result = String.valueOf(to.getFileKey());
			break;
		case "파일경로":
			result = to.getFileFullPath();
			break;
		case "파일이름":
			result = to.getFileName();			
			break;
		case "다운로드횟수":
			result = to.getDownloadNum();	
			break;
		case "업로드날짜":
			result = to.getUploadDate();	
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
		return fileNames[column];
	}
	
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}
	
	public boolean resetModel()
	{
		boolean isChanged = false;
		FileInfoDAO dao = new FileInfoDAO(); 
		ArrayList<FileInfoTO> delList = new ArrayList<FileInfoTO>();
		
		var list = dao.selectFileInfo(delList);
		ArrayList<FileInfoTO> newList = new ArrayList<FileInfoTO>(); 
		
		if(fileDatas == null || fileDatas.size() <= 0) {
			fileDatas = list;
		} else {
			for(FileInfoTO to : list) {
				var existTo = this.getFileInfoByKey(to.getFileKey());
				if(existTo != null) {
					existTo.setFileInfoTO(to);
					
					newList.add(existTo);
					
				} else {
					newList.add(to);
					isChanged = true;
				}
				
			}
		}	
		
		if(0 < newList.size()) {
			fileDatas = newList;
		}

		if(0 < delList.size()) {

			System.out.println("deleteFileInfos " + delList.size());
			
			FileInfoDAO dao2 = new FileInfoDAO();
			for(FileInfoTO delinfo : delList) {
				fileDatas.remove(delinfo);
			}
			dao2.deleteFileInfos(delList);
			
			isChanged = true;
		}
		
		return isChanged;
	}

	public FileInfoTO getFileInfo(String fullpath)
	{
		for(FileInfoTO to : fileDatas){
			if(to.getFileFullPath().equals(fullpath))
				return to;
		}
		return null;
	}
	
	public FileInfoTO getFileInfoByKey(int key)
	{
		for(FileInfoTO to : fileDatas){
			if(to.getFileKey() == key)
				return to;
		}
		return null;
	}
	
	public FileInfoTO getFileInfo(int index)
	{
		return fileDatas.get(index);
	}

	public ArrayList<FileInfoTO> getDatas()
	{
		return fileDatas;
	}
	
	

}
