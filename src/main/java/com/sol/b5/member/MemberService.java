package com.sol.b5.member;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.sol.b5.util.FileManager;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService implements UserDetailsService {
	
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	// 검증 메서드 선언
	public boolean memberError(MemberVO memberVO, BindingResult bindingResult) throws Exception {
		boolean check = false;
		// false: 검증 성공
		// true: 검증 실패(위반이 있음)
		
		// 1. Annotation 검증
		check = bindingResult.hasErrors();
		
		// 2. password가 일치하는지 검증
		if (!memberVO.getPw().equals(memberVO.getPwCheck())) {
			bindingResult.rejectValue("pwCheck", "member.password.notEqual");
			check = true;
		}
		
		// 3. ID 중복 검사
		memberVO = memberRepository.getSelect(memberVO);
		if (memberVO != null) {
			bindingResult.rejectValue("id", "member.id.equals");
			check = true;
		}
		
		return check;
	}
	
	//@Transactional(rollbackFor = Exception.class)
	public int setInsert(MemberVO memberVO, MultipartFile files) throws Exception {
		
		memberVO.setPw(bCryptPasswordEncoder.encode(memberVO.getPw()));
		memberVO.setEnabled(true);
		
		int result = memberRepository.setInsert(memberVO);
		
		if (files !=null && !files.isEmpty()) {
			String fileName = fileManager.getUseServletContext("/upload/member/", files);
			MemberFilesVO memberFilesVO = new MemberFilesVO();
			memberFilesVO.setMember_id(memberVO.getId());
			memberFilesVO.setFileName(fileName);
			memberFilesVO.setOriName(files.getOriginalFilename());
			result = memberRepository.setFileInsert(memberFilesVO);
			
			if (result == 0) {
				throw new Exception();
			}
		}
		
		return result;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Load User By UserName");
		System.out.println(username);
		MemberVO memberVO = null;
		try {
			memberVO = memberRepository.getSelectOne(username);
			//memberVO.setPw(bCryptPasswordEncoder.encode(memberVO.getPw()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Spring security가 UserDetails 리턴 받아서 비번을 비교 진행
		return memberVO;
	}
	
//	public MemberVO getSelectOne(MemberVO memberVO) throws Exception {
//		return memberRepository.getSelectOne(memberVO);
//	}
}
