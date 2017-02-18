package com.tutu.service;

import java.util.List;

import com.tutu.vo.PageVO;
import com.tutu.vo.UserInfoVO;

public interface UserInfoService {
	/**
	 * 用户登录功能
	 * 根据用户名和密码判断用户是否为合法用户
	 * 如果合法返回用户对象
	 * 不合法则抛出异常
	 * @param userName  用户名
	 * @param userPwd  密码
	 * @return
	 */
	UserInfoVO login(String userName,String userPwd);
	/**
	 * 用户注册功能
	 * @param userName  用户名
	 * @param userInfoVO  用户对象
	 */
	void register(String userName,UserInfoVO userInfoVO);
	/**
	 * 添加用户功能
	 * @param userInfoVO  用户对象
	 */
	void add(UserInfoVO userInfoVO);
	/**
	 * 用户删除功能
	 * 根据用户编号对用户删除
	 * @param userNo   用户编号
	 */
	void delete(UserInfoVO userInfoVO);
	/**
	 * 修改用户信息功能
	 * @param userInfoVO  用户对象
	 */
	void modify(UserInfoVO userInfoVO);
	/**
	 * 用户锁定功能
	 * 根据用户编号锁定用户，被锁定用户不能登录
	 * @param userNo
	 */
	void lock(UserInfoVO userInfoVO);
	/**
	 * 查找所有用户信息
	 * @return  返回所有用户信息的集合
	 */
	List<UserInfoVO> findAll();
	/**
	 * 通过用户编号查找用户
	 * @param userInfoVO
	 * @return
	 */
	UserInfoVO findByNo(UserInfoVO userInfoVO);
	
	List<UserInfoVO> search(String str);
	
	PageVO<UserInfoVO> pageAll(int page, int rowsMax);
}
