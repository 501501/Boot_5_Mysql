package com.sol.b5.board;

import java.util.List;

import com.sol.b5.util.Pager;

public interface BoardMapper {
	// insert 글쓰기
	public int setInsert(BoardVO boardVO) throws Exception;
	
	// 파일 저장
	public int setFileInsert(BoardFileVO boardFileVO) throws Exception;
	
	// 파일 다운
	public BoardFileVO fileDown(BoardFileVO boardFileVO) throws Exception;
	
	// update 글수정
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	// update 조회수 수정
	public int setHitUpdate(BoardVO boardVO) throws Exception;
	
	// delete 글삭제
	public int setDelete(BoardVO boardVO) throws Exception;
	
	// select 글 하나 조회
	public BoardVO getSelectOne(BoardVO boardVO) throws Exception;
	
	// select 글 리스트 조회
	public List<BoardVO> getSelectList(Pager pager) throws Exception;
	
	// totalCount
	public Long getTotalCount(Pager pager) throws Exception;
	
}
