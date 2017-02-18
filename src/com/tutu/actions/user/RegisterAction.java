package com.tutu.actions.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.UserInfoService;
import com.tutu.vo.UserInfoVO;

@Controller
public class RegisterAction implements Action,ModelDriven<UserInfoVO>{
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
		//System.out.println(vo);
		try{
		ActionContext.getContext().put("vo", vo);
		userInfoServiceImpl.register(vo.getUserName(), vo);
		return "success";
		}catch(Exception e){
			ActionContext.getContext().put("error", e.getMessage());
			return "error";
		}
	}

}
