package com.tutu.service;

import java.util.List;

import com.tutu.vo.ExamInfoVO;
import com.tutu.vo.PageVO;

public interface ExamInfoService {
	void add(ExamInfoVO vo);
	
	void delete(ExamInfoVO vo);
	
	void modify(ExamInfoVO vo);
	
	List<ExamInfoVO> findAll();
	
	List<ExamInfoVO> search(String examMessage);

	ExamInfoVO findByNo(ExamInfoVO vo);
	
	PageVO<ExamInfoVO> pageAll(int page, int rowsMax);
}
