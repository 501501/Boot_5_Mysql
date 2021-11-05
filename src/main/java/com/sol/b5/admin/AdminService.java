package com.sol.b5.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sol.b5.member.MemberVO;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public List<MemberVO> getMemberList() throws Exception {
		return adminRepository.getMemberList();
	}
}
