package com.tutu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tutu.dao.impl.TestResultInfoDao;
import com.tutu.service.TestResultService;
import com.tutu.vo.TestResultVO;
@Service
public class TestResultServiceImpl implements TestResultService{
	@Resource(name="testResultInfoDao")
	private TestResultInfoDao testResultInfoDao;
	@Override
	public void add(TestResultVO vo) {
		// TODO Auto-generated method stub
		testResultInfoDao.add(vo);
	}

	@Override
	public void delete(TestResultVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(TestResultVO vo) {
		// TODO Auto-generated method stub
		testResultInfoDao.modify(vo);
	}

	@Override
	public TestResultVO find(TestResultVO vo) {
		// TODO Auto-generated method stub
		return testResultInfoDao.find(vo);
	}

}
