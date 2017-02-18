package com.tutu.actions;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.ArticleInfoService;
import com.tutu.vo.ArticleInfoVO;
@Controller
public class ArticleSearchAction implements Action,ModelDriven<ArticleInfoVO>{
	@Resource(name="articleInfoServiceImpl")
	private ArticleInfoService articleInfoServiceImpl;
	ArticleInfoVO vo = new ArticleInfoVO();
	private String articleMessage;
	
	public String getArticleMessage() {
		return articleMessage;
	}
	public void setArticleMessage(String articleMessage) {
		this.articleMessage = articleMessage;
	}
	@Override
	public ArticleInfoVO getModel() {
		// TODO Auto-generated method stub
		return vo;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(("").equals(articleMessage)){
			ActionContext.getContext().put("error", "搜索内容不能为空!");
			return "fail";
		}else if(null==articleInfoServiceImpl.search(articleMessage)||articleInfoServiceImpl.search(articleMessage).size()==0){
			ActionContext.getContext().put("error", "没有找到您要搜索的内容!");
			return "error";
		}
		ActionContext.getContext().put("list", articleInfoServiceImpl.search(articleMessage));
		return "success";
	}
}
