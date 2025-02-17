package _200129;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import transferObjs.DeptTO;
import transferObjs.EmpTO;

public class MyBatisExDMLInsert
{

	public static void main(String[] args)
	{
		// 바뀌지않는 기초 설정
		String resource = "myBatisConfig.xml";

		InputStream is = null;
		SqlSession sqlSession = null;

		try {
			is = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

			sqlSession = sqlSessionFactory.openSession(true);// treu집어넣으면 오토커밋
			// --바뀌지않는 기초 설정

			DeptTO dTo = new DeptTO();
			dTo.setDeptno("82");
			dTo.setDname("개발");
			dTo.setLoc("인천");

			// buffer의 존재로 commit() 호출 전까지는 입력이 안됨(버퍼에 계속 남아있으므로)
			// openSession옵션으로 자동커밋 가능
			int result = sqlSession.insert("insert1", dTo);
//			sqlSession.commit();

//			System.out.println("result : " + result);
			
			if( result == 0 ) {
				System.out.println("실패");
			} else {
				System.out.println("성공");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
				}
		}

	}

}
