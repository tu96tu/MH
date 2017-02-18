package com.tutu.action.proscenium;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.ArticleInfoService;
import com.tutu.service.UserInfoService;
import com.tutu.service.impl.ArticleInfoServiceImpl;
import com.tutu.vo.ArticleInfoVO;
import com.tutu.vo.UserInfoVO;
@Controller
public class ArticleAction implements Action,ModelDriven<ArticleInfoVO>{
	@Resource(name="articleInfoServiceImpl")
	private ArticleInfoServiceImpl articleInfoServiceImpl;
	private String page;
	private String articleMessage;
	ArticleInfoVO vo = new ArticleInfoVO();
	private String path;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getPage() {
		return page;
	}
	
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
		int page1 = 1;
		try {
			page1 = Integer.valueOf(page);
		} catch (Exception e) {
		}
		ActionContext.getContext().put("articleList", articleInfoServiceImpl.pageAll(page1, 3));
		ActionContext.getContext().put("articleMenu", articleInfoServiceImpl.pageAll(1, 4));
		//System.out.println("------------------");System.out.println(articleInfoServiceImpl.pageAll(page1, 3).getCurrent());
		//System.out.println("------------------");
		return "success";
	}
	
	public String search() throws Exception{
		int page2 = 1;
		try {
			page2 = Integer.valueOf(page);
		} catch (Exception e) {
		}
		ActionContext.getContext().put("key", 1);
		ActionContext.getContext().put("articleMenu", articleInfoServiceImpl.pageAll(1, 4));
		if(("").equals(articleMessage)){
			ActionContext.getContext().put("error", "搜索内容不能为空(@﹏@)~...");
			return "fail";
		}else if(null==articleInfoServiceImpl.searchAll(articleMessage,page2, 3)||articleInfoServiceImpl.searchAll(articleMessage,page2, 3).getCurrent()==0){
			ActionContext.getContext().put("error", "没有找到您要搜索的内容┭┮﹏┭┮...");
			return "error";
		}
		ActionContext.getContext().put("articleList", articleInfoServiceImpl.searchAll(articleMessage,page2, 3));
		return "success";
	}
	
	public String page() throws Exception{
		int page3 = 1;
		try {
			page3 = Integer.valueOf(page);
		} catch (Exception e) {
		}
		UserInfoVO user = new UserInfoVO();
		user = 	(UserInfoVO)ActionContext.getContext().getSession().get("user");
		ActionContext.getContext().put("articleMenu", articleInfoServiceImpl.pageAll(1, 4));
		//System.out.println(articleInfoServiceImpl.pageAll(page3,1).getRows().get(0));
		if(null!=user){
			ArticleInfoVO vo = (ArticleInfoVO)articleInfoServiceImpl.pageAll(page3,1).getRows().get(0);
			ActionContext.getContext().put("collection", articleInfoServiceImpl.findCollection(vo,user));
		}
		ActionContext.getContext().put("list", articleInfoServiceImpl.findAll());
		ActionContext.getContext().put("articleInfo", articleInfoServiceImpl.pageAll(page3,1));
		return "success";
	}
	
	public String collect() throws Exception{
		UserInfoVO user = (UserInfoVO)ActionContext.getContext().getSession().get("user");
		if(null==user){
			return "fail";
		}
		java.util.Date d = new java.util.Date();
		java.text.SimpleDateFormat dformat = new java.text.SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String datetime = dformat.format(d);
		/*ActionContext.getContext().put("path", user.getUserNo());*/
		path="page?page="+page;
		articleInfoServiceImpl.collect(vo, user, datetime);
		return "success";
	}
	
	public String searchByNum() throws Exception{
		int page4 = 1;
		try {
			page4 = Integer.valueOf(page);
		} catch (Exception e) {
		}
		ActionContext.getContext().put("key", 2);
		ActionContext.getContext().put("num", vo.getNum());
		ActionContext.getContext().put("articleMenu", articleInfoServiceImpl.pageAll(1, 4));
		
		ActionContext.getContext().put("articleList", articleInfoServiceImpl.searchByNum(vo.getNum(),page4, 3));
		return "success";
	}
}
