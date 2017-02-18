package com.tutu.service;

import java.util.List;

import com.tutu.vo.ArticleCollectionVO;
import com.tutu.vo.ArticleInfoVO;
import com.tutu.vo.PageVO;
import com.tutu.vo.UserInfoVO;

public interface ArticleInfoService {
	void add(ArticleInfoVO vo);
	
	void delete(ArticleInfoVO vo);
	
	void modify(ArticleInfoVO vo);
	
	List<ArticleInfoVO> findAll();
	
	List<ArticleInfoVO> search(String articleMessage);

	ArticleInfoVO findByNo(ArticleInfoVO vo);
	
	PageVO<ArticleInfoVO> pageAll(int page, int rowsMax);
	
	PageVO<ArticleInfoVO> searchAll(String articleMessage,int page, int rowsMax);
	
	PageVO<ArticleInfoVO> searchByNum(int num,int page, int rowsMax);
	
	void collect(ArticleInfoVO vo1,UserInfoVO vo2,String date);
	
	ArticleCollectionVO findCollection(ArticleInfoVO vo,UserInfoVO vo1);
	
	List<ArticleCollectionVO> findCollectionAll(UserInfoVO vo);
	
	void deleteCollection(ArticleCollectionVO vo);
}
