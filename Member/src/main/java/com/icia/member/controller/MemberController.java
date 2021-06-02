package com.icia.member.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	private ModelAndView mav;
	
	@RequestMapping(value = "/joinpage")
		public String joinpage() {
		return "memberjoin";
	}
	
	@RequestMapping(value = "/memberjoin")
		public ModelAndView memberJoin(@ModelAttribute MemberDTO member) throws IllegalStateException, IOException {
		mav = ms.memberjoin(member);
		return mav;
	}
	
	@RequestMapping(value = "/loginpage")
		public ModelAndView loginpage() {
		return mav;
	}
	
	@RequestMapping(value = "/login")
		public ModelAndView memberlogin(@ModelAttribute MemberDTO member) {
		mav = ms.memberLogin(member);
		return mav;
	} 
	
	// 회원정보 수정 요청 메소드 
	@RequestMapping(value="/memberupdate")
	public ModelAndView update() {
		mav = ms.update();
		
		return mav;
	}
	
	// 회원정보 수정 처리 메소드 
	@RequestMapping(value="/updateprocess")
	public ModelAndView updateProcess(@ModelAttribute MemberDTO member) {
		mav = ms.updateProcess(member);
		return mav;
	}
	
	
	
}
