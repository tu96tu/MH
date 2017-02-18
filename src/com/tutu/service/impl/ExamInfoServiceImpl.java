package com.tutu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tutu.dao.impl.ExamInfoDao;
import com.tutu.service.ExamInfoService;
import com.tutu.vo.ExamInfoVO;
import com.tutu.vo.PageVO;
import com.tutu.vo.UserInfoVO;
@Service
public class ExamInfoServiceImpl implements ExamInfoService{
@Resource(name="examInfoDao")
private ExamInfoDao examInfoDao;


@Override
public void add(ExamInfoVO vo) {
	// TODO Auto-generated method stub
	if(null==examInfoDao.findByName(vo.getExamTitle()))
		examInfoDao.add(vo);
	else
		throw new RuntimeException("试卷标题已存在，请重命名！");
}

@Override
public void delete(ExamInfoVO vo) {
	// TODO Auto-generated method stub
	examInfoDao.delete(vo);
}

@Override
public void modify(ExamInfoVO vo) {
	// TODO Auto-generated method stub
	examInfoDao.modify(vo);
}

@Override
public List<ExamInfoVO> findAll() {
	// TODO Auto-generated method stub
	return examInfoDao.findAll();
}

@Override
public List<ExamInfoVO> search(String examMessage) {
	// TODO Auto-generated method stub
	return examInfoDao.search(examMessage);
}

@Override
public ExamInfoVO findByNo(ExamInfoVO vo) {
	// TODO Auto-generated method stub
	return examInfoDao.findByNo(vo);
}

@Override
public PageVO<ExamInfoVO> pageAll(int page, int rowsMax) {
	// TODO Auto-generated method stub
	if (page < 1) {
		page = 1;
	}
	PageVO<ExamInfoVO> pageVO = new PageVO<ExamInfoVO>();
	pageVO.setCurrent(page);
	pageVO.setRowMax(rowsMax);
	pageVO.setTotal(examInfoDao.count());
	if (pageVO.getTotal() == 0) {
		return null;
	}
	int pageMax = (int) ((pageVO.getTotal() - 1) / rowsMax + 1);
	pageVO.setPageMax(pageMax);
	if (page > pageMax) {
		pageVO.setCurrent(pageMax);
	}
	pageVO.setRows(examInfoDao.findAll(pageVO.getCurrent(), rowsMax));
	return pageVO;
}


}
