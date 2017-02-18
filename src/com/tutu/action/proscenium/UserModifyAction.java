package com.tutu.action.proscenium;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.UserInfoService;
import com.tutu.vo.UserInfoVO;
@Controller("modifyAction")
public class UserModifyAction implements Action,ModelDriven<UserInfoVO>{
	@Resource(name="userInfoServiceImpl")
	private UserInfoService userInfoServiceImpl;
	UserInfoVO  vo = new UserInfoVO();
	@Override
	public UserInfoVO getModel() {
		// TODO Auto-generated method stub
		return vo;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//System.out.println(vo.getUserTel());
		UserInfoVO user =userInfoServiceImpl.findByNo(vo);
		user.setUserAge(vo.getUserAge());
		user.setUserPwd(vo.getUserPwd());
		user.setUserRealName(vo.getUserRealName());
		user.setUserSex(vo.isUserSex());
		user.setUserTel(vo.getUserTel());
		userInfoServiceImpl.modify(user);
		ActionContext.getContext().getSession().put("user1",user);
		return "success";
	}

}
