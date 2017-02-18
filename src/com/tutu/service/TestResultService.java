package com.tutu.service;


import com.tutu.vo.TestResultVO;

public interface TestResultService {
	void add(TestResultVO vo);
	
	void delete(TestResultVO  vo);
	
	void modify(TestResultVO  vo);
	
	TestResultVO find(TestResultVO vo);
}
