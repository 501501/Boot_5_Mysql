package com.sol.b5.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sol.b5.member.MemberVO;

@Mapper
public interface AdminRepository {
	// 회원 정보 리스트
	public List<MemberVO> getMemberList() throws Exception;
}
