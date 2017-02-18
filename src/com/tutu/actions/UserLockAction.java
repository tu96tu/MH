package com.tutu.actions;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.UserInfoService;
import com.tutu.vo.UserInfoVO;
@Controller
public class UserLockAction implements Action,ModelDriven<UserInfoVO>{
	@Resource(name="userInfoServiceImpl")
	private UserInfoService userInfoServiceImpl;
	

	UserInfoVO vo = new UserInfoVO();


	@Override
	public UserInfoVO getModel() {
		// TODO Auto-generated method stub
		return vo;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		UserInfoVO user = userInfoServiceImpl.findByNo(vo);
		userInfoServiceImpl.lock(user);
		return "success";
	}
}
