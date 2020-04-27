package _191118_FileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyZipSearchAdv2_IOPoint
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		StringBuffer sb = new StringBuffer("");		
		Scanner inputDong = new Scanner(System.in);

		boolean bLoop = true;
		boolean bCopy = false;

		while (bLoop) {
			System.out.println("-----------------");
			System.out.printf("입력 종료 : a \n모두보기 : all \n복사 : copy \n동 이름 입력 : ");
			String serchWord = inputDong.nextLine();
			System.out.println();

			if (serchWord.equals("a") || serchWord.equals("ㅁ")) {
				bLoop = false;
				break;
			}
			else if (serchWord.equals("copy") || serchWord.equals("복사")) {
				System.out.printf("검색 및 복사할 동 이름 입력 : ");
				serchWord = inputDong.nextLine();
				bCopy = true;
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

			List<String> copyAdrs = new ArrayList<String>();
			
//			try (BufferedReader br = new BufferedReader(new FileReader(oF))) {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fPath),"UTF8"))) {//file을 UTF8로 전환 InputStreamReader

				// 절대경로 상대경로:현재의 프로그램부터!//허나 이 파일은 이클립스 내부에서 처리(not bin폴더-프로젝트가 현파일로)
				// 이클립스 실행 : 프로젝트경로 기준
				// bin 파일 직접실행 : bin파일 경로 기준

				String strData = null;
				String strWord = "";
				int ifindData = 0;

				while ((strData = br.readLine()) != null) {

					String[] wordArray = strData.split(",");//엑셀 셀 부분의 구분자이다
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
						String searcehValue = String.format("%d ☆ %s\r\n", ifindData, strWord);
						System.out.printf(searcehValue);
						
						if(bCopy) {
							copyAdrs.add(strData + "\n");							
						}

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
				
				if(0 < copyAdrs.size()) {
					System.out.println("복사할 주소의 수 : " + copyAdrs.size());
					
					File dir = new File("./191118resultFiles");
					if(!dir.exists())//디렉토리부터 생성
						dir.mkdirs();
					
					String path = String.format(dir + "/찾은결과값_%s.csv", serchWord.equals("") ? "주소록" : serchWord);//엑셀로 출력하는 방법을 찾아보자
					
					File resultFile = new File(path);
					
					try(BufferedWriter bw = new BufferedWriter(new FileWriter(resultFile))){//복사해보자 //파일을 읽어서 캐릭터(writer)로 생성한다 
//					try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultFile)))){//파일을 바이트 단위(OutputStream)로 읽는다 -> 캐릭터(Writer)로 변환한다
						/*
						 * 1) encoding 방식을 UTF-8 로 설정
						 * BufferedWriter writer = new BufferedWriter(new FileWriter(file)); 로 했을 때 기본적으로 UTF-8 로 설정된다.
						 * 2) BOM(Byte Order Mark) 을 파일 내 추가
						 * BOM : 파일 내에서 해당 파일 인코딩 형식을 명시
						 * UTF 계열의 BOM
						 * 출처: https://hyoseokchoi.tistory.com/entry/FileWriter-로-만든-UTF8-파일을-Excel-에서-열었을-때-한글이-깨지는-문제-해결 [프로그래밍 쌀롱]
						 * */
						
						bw.write("\ufeff");//엑셀 안깨짐 (방법이다)
						//항목명 기입
						bw.write("zipcode,");
						bw.write("sido,");
						bw.write("gugun,");
						bw.write("dong,");
						bw.write("ri,");
						bw.write("bunji,");
						bw.write("seq,");
						bw.write("\n");
						
						for(String copyStr : copyAdrs){
							bw.write(copyStr);
						}
						System.out.println("복사완료");
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println(e.getClass().getName() + " : " + e.getMessage());
					}
					
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
