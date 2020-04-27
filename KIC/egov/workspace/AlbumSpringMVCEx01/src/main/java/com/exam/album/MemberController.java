package com.exam.album;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
	
	@RequestMapping(value = "/member_search1.do")
	public String search() {
		return "member_search1";
	}
	
	@RequestMapping(value = "/member_search1_ok.do")
	public String search_ok() {
		return "member_search1_ok";
	}
	
	@RequestMapping(value = "/member_write1.do")
	public String write() {
		return "member_write1";
	}
	
	@RequestMapping(value = "/member_write1_ok.do")
	public String write_ok() {
		return "member_write1_ok";
	}
	
	@RequestMapping(value = "/member_modify1.do")
	public String modify() {
		return "member_modify1";
	}
	
	@RequestMapping(value = "/member_modify1_ok.do")
	public String modify_ok() {
		return "member_modify1_ok";
	}

}
