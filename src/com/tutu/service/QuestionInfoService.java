package com.tutu.service;

import java.util.List;

import com.tutu.vo.PageVO;
import com.tutu.vo.QuestionInfoVO;
public interface QuestionInfoService {
	void add(QuestionInfoVO vo);
	
	void delete(QuestionInfoVO vo);
	
	void modify(QuestionInfoVO vo);
	
	List<QuestionInfoVO> findAll();
	
	List<QuestionInfoVO> search(String questionMessage);

	QuestionInfoVO findByNo(QuestionInfoVO vo);
	
	List<QuestionInfoVO> findByExamNo(QuestionInfoVO vo);
	
	PageVO<QuestionInfoVO> pageAll(int page, int rowsMax);
	
	PageVO<QuestionInfoVO> pageAll(QuestionInfoVO vo,int page, int rowsMax);
}
