package com.tutu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tutu.dao.impl.UserInfoDao;
import com.tutu.service.UserInfoService;
import com.tutu.vo.PageVO;
import com.tutu.vo.UserInfoVO;
@Service
public class UserInfoServiceImpl implements UserInfoService{
	@Resource(name="userInfoDao")
	private UserInfoDao userInfoDao;
	
	@Override
	public UserInfoVO login(String userName, String userPwd) {
		// TODO Auto-generated method stub
		UserInfoVO vo = userInfoDao.findByName(userName);
		//System.out.println(vo.getUserPwd());
		if(vo==null){
			throw new RuntimeException("用户名不存在");
		}
		else if (!vo.getUserPwd().equals(userPwd)){
			throw new RuntimeException("密码错误");
		}
		return vo;
	}

	@Override
	public void register(String userName, UserInfoVO userInfoVO){
		// TODO Auto-generated method stub

		//System.out.println(userInfoDao.findByName(userName));
		UserInfoVO vo = userInfoDao.findByName(userName);
		if(vo==null){
			vo.setUserLock(!vo.isUserLock());
			userInfoDao.add(userInfoVO);
		}
		else{
			throw new RuntimeException("用户名已存在");
		}
	}

	@Override
	public void add(UserInfoVO userInfoVO) {
		// TODO Auto-generated method stub
		UserInfoVO vo = userInfoDao.findByName(userInfoVO.getUserName());
		if(vo==null){
			userInfoDao.add(userInfoVO);
		}
		else{
			throw new RuntimeException("用户名已存在");
		}
	}

	@Override
	public void delete(UserInfoVO userInfoVO) {
		// TODO Auto-generated method stub
		userInfoDao.delete(userInfoVO);
	}

	@Override
	public void modify(UserInfoVO userInfoVO) {
		// TODO Auto-generated method stub
		userInfoDao.modify(userInfoVO);
	}

	@Override
	public void lock(UserInfoVO userInfoVO) {
		// TODO Auto-generated method stub
		userInfoVO.setUserLock(!userInfoVO.isUserLock());
		userInfoDao.modify(userInfoVO);
	}

	@Override
	public List<UserInfoVO> findAll() {
		// TODO Auto-generated method stub
		return userInfoDao.findAll();
	}

	@Override
	public UserInfoVO findByNo(UserInfoVO userInfoVO) {
		// TODO Auto-generated method stub
		return userInfoDao.findByNo(userInfoVO);
	}

	@Override
	public List<UserInfoVO> search(String str) {
		// TODO Auto-generated method stub
		return userInfoDao.search(str);
	}

	@Override
	public PageVO<UserInfoVO> pageAll(int page, int rowsMax) {
		// TODO Auto-generated method stub
		if (page < 1) {
			page = 1;
		}
		PageVO<UserInfoVO> pageVO = new PageVO<UserInfoVO>();
		pageVO.setCurrent(page);
		pageVO.setRowMax(rowsMax);
		pageVO.setTotal(userInfoDao.count());
		if (pageVO.getTotal() == 0) {
			return null;
		}
		int pageMax = (int) ((pageVO.getTotal() - 1) / rowsMax + 1);
		pageVO.setPageMax(pageMax);
		if (page > pageMax) {
			pageVO.setCurrent(pageMax);
		}
		pageVO.setRows(userInfoDao.findAll(pageVO.getCurrent(), rowsMax));
		return pageVO;
	}

}
