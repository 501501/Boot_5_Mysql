package com.sol.b5.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sol.b5.board.BoardVO;
import com.sol.b5.util.Pager;

@SpringBootTest
class NoticeMapperTest {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Test
	void setInsertTest() throws Exception {
		
		for (int i=0; i<100; i++) {
			BoardVO boardVO = new BoardVO();
			boardVO.setTitle("title"+i);
			boardVO.setContents("contents"+i);
			boardVO.setWriter("writer"+i);
			
			int result = noticeMapper.setInsert(boardVO);
			
			if (i % 10 == 0) {
				Thread.sleep(500);
			}
		}
		
		System.out.println("Finish");
		//System.out.println(boardVO.getNum());
		//assertNotEquals(0, result);
	}
	
	//@Test
	void setUpdateTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(4);
		boardVO.setTitle("t4");
		boardVO.setContents("t4");
		
		int result = noticeMapper.setUpdate(boardVO);
		assertNotEquals(0, result);
	}
	
	//@Test
	void setHitUpdateTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(1);
		
		int result = noticeMapper.setHitUpdate(boardVO);
		assertNotEquals(0, result);
	}
	
	//@Test
	void setDeleteTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(5);
		
		int result = noticeMapper.setDelete(boardVO);
		assertNotEquals(0, result);
	}
	
	//@Test
	void getSelectOne() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(1);
		
		boardVO = noticeMapper.getSelectOne(boardVO);
		assertNotNull(boardVO);
	}
	
	//@Test
	void getSelectList() throws Exception {
		Pager pager = new Pager();
		List<BoardVO> ar = noticeMapper.getSelectList(pager);
		assertNotEquals(0, ar.size());
	}
}
