package testCode;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import content.MyClassCilent;

public class testMain
{
/*

목록 SQL

SELECT * FROM studentInfo
SELECT * FROM JoinStudentInfo
SELECT * FROM fileinfo
	
내용 SQL

쓰기 SQL
INSERT INTO StudentInfo VALUES (?, ?, ?, ?, ?, ?, ?, ?)
INSERT INTO JoinStudentInfo VALUES (?, ?, ?, ?, ?, ?)
INSERT INTO fileInfo VALUES (?, ?, ?, ?, ?)

수정 SQL

UPDATE studentinfo SET StuID=?, Name=?, PhoneNumber=?, HomeAddress=?, Ps=?, ipAddress=? WHERE jumin=?
UPDATE studentinfo SET StuID=?, Name=?, PhoneNumber=?, HomeAddress=?, ipAddress=? WHERE jumin=?
UPDATE JoinStudentInfo SET StuID=?, Name=?, PhoneNumber=?, HomeAddress=? WHERE jumin=?
UPDATE fileInfo SET downloadNum=? WHERE fileKey=?

삭제 SQL

DELETE FROM StudentInfo WHERE jumin = ?
DELETE FROM JoinStudentInfo WHERE jumin = ?
DELETE FROM fileInfo WHERE fileKey = ?
DELETE FROM fileInfo WHERE filekey IN ('')
	

*/
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

//		System.out.println(Calendar.getInstance().get(Calendar.YEAR));

//		String testProp = "#메렁" + "\n" + "pass=c:\\\\ddd\\\\sss.text" + "\n" + "이름=홍길동" + "\n" + "id=andy" + "\n" + "addr=192.168.0.2\n" +
//		"#메렁" + "\n" + "pass=1234" + "\n" + "이름=홍길동" + "\n" + "id=andy" + "\n" + "addr=192.168.0.2\n";
//
//		var test = new testMain();
//
//
//		test.loadFromFile(testProp);
		
//		var errmsg = "#successmsg가입 제출완료당신은 망했습니다.";
//		
//		if(errmsg.substring(0, 11).equals("#successmsg"))
//		{
//		
//			errmsg = errmsg.replaceAll("#successmsg", "");
//			
//			System.out.println(errmsg);
//		}
		
		var path =  MyClassCilent.getInstance().getDownDir();
		path =  path.replaceAll("/", "\\\\");
		
		System.out.println(path);
		
		File checkDir = new File(path);
		if(!checkDir.exists()) {
			System.out.println("없는파일");
			checkDir.mkdirs();
		}

		ProcessBuilder p2 = new ProcessBuilder("explorer.exe", path);

		try {
			p2.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
/*
fileKey       bigint(5) unsigned
fileFullPath  varchar(1000)
fileName      varchar(100)
downloadNum   bigint(13)
uploadDate    date
 */
	}

	private void loadFromFile(String testStr)
	{
		String[] strArray = testStr.split("#메렁");
		
		for(String str : strArray) {
		
		
			var sr = new StringReader(str);
			
			
			Properties props = new Properties();
			try {
				props.load(sr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Set<String> keys = props.stringPropertyNames();
			for (String key : keys) {
				System.out.println(key + " : " + props.getProperty(key));
			}
		}

	}
}
