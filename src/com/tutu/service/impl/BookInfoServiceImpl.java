package com.tutu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tutu.dao.impl.BookInfoDao;
import com.tutu.service.BookInfoService;
import com.tutu.vo.BookInfoVO;
import com.tutu.vo.PageVO;
import com.tutu.vo.UserInfoVO;
@Service
public class BookInfoServiceImpl implements BookInfoService{
	@Resource(name="bookInfoDao")
	private BookInfoDao bookInfoDao;
	@Override
	public void add(BookInfoVO vo) {
		// TODO Auto-generated method stub
		bookInfoDao.add(vo);
	}

	@Override
	public void delete(BookInfoVO vo) {
		// TODO Auto-generated method stub
		bookInfoDao.delete(vo);
	}

	@Override
	public void modify(BookInfoVO vo) {
		// TODO Auto-generated method stub
		bookInfoDao.modify(vo);
	}

	@Override
	public List<BookInfoVO> findAll() {
		// TODO Auto-generated method stub
		return bookInfoDao.findAll();
	}
	/**
	 * 书籍搜索，根据搜索框中的信息（书籍名称，书籍作者）搜索相关书籍
	 */
	@Override
	public List<BookInfoVO> search(String bookMessage) {
		// TODO Auto-generated method stub
		return bookInfoDao.search(bookMessage);
	}

	@Override
	public BookInfoVO findByNo(BookInfoVO vo) {
		// TODO Auto-generated method stub
		return bookInfoDao.findByNo(vo);
	}
	/**
	 * 书籍推荐
	 * 如果用户没有进行心理测试或者没有录入年龄，则直接从书籍表中随机推荐书籍
	 * 否则根据用户的心理类型以及年龄给用户推荐书籍（随机抽取记录显示）
	 */
	@Override
	public List<BookInfoVO> recommend(UserInfoVO vo) {
		// TODO Auto-generated method stub
		if(vo==null){
			return  bookInfoDao.recommend();
		}else{
			if(vo.getUserAge()==0&&vo.getNum()==0)
				return  bookInfoDao.recommend();
			else	
				return bookInfoDao.recommend(vo);
		}
	}
	/**
	 * 分页显示书籍信息
	 */
	@Override
	public PageVO<BookInfoVO> pageAll(int page, int rowsMax) {
		// TODO Auto-generated method stub
		if (page < 1) {
			page = 1;
		}
		PageVO<BookInfoVO> pageVO = new PageVO<BookInfoVO>();
		pageVO.setCurrent(page);
		pageVO.setRowMax(rowsMax);
		pageVO.setTotal(bookInfoDao.count());
		if (pageVO.getTotal() == 0) {
			return null;
		}
		int pageMax = (int) ((pageVO.getTotal() - 1) / rowsMax + 1);
		pageVO.setPageMax(pageMax);
		if (page > pageMax) {
			pageVO.setCurrent(pageMax);
		}
		pageVO.setRows(bookInfoDao.findAll(pageVO.getCurrent(), rowsMax));
		return pageVO;
	}

}
