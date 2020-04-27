package com.exam.jdbc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model.ZipcodeTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ZipController {
	@Autowired
	private ZipMapper zipMapper;
	
	@RequestMapping(value="/zipcode.do")
	public ModelAndView handleReqZip()
	{

		System.out.printf(" 호출 | %s | %s", this.getClass().getName(),
				new Throwable().getStackTrace()[0].getMethodName());
		System.out.println();
		
		return new ModelAndView("zipcode");
	}
	
	@RequestMapping(value="/zipcode_ok.do", method=RequestMethod.POST)
	public ModelAndView handleReqZipOk(@RequestParam(value = "dong", defaultValue = "") String pDong)
	{
		System.out.printf(" 호출 | %s | %s", this.getClass().getName(),
				new Throwable().getStackTrace()[0].getMethodName());
		System.out.printf(" 데이터 : %s", pDong);
		System.out.println();
				
		String strDong = "%" + pDong  + "%";
				
		ArrayList<ZipcodeTO> zipcodeList = zipMapper.selectZipcode(strDong);
		
		for(ZipcodeTO zto : zipcodeList) {
			System.out.println(zto.getSeq());			
		}
		
		ModelAndView modelAndView = new ModelAndView("zipcode_ok");
		modelAndView.addObject("dong", zipcodeList);
		modelAndView.addObject("data", "새로운 데이터");
		
		return modelAndView;
	}
	
}
