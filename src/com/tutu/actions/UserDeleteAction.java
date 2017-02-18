package com.tutu.actions;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.UserInfoService;
import com.tutu.vo.UserInfoVO;
@Controller
public class UserDeleteAction implements Action,ModelDriven<UserInfoVO>{
	//spring实例化对象
//	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
//	UserInfoService userInfoService = (UserInfoService)applicationContext.getBean("userInfoServiceImpl");
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
		userInfoServiceImpl.delete(vo);
		return "success";
	}

}
