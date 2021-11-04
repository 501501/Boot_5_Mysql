package com.sol.b5.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sol.b5.util.Pager;

public interface BoardService {
	// insert 글쓰기
	public int setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception;
		
	// update 글수정
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	// delete 글삭제
	public int setDelete(BoardVO boardVO) throws Exception;
		
	// select 글 하나 조회
	public BoardVO getSelectOne(BoardVO boardVO) throws Exception;
		
	// select 글 리스트 조회
	public List<BoardVO> getSelectList(Pager pager) throws Exception;
}
