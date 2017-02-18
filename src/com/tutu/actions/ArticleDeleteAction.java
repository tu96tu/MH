package com.tutu.actions;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.ArticleInfoService;
import com.tutu.vo.ArticleInfoVO;
@Controller
public class ArticleDeleteAction implements Action,ModelDriven<ArticleInfoVO>{
	@Resource(name="articleInfoServiceImpl")
	private ArticleInfoService articleInfoServiceImpl;
	ArticleInfoVO vo = new ArticleInfoVO();
	
	@Override
	public ArticleInfoVO getModel() {
		// TODO Auto-generated method stub
		return vo;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		articleInfoServiceImpl.delete(vo);
		return "success";
	}

}
