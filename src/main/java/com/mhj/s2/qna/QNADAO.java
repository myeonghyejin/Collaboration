package com.mhj.s2.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class QNADAO {
	
	private SqlSession sqlSession;
	private final String NAMESAPCE = "com.mhj.s2.qna.QNADAO.";
	
	/** SELECT **/
	//List
	public List<QNADTO> getQNAList() throws Exception {
		return sqlSession.selectList(NAMESAPCE + "getQNAList");
	}
	
	//Detail
	public QNADTO getQNADetail(QNADTO qnaDTO) throws Exception {
		return sqlSession.selectOne(NAMESAPCE + "getQNADetail", qnaDTO);
	}
	
	/** INSERT **/
	//Add
	public int setQNAAdd(QNADTO qnaDTO) throws Exception {
		return sqlSession.insert(NAMESAPCE + "setQNAAdd", qnaDTO);
	}
	
	//FileAdd
	public int setQNAFileAdd(QNAFileDTO qnaFileDTO) throws Exception {
		return sqlSession.insert(NAMESAPCE + "setQNAFileAdd", qnaFileDTO);
	}
	
	/** UPDATE **/
	//Update
	public int setQNAUpdate(QNADTO qnaDTO) throws Exception {
		return sqlSession.update(NAMESAPCE + "setQNAUpdate", qnaDTO);
	}
	
	/** DELETE **/
	//Delete
	public int setQNADelete(QNADTO qnaDTO) throws Exception {
		return sqlSession.delete(NAMESAPCE + "setQNADelete", qnaDTO);
	}

}
