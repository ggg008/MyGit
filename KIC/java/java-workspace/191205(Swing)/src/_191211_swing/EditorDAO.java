package _191211_swing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EditorDAO {
	public StringBuffer readFile(File file) {
		BufferedReader br = null;
		
		StringBuffer result = new StringBuffer();
		try {
			br = new BufferedReader(new FileReader(file));
			
			String line = null;
			while( ( line = br.readLine() ) != null ) {
				result.append( line + "\n");
			}
		} catch( FileNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if( br != null) try { br.close(); } catch( IOException e ) {} 
		}
		
		return result;
	}
	
	public boolean writeFile(File file, String data) {
		BufferedWriter bw = null;
		
		// 개발자 임의로 생성한 변수 - 메서드 실행여부
		boolean flag = false;
		try {
			bw = new BufferedWriter( new FileWriter( file ) );
			bw.write(data);
			
			flag = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if( bw != null) try { bw.close(); } catch( IOException e ) {} 
		}
		
		return flag;
	}
}
