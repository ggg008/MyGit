package com.exam.jdbc;

import java.util.ArrayList;

import com.exam.model.ZipcodeTO;

public interface ZipMapper
{
	//맵퍼와 연동
	public abstract ArrayList<ZipcodeTO> selectZipcode(String srtDong);
}
