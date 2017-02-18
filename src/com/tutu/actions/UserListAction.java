package com.tutu.actions;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.tutu.service.UserInfoService;
import com.tutu.service.impl.UserInfoServiceImpl;
import com.tutu.vo.UserInfoVO;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
@Controller
public class UserListAction implements Action,ModelDriven<UserInfoVO>{
	//spring实例化对象
//	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
//	UserInfoService userInfoService = (UserInfoService)applicationContext.getBean("userInfoServiceImpl");
@Resource(name="userInfoServiceImpl")
	private UserInfoService userInfoServiceImpl;
	

	UserInfoVO vo = new UserInfoVO();
	private String page;
	public void setPage(String page) {
		this.page = page;
	}

	public String getPage() {
		return page;
	}
	@Override
	public UserInfoVO getModel() {
		// TODO Auto-generated method stub
		return vo;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		//ActionContext.getContext().put("list", userInfoServiceImpl.findAll());
		int page1 = 1;
		try {
			page1 = Integer.valueOf(page);
		} catch (Exception e) {
		}

		ActionContext.getContext().put("pageVO", userInfoServiceImpl.pageAll(page1, 5));
		return "success";
	}

}
