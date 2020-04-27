package com.exam.album;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
	
	@RequestMapping(value = "/member_search1.do")
	public String search(HttpServletRequest request, Model model) {
		return "member_search1";
	}
	
	@RequestMapping(value = "/member_search1_ok.do")
	public String search_ok(HttpServletRequest request, Model model) {
		return "member_search1_ok";
	}
	
	@RequestMapping(value = "/member_write1.do")
	public String write(HttpServletRequest request, Model model) {
		return "member_write1";
	}
	
	@RequestMapping(value = "/member_write1_ok.do")
	public String write_ok(HttpServletRequest request, Model model) {
		return "member_write1_ok";
	}
	
	@RequestMapping(value = "/member_login1_ok.do")
	public String login_ok(HttpServletRequest request, Model model) {
		return "member_login1_ok";
	}
	
	@RequestMapping(value = "/member_logout1_ok.do")
	public String logout_ok(HttpServletRequest request, Model model) {
		return "member_logout1_ok";
	}
}
