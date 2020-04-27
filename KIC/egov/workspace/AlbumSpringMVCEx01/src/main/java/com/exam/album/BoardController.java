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
public class BoardController {
	
	@RequestMapping(value = "/board_list1.do")
	public String list() {
		return "board_list1";
	}
	
	@RequestMapping(value = "/board_view1.do")
	public String view() {
		return "board_view1";
	}
	
	@RequestMapping(value = "/board_write1.do")
	public String write() {
		return "board_write1";
	}
	
	@RequestMapping(value = "/board_write1_ok.do")
	public String write_ok() {
		return "board_write1_ok";
	}
	
	@RequestMapping(value = "/board_modify1.do")
	public String modify() {
		return "board_modify1";
	}
	
	@RequestMapping(value = "/board_modify1_ok.do")
	public String modify_ok() {
		return "board_modify1_ok";
	}
	
	@RequestMapping(value = "/board_delete1.do")
	public String delete() {
		return "board_delete1";
	}
	
	@RequestMapping(value = "/board_delete1_ok.do")
	public String delete_ok() {
		return "board_delete1_ok";
	}
}
