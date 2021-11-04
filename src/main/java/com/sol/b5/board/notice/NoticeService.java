package com.sol.b5.board.notice;

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
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public int setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception {
		
		//fileManager.getUseServletContext("/upload/notice/", files[0]);
		//fileManager.getUseResourceLoader("upload/notice/", files[0]);
		//String fileName = fileManager.getUseClassPathResources("upload/notice/", files[0]);
		int result = noticeMapper.setInsert(boardVO);
		
		for (MultipartFile multipartFile:files) {
			
			// multipartFile.isEmpty()
			if (multipartFile.getSize() == 0L) {
				continue;
			}
			
			BoardFileVO boardFileVO = new BoardFileVO();
			boardFileVO.setNum(boardVO.getNum());
			String fileName = fileManager.getUseServletContext("/upload/notice/", multipartFile);
			boardFileVO.setFileName(fileName);
			boardFileVO.setOriName(multipartFile.getOriginalFilename());
			result = noticeMapper.setFileInsert(boardFileVO);
		}
		
		return result;
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		return noticeMapper.setUpdate(boardVO);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		return noticeMapper.setDelete(boardVO);
	}

	@Override
	public BoardVO getSelectOne(BoardVO boardVO) throws Exception {
		return noticeMapper.getSelectOne(boardVO);
	}

	@Override
	public List<BoardVO> getSelectList(Pager pager) throws Exception {
		pager.makeRow();
		
		// 1. 총 글의 개수 DB에서 조회
		Long totalCount = noticeMapper.getTotalCount(pager);
		// System.out.println("총 글의 개수: "+totalCount);
		pager.makeNum(totalCount);
		
		return noticeMapper.getSelectList(pager);
	}
	
}
