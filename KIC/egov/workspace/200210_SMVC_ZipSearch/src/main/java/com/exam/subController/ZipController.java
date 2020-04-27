package com.exam.subController;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model.ZipcodeDAO;
import com.exam.model.ZipcodeTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ZipController {
	
	
	@RequestMapping(value="/zipcode.do")
	public ModelAndView handleReqZip()
	{

		System.out.printf(" 호출 %s %s \n", this.getClass().getName(),
				new Throwable().getStackTrace()[0].getMethodName());
		
		return new ModelAndView("zipcode");
	}
	
	@RequestMapping(value="/zipcode_ok.do", method=RequestMethod.POST)
	public ModelAndView handleReqZipOk(@RequestParam(value = "dong", defaultValue = "") String pDong)
	{
		System.out.printf(" 호출 %s %s %s \n", this.getClass().getName(),
				new Throwable().getStackTrace()[0].getMethodName(), pDong);
		
		
		String strDong = pDong;
		
//		ZipDAO zDao = new ZipDAO();
		ZipcodeDAO zDao = new ZipcodeDAO();
		
		ArrayList<ZipcodeTO> zipcodeList = zDao.zipcodeList(strDong);
		
		for(ZipcodeTO zto : zipcodeList) {
			System.out.println(zto.getSeq());			
		}
		
		ModelAndView modelAndView = new ModelAndView("zipcode_ok");
		modelAndView.addObject("dong", zipcodeList);
		modelAndView.addObject("data", "새로운 데이터");
//		request.setAttribute("data", "새로운 데이터");
		
		return modelAndView;
	}
	
}
