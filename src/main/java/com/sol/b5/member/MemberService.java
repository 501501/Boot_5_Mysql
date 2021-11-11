package com.sol.b5.member;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.sol.b5.util.FileManager;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private FileManager fileManager;
	
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
		int result = memberRepository.setInsert(memberVO);
		
		if (!files.isEmpty()) {
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
	
	public MemberVO getSelectOne(MemberVO memberVO) throws Exception {
		return memberRepository.getSelectOne(memberVO);
	}
}
