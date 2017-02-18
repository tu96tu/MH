package com.tutu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tutu.dao.impl.ArticleInfoDao;
import com.tutu.service.ArticleInfoService;
import com.tutu.vo.ArticleCollectionVO;
import com.tutu.vo.ArticleInfoVO;
import com.tutu.vo.PageVO;
import com.tutu.vo.UserInfoVO;

@Service
public class ArticleInfoServiceImpl implements ArticleInfoService{
	@Resource(name="articleInfoDao")
	private ArticleInfoDao articleInfoDao;
	@Override
	public void add(ArticleInfoVO vo) {
		// TODO Auto-generated method stub
		articleInfoDao.add(vo);
	}

	@Override
	public void delete(ArticleInfoVO vo) {
		// TODO Auto-generated method stub
		articleInfoDao.delete(vo);
	}

	@Override
	public void modify(ArticleInfoVO vo) {
		// TODO Auto-generated method stub
		articleInfoDao.modify(vo);
	}

	@Override
	public List<ArticleInfoVO> findAll() {
		// TODO Auto-generated method stub
		return articleInfoDao.findAll();
	}

	@Override
	public List<ArticleInfoVO> search(String articleMessage) {
		// TODO Auto-generated method stub
		return articleInfoDao.search(articleMessage);
	}

	@Override
	public ArticleInfoVO findByNo(ArticleInfoVO vo) {
		// TODO Auto-generated method stub
		return articleInfoDao.findByNo(vo);
	}

	@Override
	public PageVO<ArticleInfoVO> pageAll(int page, int rowsMax) {
		// TODO Auto-generated method stub
		if (page < 1) {
			page = 1;
		}
		PageVO<ArticleInfoVO> pageVO = new PageVO<ArticleInfoVO>();
		pageVO.setCurrent(page);
		pageVO.setRowMax(rowsMax);
		pageVO.setTotal(articleInfoDao.count());
		if (pageVO.getTotal() == 0) {
			return null;
		}
		int pageMax = (int) ((pageVO.getTotal() - 1) / rowsMax + 1);
		pageVO.setPageMax(pageMax);
		if (page > pageMax) {
			pageVO.setCurrent(pageMax);
		}
		pageVO.setRows(articleInfoDao.findAll(pageVO.getCurrent(), rowsMax));
		return pageVO;
	}

	@Override
	public PageVO<ArticleInfoVO> searchAll(String articleMessage, int page,
			int rowsMax) {
		// TODO Auto-generated method stub
		if (page < 1) {
			page = 1;
		}
		PageVO<ArticleInfoVO> pageVO = new PageVO<ArticleInfoVO>();
		pageVO.setCurrent(page);
		pageVO.setRowMax(rowsMax);
		pageVO.setTotal(articleInfoDao.searchCount(articleMessage));
		if (pageVO.getTotal() == 0) {
			return null;
		}
		int pageMax = (int) ((pageVO.getTotal() - 1) / rowsMax + 1);
		pageVO.setPageMax(pageMax);
		if (page > pageMax) {
			pageVO.setCurrent(pageMax);
		}
		pageVO.setRows(articleInfoDao.search(articleMessage,pageVO.getCurrent(), rowsMax));
		return pageVO;
	}

	@Override
	public void collect(ArticleInfoVO vo1, UserInfoVO vo2, String date) {
		// TODO Auto-generated method stub
		articleInfoDao.collect(vo1, vo2, date);
	}

	@Override
	public ArticleCollectionVO findCollection(ArticleInfoVO vo,
			UserInfoVO vo1) {
		// TODO Auto-generated method stub
		return articleInfoDao.findCollect(vo, vo1);
	}

	@Override
	public List<ArticleCollectionVO> findCollectionAll(UserInfoVO vo) {
		// TODO Auto-generated method stub
		return articleInfoDao.findCollectionAll(vo);
	}

	@Override
	public void deleteCollection(ArticleCollectionVO vo) {
		// TODO Auto-generated method stub
		articleInfoDao.delete(vo);
	}

	@Override
	public PageVO<ArticleInfoVO> searchByNum(int num, int page, int rowsMax) {
		// TODO Auto-generated method stub
		if (page < 1) {
			page = 1;
		}
		PageVO<ArticleInfoVO> pageVO = new PageVO<ArticleInfoVO>();
		pageVO.setCurrent(page);
		pageVO.setRowMax(rowsMax);
		pageVO.setTotal(articleInfoDao.searchCount(num));
		if (pageVO.getTotal() == 0) {
			return null;
		}
		int pageMax = (int) ((pageVO.getTotal() - 1) / rowsMax + 1);
		pageVO.setPageMax(pageMax);
		if (page > pageMax) {
			pageVO.setCurrent(pageMax);
		}
		pageVO.setRows(articleInfoDao.search(num,pageVO.getCurrent(), rowsMax));
		return pageVO;
	}

}
