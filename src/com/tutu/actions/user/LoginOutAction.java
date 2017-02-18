package com.tutu.actions.user;

import java.util.Map;


import org.springframework.stereotype.Controller;

import com.tutu.vo.UserInfoVO;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
@Controller
public class LoginOutAction implements Action,ModelDriven<UserInfoVO>{
	private UserInfoVO vo = new UserInfoVO();
	private int path;
	

	public int getPath() {
		return path;
	}

	public void setPath(int path) {
		this.path = path;
	}

	@Override
	public UserInfoVO getModel() {
		// TODO Auto-generated method stub
		return vo;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map session = ActionContext.getContext().getSession();
		if(path==1){
			session.remove("userName");
			session.remove("userId");
			session.remove("user");
		}else{
			session.remove("user1");
		}
		return "success";
	}
}
