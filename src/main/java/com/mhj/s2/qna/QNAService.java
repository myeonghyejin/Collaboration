package com.mhj.s2.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QNAService {
	
	@Autowired
	private QNADAO qnaDAO;
	
	/** SELECT **/
	//List
	public List<QNADTO> getQNAList() throws Exception {
		return qnaDAO.getQNAList();
	}
	
	//Detail
	public QNADTO getQNADetail(QNADTO qnaDTO) throws Exception {
		return qnaDAO.getQNADetail(qnaDTO);
	}
	
	/** INSERT **/
	//Add
	public int setQNAAdd(QNADTO qnaDTO) throws Exception {
		return qnaDAO.setQNAAdd(qnaDTO);
	}
	
	/** UPDATE **/
	//Update
	public int setQNAUpdate(QNADTO qnaDTO) throws Exception {
		return qnaDAO.setQNAUpdate(qnaDTO);
	}
	
	/** DELETE **/
	//Delete
	public int setQNADelete(QNADTO qnaDTO) throws Exception {
		return qnaDAO.setQNADelete(qnaDTO);
	}

}
