package com.sol.b5.board.qna;

import org.apache.ibatis.annotations.Mapper;

import com.sol.b5.board.BoardMapper;
import com.sol.b5.board.BoardVO;

@Mapper
public interface QnaMapper extends BoardMapper {
		
	public int setRefUpdate(BoardVO boardVO) throws Exception;
	
	public int setReplyUpdate(BoardVO boardVO) throws Exception;
	
	public int setReplyInsert(BoardVO boardVO) throws Exception;
}
