package com.album.model;

import java.util.ArrayList;

public class AlbumBoardListTO
{
	private int cpage;
	private int recordPerPage;
	private int blockPerPage;
	private int totalPage;
	private int totalRecord;
	private int startBlock;
	private int endBlock;
	
	private ArrayList<AlbumBoardTO> boardLists;
	
	public AlbumBoardListTO()
	{
		this.cpage = 1;
		this.recordPerPage = 10;
		this.blockPerPage = 5;
		this.totalPage = 1;
		this.totalRecord = 0;
	}

	public int getCpage()
	{
		return cpage;
	}

	public void setCpage(int cpage)
	{
		this.cpage = cpage;
	}

	public int getRecordPerPage()
	{	
		return recordPerPage;
	}

	public void setRecordPerPage(int recordPerPage)
	{
		this.recordPerPage = recordPerPage;
	}

	public int getBlockPerPage()
	{
		return blockPerPage;
	}

	public void setBlockPerPage(int blockPerPage)
	{
		this.blockPerPage = blockPerPage;
	}

	public int getTotalPage()
	{
		return totalPage;
	}

	public void setTotalPage(int totalPage)
	{
		this.totalPage = totalPage;
	}

	public int getTotalRecord()
	{
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord)
	{
		this.totalRecord = totalRecord;
	}

	public int getStartBlock()
	{
		return startBlock;
	}

	public void setStartBlock(int startBlock)
	{
		this.startBlock = startBlock;
	}

	public int getEndBlock()
	{
		return endBlock;
	}

	public void setEndBlock(int endBlock)
	{
		this.endBlock = endBlock;
	}

	public ArrayList<AlbumBoardTO> getBoardLists()
	{
		return boardLists;
	}

	public void setBoardLists(ArrayList<AlbumBoardTO> boardLists)
	{
		this.boardLists = boardLists;
	}
	
}
