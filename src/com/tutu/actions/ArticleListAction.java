package com.tutu.actions;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.ArticleInfoService;
import com.tutu.vo.ArticleInfoVO;
@Controller
public class ArticleListAction implements Action,ModelDriven<ArticleInfoVO>{
	@Resource(name="articleInfoServiceImpl")
	private ArticleInfoService articleInfoServiceImpl;
	ArticleInfoVO vo = new ArticleInfoVO();
	private String page;
	public void setPage(String page) {
		this.page = page;
	}

	public String getPage() {
		return page;
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

		ActionContext.getContext().put("pageVO", articleInfoServiceImpl.pageAll(page1, 5));
		return "success";
	}

}
