package com.mhj.s2.qna;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mhj.s2.util.FileManager;
import com.mhj.s2.util.Pagination;

@Service
public class QNAService {
	
	@Autowired
	private QNADAO qnaDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private FileManager fileManager;
	
	/** SELECT **/
	//List
	public List<QNADTO> getQNAList(Pagination pagination) throws Exception {
		Long totalCount = qnaDAO.getQNACount(pagination);
		
		pagination.Row();
		pagination.Pagination(totalCount);
		
		return qnaDAO.getQNAList();
	}
	
	//Detail
	public QNADTO getQNADetail(QNADTO qnaDTO) throws Exception {
		return qnaDAO.getQNADetail(qnaDTO);
	}
	
	/** INSERT **/
	//Add
	public int setQNAAdd(QNADTO qnaDTO, MultipartFile multipartFile) throws Exception {
		int result = qnaDAO.setQNAAdd(qnaDTO);
		
		if(!multipartFile.isEmpty()) {
			//(1) HDD에 저장 
			//1. 저장할 폴더 설정
			//2. 저장할 폴더의 실제 경로 반환
			String realPath = servletContext.getRealPath("resources/upload/qna");
			String fileName = fileManager.FileSave(realPath, multipartFile);
			
			//(2) DB에 저장
			QNAFileDTO qnaFileDTO = new QNAFileDTO();
			qnaFileDTO.setQnaNum(qnaDTO.getQnaNum());
			qnaFileDTO.setQnaFileName(fileName);
			qnaFileDTO.setQnaOriName(multipartFile.getOriginalFilename());
			
			result = qnaDAO.setQNAFileAdd(qnaFileDTO);
		}
		
		return result;
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
