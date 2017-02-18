package com.tutu.actions;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.QuestionInfoService;
import com.tutu.vo.QuestionInfoVO;
@Controller
public class QuestionListAction implements Action,ModelDriven<QuestionInfoVO>{
	@Resource(name="questionInfoServiceImpl")
	private QuestionInfoService questionInfoServiceImpl;
	QuestionInfoVO vo = new QuestionInfoVO();
	private String pages;
	public void setPages(String pages) {
		this.pages = pages;
	}
	public String getPages() {
		return pages;
	}
	@Override
	public QuestionInfoVO getModel() {
		// TODO Auto-generated method stub
		return vo;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//System.out.println(vo.getExamNo());
		
		int page1 = 1;
		try {
			page1 = Integer.valueOf(pages);
		} catch (Exception e) {
		}
		ActionContext.getContext().getSession().put("examNo", vo.getExamNo());
		vo.setExamNo((Long) ActionContext.getContext().getSession().get("examNo"));
		//System.out.println(vo.getExamNo());
		ActionContext.getContext().put("pageVO", questionInfoServiceImpl.pageAll(vo,page1, 5));
		//System.out.println(page1);
		//System.out.println(questionInfoServiceImpl.pageAll(vo,page1, 5).getRows().get(0));
		return "success";
	}

}
