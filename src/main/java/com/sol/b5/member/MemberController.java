package com.sol.b5.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("memberJoin")
	public void setInsert(@ModelAttribute MemberVO memberVO) throws Exception {
		System.out.println("Member Login");
		//return "member/memberJoin";
	}
	
	@PostMapping("memberJoin")
	public String setInsert(@Valid MemberVO memberVO, BindingResult bindingResult, MultipartFile files) throws Exception {
		if (memberService.memberError(memberVO, bindingResult)) {
			return "member/memberJoin";
		}
		int result = memberService.setInsert(memberVO, files);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		
		return "redirect:../";
	}
	
	@GetMapping("memberLogin")
	public void getSelectOne() throws Exception {
	
	}
	
//	@PostMapping("memberLogin")
//	public String getSelectOne(MemberVO memberVO, HttpSession session) throws Exception {
//		memberVO = memberService.getSelectOne(memberVO);
//		
//		if (memberVO != null) {
//			session.setAttribute("member", memberVO);
//		}
//		
//		return "redirect:../";
//	}
	
	@GetMapping("memberLogout")
	public String getLogout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:../";
	}
}
