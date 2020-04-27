package _191115_FileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MyZipSearchAdv
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		StringBuffer sb = new StringBuffer("");		
		Scanner inputDong = new Scanner(System.in);

		boolean bLoop = true;

		while (bLoop) {
			System.out.println("-----------------");
			System.out.printf("입력 종료 : a \n모두보기 : all \n동 이름 입력 : ");
			String serchWord = inputDong.nextLine();
			System.out.println();

			if (serchWord.equals("a") || serchWord.equals("ㅁ")) {
				bLoop = false;
				break;
			}

			File fPath = new File("./zipcode_seoul_utf8_type2.csv");
			if (!fPath.exists()) {
				fPath = new File("../zipcode_seoul_utf8_type2.csv");
			}
			if (!fPath.exists()) {				
				System.out.println("Err : not Exist File!");
				bLoop = false;
				break;
			}

//			try (BufferedReader br = new BufferedReader(new FileReader(oF))) {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fPath),"UTF8"))) {//file을 UTF8로 전환 InputStreamReader

				// 절대경로 상대경로:현재의 프로그램부터!//허나 이 파일은 이클립스 내부에서 처리(not bin폴더-프로젝트가 현파일로)

				String strData = null;
				String strWord = "";
				int ifindData = 0;

				while ((strData = br.readLine()) != null) {

					String[] wordArray = strData.split(",");
					for (int i =0; i < wordArray.length; ++i) {
						String str = wordArray[i];
						
						if(str.equals(""))
							continue;
						
						sb.append(str);
						
						if(i == wordArray.length -1)//이쁘게 하기위해
							continue;
						
						sb.append(" · ");
					}
					
					strWord = sb.toString();					

					if (wordArray[3].startsWith(serchWord)) {//검색 옵션을 추가한다면...
						++ifindData;
						System.out.printf("%d ☆ %s\n", ifindData, strWord);

					} else if (serchWord.equals("all")) {
						++ifindData;
						System.out.printf("%d · %s\n", ifindData, strWord);
					}
					
					strWord = "";	
					sb.setLength(0);

				}
				System.out.println();
				System.out.printf("입력 검색어 : %s \n", serchWord);
				if(ifindData <= 0) {
					System.out.println("찾을수 없는 값\n\n");
				}
				else {
					System.out.printf("찾은 값의 수 : %d \n\n", ifindData);					
				}
				

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		inputDong.close();
		System.out.println("EXIT!");
		System.exit(0);

	}

}
