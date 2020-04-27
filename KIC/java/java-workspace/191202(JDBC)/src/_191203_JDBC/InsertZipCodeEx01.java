package _191203_JDBC;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InsertZipCodeEx01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));
			
			String data = null;
			while ((data = br.readLine()) != null) {
//					System.out.println(data);		
				String[] datas = data.split(",");
				String sql = 
						String.format("INSERT INTO zipcode VALUES('%s', '%s', '%s', '%s', '%s', '%s', %s)", 
								datas[0], datas[1], datas[2], datas[3], datas[4], datas[5], datas[6]);
				System.out.println(sql);
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
