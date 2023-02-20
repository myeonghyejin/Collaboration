package com.mhj.s2.qna;

import java.sql.Date;

public class QNADTO {
	
	private Long qnaNum;
	private String qnaTitle;
	private String qnaContents;
	private String qnaWriter;
	private Date qnaDate;
	private Long qnaHit;
	
	private QNAFileDTO qnaFileDTO;
	
	//Getter, Setter
	public Long getQnaNum() {
		return qnaNum;
	}
	public void setQnaNum(Long qnaNum) {
		this.qnaNum = qnaNum;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContents() {
		return qnaContents;
	}
	public void setQnaContents(String qnaContents) {
		this.qnaContents = qnaContents;
	}
	public String getQnaWriter() {
		return qnaWriter;
	}
	public void setQnaWriter(String qnaWriter) {
		this.qnaWriter = qnaWriter;
	}
	public Date getQnaDate() {
		return qnaDate;
	}
	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate;
	}
	public Long getQnaHit() {
		return qnaHit;
	}
	public void setQnaHit(Long qnaHit) {
		this.qnaHit = qnaHit;
	}

}
