package com.tutu.dao;

import java.util.List;

import com.tutu.vo.UserInfoVO;

public interface DAOSupper<T> {
	/**
	 * 添加
	 * @param t
	 */
	void add(T t);
	/**
	 * 删除
	 * @param t
	 */
	void delete(T t);
	/**
	 * 修改
	 * @param t
	 */
	void modify(T t);
	/**
	 * 查找
	 * @param t
	 * @return  返回结果集合
	 */
	List<T> findAll(); 
	
	T findByName(String userName);
	
	T findByNo(T t);
	
	List<T> search(String str);
}
