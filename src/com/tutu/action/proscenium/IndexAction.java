package com.tutu.action.proscenium;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.tutu.service.ArticleInfoService;
import com.tutu.service.BookInfoService;
import com.tutu.vo.UserInfoVO;
@Controller
public class IndexAction implements Action{
	@Resource(name="articleInfoServiceImpl")
	private ArticleInfoService articleInfoServiceImpl;
	@Resource(name="bookInfoServiceImpl")
	private BookInfoService bookInfoServiceImpl;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext.getContext().put("articleList", articleInfoServiceImpl.findAll());
		Map session = ActionContext.getContext().getSession();
		UserInfoVO user = (UserInfoVO)session.get("user1");
		ActionContext.getContext().put("bookList", bookInfoServiceImpl.recommend(user));
		return "success";
	}
}
