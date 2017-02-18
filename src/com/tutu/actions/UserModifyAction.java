package com.tutu.actions;


import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.UserInfoService;
import com.tutu.vo.UserInfoVO;
@Controller
public class UserModifyAction implements Action,ModelDriven<UserInfoVO>{
	//spring实例化对象
//	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
//	UserInfoService userInfoService = (UserInfoService)applicationContext.getBean("userInfoServiceImpl");
@Resource(name="userInfoServiceImpl")
	private UserInfoService userInfoServiceImpl;
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	UserInfoVO vo = new UserInfoVO(); 
	@Override
	public UserInfoVO getModel() {
		// TODO Auto-generated method stub
		return vo;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext.getContext().put("vo",userInfoServiceImpl.findByNo(vo));
		return "success";
	}
	
	public String modify() throws Exception{
		UserInfoVO user = userInfoServiceImpl.findByNo(vo);
		vo.setUserLock(user.isUserLock());
		vo.setUserRole(user.isUserRole());
		userInfoServiceImpl.modify(vo);
		ActionContext.getContext().put("error",null);
		return "success";
		
	}
	
	public String pwdReset() throws Exception{
		if(password.equals(userInfoServiceImpl.findByNo(vo).getUserPwd())){
			if("".equals(vo.getUserPwd())){
				ActionContext.getContext().put("error", "新密码不能为空！");
				return "fail";
			}
			UserInfoVO user = userInfoServiceImpl.findByNo(vo);
			user.setUserPwd(vo.getUserPwd());
			userInfoServiceImpl.modify(user);
			return "success";
		}else{
			ActionContext.getContext().put("error", "旧密码错误，请重新输入！");
			return "fail";
		}
		
	}

}
