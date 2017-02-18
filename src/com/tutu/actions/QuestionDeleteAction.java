package com.tutu.actions;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.QuestionInfoService;
import com.tutu.vo.QuestionInfoVO;
@Controller
public class QuestionDeleteAction implements Action,ModelDriven<QuestionInfoVO>{
	@Resource(name="questionInfoServiceImpl")
	private QuestionInfoService questionInfoServiceImpl;
	
	QuestionInfoVO vo = new QuestionInfoVO();
	@Override
	public QuestionInfoVO getModel() {
		// TODO Auto-generated method stub
		return vo;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		questionInfoServiceImpl.delete(vo);
		return "success";
	}

}
