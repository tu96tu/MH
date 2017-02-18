package com.tutu.actions.user;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.UserInfoService;
import com.tutu.vo.UserInfoVO;
@Controller
public class LoginAction extends ActionSupport implements Action,ModelDriven<UserInfoVO>{
	@Resource(name="userInfoServiceImpl")
	private UserInfoService userInfoServiceImpl;
	private UserInfoVO vo = new UserInfoVO();
	String message;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public UserInfoVO getModel() {
		// TODO Auto-generated method stub
		return vo;
	}
	
	public String execute(){
		try{
			//System.out.println(vo.getUserPwd());
			UserInfoVO user = userInfoServiceImpl.login(vo.getUserName(), vo.getUserPwd());
			ActionContext.getContext().put("user", user);
			
			Map session = ActionContext.getContext().getSession();
			session.put("userName",vo.getUserName());
			session.put("userId", user.getUserNo());
			session.put("userPwd",vo.getUserPwd());
			session.put("user", user);
			if(user.isUserRole()==false&&user.isUserLock()==true){
				session.put("user1", user);
				return "success";
			}else if(user.isUserRole()==true&&user.isUserLock()==true){
				return "fail";	
			}else{
				ActionContext.getContext().put("message", "用户已被锁定，请联系管理员解锁！");
				return "error";
			}
		}catch(Exception e){
			message=e.getMessage();
			ActionContext.getContext().put("message", message);
			return "error";
		}
	}

}
