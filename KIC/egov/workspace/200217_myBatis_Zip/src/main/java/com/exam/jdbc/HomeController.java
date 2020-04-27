package com.exam.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private DataSource dataSource;
	
	@RequestMapping(value="/jdbc1.do")
	public String jdbc1() {
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		ResultSet rSet = null;
		
		try {
			//접속 구문
			connection = dataSource.getConnection();
			String sql = "SELECT now() AS now";
			preparedStatement = connection.prepareStatement(sql);
			
			rSet = preparedStatement.executeQuery();
			if(rSet.next()) {
				System.out.println("시간 출력 : " + rSet.getString("now"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rSet != null)
				try {
					rSet.close();
				} catch (SQLException e) {
				}
			if(preparedStatement != null)
				try {
					preparedStatement.close();
				} catch (SQLException e) {
				}
			if(connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		
		return "jdbc1";
	}
	
}
