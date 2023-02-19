package com.mhj.s2.qna;

public class QNAFileDTO {
	
	private Long qnaFileNum;
	private Long qnaNum;
	private String qnaFileName;
	private String qnaOriName;

	//Getter, Setter
	public Long getQnaFileNum() {
		return qnaFileNum;
	}
	public void setQnaFileNum(Long qnaFileNum) {
		this.qnaFileNum = qnaFileNum;
	}
	public Long getQnaNum() {
		return qnaNum;
	}
	public void setQnaNum(Long qnaNum) {
		this.qnaNum = qnaNum;
	}
	public String getQnaFileName() {
		return qnaFileName;
	}
	public void setQnaFileName(String qnaFileName) {
		this.qnaFileName = qnaFileName;
	}
	public String getQnaOriName() {
		return qnaOriName;
	}
	public void setQnaOriName(String qnaOriName) {
		this.qnaOriName = qnaOriName;
	}
}
