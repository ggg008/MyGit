package _200204.ex02.action;

import _200204.ex02.model.BoardDAO;

public class ListAction implements BoardAction
{
	private BoardDAO dao;
	
	public ListAction(BoardDAO dao)
	{
		this.dao = dao;
	}

	@Override
	public void execute()
	{
		dao.boardList();
		return;
	}

}
