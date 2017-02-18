package com.tutu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.tutu.dao.impl.QuestionInfoDao;
import com.tutu.service.QuestionInfoService;
import com.tutu.vo.PageVO;
import com.tutu.vo.QuestionInfoVO;
import com.tutu.vo.UserInfoVO;
@Service
public class QuestionInfoServiceImpl implements QuestionInfoService{
	@Resource(name="questionInfoDao")
	private QuestionInfoDao questionInfoDao;
	
	@Override
	public void add(QuestionInfoVO vo) {
		// TODO Auto-generated method stub
		questionInfoDao.add(vo);
	}

	@Override
	public void delete(QuestionInfoVO vo) {
		// TODO Auto-generated method stub
		questionInfoDao.delete(vo);
	}

	@Override
	public void modify(QuestionInfoVO vo) {
		// TODO Auto-generated method stub
		questionInfoDao.modify(vo);
	}

	@Override
	public List<QuestionInfoVO> findAll() {
		// TODO Auto-generated method stub
		return questionInfoDao.findAll();
	}

	@Override
	public List<QuestionInfoVO> search(String questionMessage) {
		// TODO Auto-generated method stub
		return questionInfoDao.search(questionMessage);
	}

	@Override
	public QuestionInfoVO findByNo(QuestionInfoVO vo) {
		// TODO Auto-generated method stub
		return questionInfoDao.findByNo(vo);
	}

	@Override
	public List<QuestionInfoVO> findByExamNo(QuestionInfoVO vo) {
		// TODO Auto-generated method stub
		return questionInfoDao.findByExamNo(vo);
	}

	@Override
	public PageVO<QuestionInfoVO> pageAll(int page, int rowsMax) {
		// TODO Auto-generated method stub
		if (page < 1) {
			page = 1;
		}
		PageVO<QuestionInfoVO> pageVO = new PageVO<QuestionInfoVO>();
		pageVO.setCurrent(page);
		pageVO.setRowMax(rowsMax);
		pageVO.setTotal(questionInfoDao.count());
		if (pageVO.getTotal() == 0) {
			return null;
		}
		int pageMax = (int) ((pageVO.getTotal() - 1) / rowsMax + 1);
		pageVO.setPageMax(pageMax);
		if (page > pageMax) {
			pageVO.setCurrent(pageMax);
		}
		pageVO.setRows(questionInfoDao.findAll(pageVO.getCurrent(), rowsMax));
		return pageVO;
	}

	@Override
	public PageVO<QuestionInfoVO> pageAll(QuestionInfoVO vo, int page,
			int rowsMax) {
		// TODO Auto-generated method stub
		if (page < 1) {
			page = 1;
		}
		PageVO<QuestionInfoVO> pageVO = new PageVO<QuestionInfoVO>();
		pageVO.setCurrent(page);
		pageVO.setRowMax(rowsMax);
		pageVO.setTotal(questionInfoDao.count(vo));
		if (pageVO.getTotal() == 0) {
			return null;
		}
		int pageMax = (int) ((pageVO.getTotal() - 1) / rowsMax + 1);
		pageVO.setPageMax(pageMax);
		if (page > pageMax) {
			pageVO.setCurrent(pageMax);
		}
		pageVO.setRows(questionInfoDao.findByExamNo(vo,pageVO.getCurrent(), rowsMax));
		return pageVO;
	}

}
