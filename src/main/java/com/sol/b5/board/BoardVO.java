package com.sol.b5.board;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVO {
	private Integer num;
	private String title;
	private String contents;
	private String writer;
	private Integer hit;
	private Date regDate;
	
	private List<BoardFileVO> fileList;
}
