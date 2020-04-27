package com.exam.upload;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController2
{
	@Autowired
	FileRenamePolicy fileRenamePolicy;//의존 자동 주입화
	// new - 생성자 자동 주입 - 초기화 - setter


	@RequestMapping(value = "/write_ok.do")
	public String handleReqWriteOkDoRSM(@RequestParam(value = "upload") MultipartFile multipartFile, Model model)
	{
		//cos.jar와의 차이 : 중복 파일 처리가 안됨, 직접 만들어야함
		String uploadPath = "C:\\MyCloud\\OneDrive\\eGovFrameDev-3.8.0-64bit\\workspace\\200217_FileUpload\\src\\main\\webapp\\upload";

		System.out.printf(" 호출 %s %s \n", this.getClass().getName(),
				new Throwable().getStackTrace()[0].getMethodName());

		
		FileOutputStream fos = null;
		
		//FileRenamePolicy fileRenamePolicy = new FileRenamePolicy();
		
		String newPath = uploadPath + "\\" + fileRenamePolicy.renameFile(multipartFile.getOriginalFilename());
		try {
			System.out.printf(" FILE %s %s %s\n", multipartFile.getName(), multipartFile.getOriginalFilename() , newPath);
			
			fos = new FileOutputStream(newPath);
			byte fileData[] = multipartFile.getBytes();
			fos.write(fileData);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
				}
		}

		
		model.addAttribute("data", newPath);

		return "write_ok";
	}
}
