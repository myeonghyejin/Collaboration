package com.mhj.s2.qna;

import java.sql.Date;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mhj.s2.qna.QNADTO;

public class QNADAOTest {

	@Autowired
	private QNADAO qnaDAO;
	
	//insert
	@Test
	public void setQNAAddTest() throws Exception {
		
		for (int i=0; i<30; i++) {
			Random r = new Random();
			double d = r.nextDouble();
			int num = (int)(d * 1000);
			d = num / 100.0;
			
		QNADTO qnaDTO = new QNADTO();
		qnaDTO.setQnaTitle("질문있어요이-"+i);
		qnaDTO.setQnaContents("질문이에요이");
		qnaDTO.setQnaWriter("작성자");
		qnaDTO.setQnaHit(1L);
		
		int result = qnaDAO.setQNAAdd(qnaDTO);
		}

	}
	
}
