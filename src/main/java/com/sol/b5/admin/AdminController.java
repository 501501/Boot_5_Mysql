package com.sol.b5.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sol.b5.member.MemberVO;

@Controller
@RequestMapping("/admin/**")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("memberList")
	public void getMemberList(Model model) throws Exception{
		List<MemberVO> ar = adminService.getMemberList();
		model.addAttribute("memberList", ar);
	}
}
