package com.exam.albummodel1;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	
	private DataSource dataSource = null;
	
	public MemberDAO() {
		// TODO Auto-generated constructor stub
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup( "java:comp/env" );
			this.dataSource = (DataSource)envCtx.lookup( "jdbc/mariadb" );
		} catch( NamingException e ) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] : " + e.getMessage() );
		}
	}
	
	public int memberLoginOk(MemberTO to) {
		int flag = 1;
		return flag;
	}
}
