package com.tutu.actions;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.UserInfoService;
import com.tutu.vo.UserInfoVO;
@Controller
public class UserSearchAction implements Action,ModelDriven<UserInfoVO>{
	@Resource(name="userInfoServiceImpl")
	private UserInfoService userInfoServiceImpl;
	private String searchMessage;
	
	public String getSearchMessage() {
		return searchMessage;
	}

	public void setSearchMessage(String searchMessage) {
		this.searchMessage = searchMessage;
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
		//System.out.println(searchMessage);
		//System.out.println(userInfoServiceImpl.search(searchMessage));
		if("".equals(searchMessage)){
			System.out.println(1+searchMessage);
			ActionContext.getContext().put("error","搜索内容不能为空！");
			return "fail";
		}
		else if(null==userInfoServiceImpl.search(searchMessage)||userInfoServiceImpl.search(searchMessage).size()==0){	
			//System.out.println(userInfoServiceImpl.search(searchMessage));
			ActionContext.getContext().put("error","没有找到你想要搜索的相关信息!");
			return "error";
		}
		else{	
			System.out.println(userInfoServiceImpl.search(searchMessage));
			ActionContext.getContext().put("list", userInfoServiceImpl.search(searchMessage));
			
			return "success";
		}
	}

}
