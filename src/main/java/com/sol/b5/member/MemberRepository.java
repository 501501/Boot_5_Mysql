package com.sol.b5.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberRepository {
	// 회원가입
	public int setInsert(MemberVO memberVO) throws Exception;
	
	// 회원파일
	public int setFileInsert(MemberFilesVO memberFilesVO) throws Exception;

	// login
	public MemberVO getSelectOne(MemberVO memberVO) throws Exception;
}
