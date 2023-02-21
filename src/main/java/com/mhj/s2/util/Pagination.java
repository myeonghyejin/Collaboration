package com.mhj.s2.util;

public class Pagination {
	
	/** Paging **/
	//Client가 보고 싶은 page 번호 (Parameter)
	private Long page;
	
	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page = 1L;
		}
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	//한 page에 출력할 row의 개수
	private Long perPage;
	
	public Long getPerPage() {
		if(this.perPage == null || this.perPage == 0) {
			this.perPage = 10L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	
	//총 페이지 개수
	private Long totalPage;
	
	public Long getTotalPage() {
		return totalPage;
	}
	
	//DB에서 조회할 시작 번호, 끝 번호
	private Long startRow;
	private Long lastRow;
	
	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	
	//한 block에 출력할 page의 개수
	private Long startNum;
	private Long lastNum;
	
	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	
	//한 block에 출력할 page의 개수
	private Long perBlock;
	
	public Long getPerBlock() {
		if(this.perBlock == null || this.perBlock < 1) {
			this.perBlock = 5L;
		}
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}
	
	//previous, next
	public boolean prev;
	public boolean next;

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	
	//startRow, lastRow를 구하는 메서드
	public void Row() throws Exception {
		this.startRow = (this.getPage() - 1) * this.getPerPage() + 1;
		this.lastRow = this.getPage() * this.getPerPage();
	}
	
	public void Pagination(Long totalCount) {
		//1. 총 row의 개수 구하기
		//매개 변수로 totalCount 선언
		
		//2. 총 page의 개수 구하기
		this.totalPage = totalCount / this.getPerPage();
		if(totalCount % this.getPerPage() != 0) {
			totalPage++;
		}
		if(this.getPage() > totalPage) {
			this.setPage(totalPage);
		}
		
		//3. 한 block당 출력할 page 개수
		//perBlock Getter로 초기화
		
		//4. 총 block의 개수 구하기
		Long totalBlock = totalPage / this.getPerBlock();
		if(totalPage % this.getPerBlock() != 0) {
			totalBlock++;
		}
		
		//5. page 번호로 현재 block 구하기
		Long curBlock = this.getPage() / this.getPerBlock();
		if(this.getPage() % this.getPerBlock() != 0) {
			curBlock++;
		}
		
		//6. 현재 block의 시작 번호, 끝 번호 계산
		this.startNum = (curBlock - 1) * this.getPerBlock() + 1;
		this.lastNum = curBlock * this.getPerBlock();
		
		//7. 이전 block, 다음 block 유무
		//이전 block, 현재 block이 첫 번째 block일 경우 없어야 함
		if(curBlock < 1) {
			this.prev = true;
		}
		
		//다음 block, 현재 block이 마지막 block일 경우 없어야 함
		if(curBlock < totalBlock) {
			this.next = true;
		}
		
		//8. 현재 block이 마지막 block과 같다면
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
		
	}
	
	//---------------------------------------
	
	/** Search **/
	//검색 조건
	private String condition;
	
	//검색어
	private String search;

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getSearch() {
		if(search == null) {
			search = "";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}
