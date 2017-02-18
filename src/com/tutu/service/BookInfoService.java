package com.tutu.service;

import java.util.List;

import com.tutu.vo.BookInfoVO;
import com.tutu.vo.PageVO;
import com.tutu.vo.UserInfoVO;

public interface BookInfoService {
	void add(BookInfoVO vo);
	
	void delete(BookInfoVO vo);
	
	void modify(BookInfoVO vo);
	
	List<BookInfoVO> findAll();
	
	List<BookInfoVO> search(String bookMessage);

	BookInfoVO findByNo(BookInfoVO vo);
	
	List<BookInfoVO> recommend(UserInfoVO vo);
	
	PageVO<BookInfoVO> pageAll(int page, int rowsMax);
}
