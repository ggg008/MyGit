package models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ClientFileInfoModel extends AbstractTableModel
{
	private static ClientFileInfoModel cfim = null;
	
	
	ArrayList<FileInfoTO> fileDatas = new ArrayList<FileInfoTO>();
	
	private String[] fileNames = {
			"파일이름", "다운로드횟수", "업로드날짜"
	};
	
	boolean[] columnEditables = new boolean[] {
			false, false, false, false, false
	};

	private ClientFileInfoModel()
	{
		// TODO Auto-generated constructor stub
	}
	
	public static ClientFileInfoModel getInstance()
	{	
		if(cfim == null)
			cfim = new ClientFileInfoModel();
	
		return cfim;
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
