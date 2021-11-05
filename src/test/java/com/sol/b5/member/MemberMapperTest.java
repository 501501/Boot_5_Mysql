package com.sol.b5.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class MemberMapperTest {
	
	@Autowired
	private MemberRepository memberRespository;
	
	//@Test
	void setInsertTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("id1");
		memberVO.setPw("pw1");
		memberVO.setName("name1");
		memberVO.setEmail("email1");
		int result = memberRespository.setInsert(memberVO);
		
		assertNotEquals(0, result);
	}
	
	//@Test
	void setFileInsertTest() throws Exception {
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setMember_id("test");
		memberFilesVO.setFileName("file1Name1");
		memberFilesVO.setOriName("oriName1");
		int result = memberRespository.setFileInsert(memberFilesVO);
		
		assertNotEquals(0, result);
	}
	
	@Test
	void getSelectOneTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("id1");
		memberVO.setPw("pw1");
		memberVO = memberRespository.getSelectOne(memberVO);
		assertNotNull(memberVO);
	}
}
