package com.sol.b5.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sol.b5.board.BoardFileVO;
import com.sol.b5.board.BoardService;
import com.sol.b5.board.BoardVO;
import com.sol.b5.util.FileManager;
import com.sol.b5.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaMapper qnaMapper;
	@Autowired
	private FileManager fileManager;
	
	public int setReplyInsert(BoardVO boardVO, MultipartFile [] files) throws Exception {
		int result = qnaMapper.setReplyUpdate(boardVO);
		result = qnaMapper.setReplyInsert(boardVO);
		
		// 파일 저장
		for (MultipartFile multipartFile : files) {

			// multipartFile.isEmpty()
			if (multipartFile.getSize() == 0L) {
				continue;
			}

			BoardFileVO boardFileVO = new BoardFileVO();
			boardFileVO.setNum(boardVO.getNum());
			String fileName = fileManager.getUseServletContext("/upload/qna/", multipartFile);
			boardFileVO.setFileName(fileName);
			boardFileVO.setOriName(multipartFile.getOriginalFilename());
			result = qnaMapper.setFileInsert(boardFileVO);
		}
		
		return result;
	}
	
	@Override
	public int setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception {
		int result = qnaMapper.setInsert(boardVO);
		result = qnaMapper.setRefUpdate(boardVO);
		
		for (MultipartFile multipartFile:files) {
			
			// multipartFile.isEmpty()
			if (multipartFile.getSize() == 0L) {
				continue;
			}
			
			BoardFileVO boardFileVO = new BoardFileVO();
			boardFileVO.setNum(boardVO.getNum());
			String fileName = fileManager.getUseServletContext("/upload/qna/", multipartFile);
			boardFileVO.setFileName(fileName);
			boardFileVO.setOriName(multipartFile.getOriginalFilename());
			result = qnaMapper.setFileInsert(boardFileVO);
		}
		
		return result;
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		return qnaMapper.setUpdate(boardVO);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		return qnaMapper.setDelete(boardVO);
	}

	@Override
	public BoardVO getSelectOne(BoardVO boardVO) throws Exception {
		return qnaMapper.getSelectOne(boardVO);
	}

	@Override
	public List<BoardVO> getSelectList(Pager pager) throws Exception {
		pager.makeRow();
		
		// 1. 총 글의 개수 DB에서 조회
		Long totalCount = qnaMapper.getTotalCount(pager);
		// System.out.println("총 글의 개수: "+totalCount);
		pager.makeNum(totalCount);
		
		return qnaMapper.getSelectList(pager);
	}
	
}
