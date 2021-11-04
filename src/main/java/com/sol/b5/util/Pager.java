package com.sol.b5.util;

import lombok.Data;

@Data
public class Pager {
	
	// 검색
	private String kind;
	private String search;
	
	// 페이징
	private Integer perPage; // 한 페이지에 출력할 개수
	private Integer pn; // 페이지 번호
	private Integer startRow; // limit의 시작 번호
	
	private Long startNum; // jsp에서 사용할 시작 번호
	private Long lastNum; // jsp에서 사용할 끝 번호
	
	private boolean lastCheck; // true이면 마지막 블럭, false면 마지막 블럭 X
	
	// 페이징 처리
	public void makeRow() {
		this.startRow = (this.getPn()-1) * this.getPerPage();
	}
	
	public void makeNum(Long totalCount) { // 104
		// 2. 전체 페이지 개수 구하기
		Long totalPage = totalCount / this.getPerPage(); // 10
		if (totalCount % this.getPerPage() != 0) {
			totalPage++; // 11
		}
		
		// 3. 총 블럭의 개수 구하기
		Long perBlock = 5L;
		Long totalBlock = totalPage / perBlock; // 2
		if (totalPage % perBlock != 0) {
			totalBlock++; // 3
		}
		
		// 4. pn으로 블록 번호 구하기
		// pn = 1    curBlock = 1
		// ...
		// pn = 5    curBlock = 1
		// pn = 6    curBlock = 2
		// ...
		// pn = 10   curBlock = 2
		Long curBlock = this.getPn() / perBlock;
		if (this.getPn() % perBlock != 0) {
			curBlock++;
		}
		
		// 5. curBlock으로 시작 번호와 끝 번호 구하기
		// curBlock		startNum		LastNum
		// 1			1				5
		// 2			6				10
		// 3			11				15
		startNum = (curBlock - 1) * perBlock + 1;
		lastNum = curBlock * perBlock;
		
		//System.out.println("시작번호: "+startNum);
		//System.out.println("끝번호: "+lastNum);
		
		if (curBlock == totalBlock) {
			lastCheck = true;
			lastNum = totalPage;
		}
	}
	
	
	// ---------- setter, getter ----------
	// 검색어 초기화
	public String getSearch() {
		if (this.search == null) {
			this.search = "";
		}
		return this.search;
	}
	
	// 페이지 번호 초기화
	public Integer getPn() {
		if (this.pn == null || this.pn < 1) {
			this.pn = 1;
		}
		return pn;
	}
	
	// 한 페이지에 출력할 개수 초기화
	public Integer getPerPage() {
		if (this.perPage == null || this.perPage < 1) {
			this.perPage = 10;
		}
		return perPage;
	}
}
