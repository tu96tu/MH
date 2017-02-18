package com.tutu.action.proscenium;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.ArticleInfoService;
import com.tutu.service.UserInfoService;
import com.tutu.vo.ArticleCollectionVO;
import com.tutu.vo.UserInfoVO;
@Controller
public class PrivateAction implements Action,ModelDriven<ArticleCollectionVO>{
	@Resource(name="userInfoServiceImpl")
	private UserInfoService userInfoServiceImpl;
	@Resource(name="articleInfoServiceImpl")
	private ArticleInfoService articleInfoServiceImpl;
	ArticleCollectionVO vo = new ArticleCollectionVO();
	private String message;
	@Override
	public ArticleCollectionVO getModel() {
		// TODO Auto-generated method stub
		return vo;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map session = ActionContext.getContext().getSession();
		UserInfoVO vo = (UserInfoVO)session.get("user1");
		if(vo==null){
			return "fail";
		}
		message =null;
		ActionContext.getContext().put("message",message);
		ActionContext.getContext().put("user1", vo);
		ActionContext.getContext().put("collection", articleInfoServiceImpl.findCollectionAll(vo));
		return "success";
	}
	
	public String deleteCollection() throws Exception{
		message = "┗|*｀0′*|┛ ";
		ActionContext.getContext().put("message",message);
		articleInfoServiceImpl.deleteCollection(vo);
		return "success";
	}
}
