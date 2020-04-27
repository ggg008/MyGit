package _191204_JDBC;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import _191204_JDBC.Classes.SeachUtil;
import _191204_JDBC.Classes.ZipcodeTO;

public class SearchZipcodeEx02
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		// dong
		// select
		// 출력
		SeachUtil su = new SeachUtil();
		
		try {			
			
			ArrayList<ZipcodeTO> results = su.searchDong(su.inputDong());
			for(ZipcodeTO to : results) {
				System.out.printf("[%s] %s %s %s %s %s\n",
						to.getZipcode(), to.getSido(), to.getGugun(), to.getDong(), to.getRi(), to.getBunji());
			}
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			System.out.println(e.getClass().getName() + " : " + e.getMessage());			
		}	
		

	}

}
