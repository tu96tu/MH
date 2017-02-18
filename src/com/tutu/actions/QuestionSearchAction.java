package com.tutu.actions;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.QuestionInfoService;
import com.tutu.vo.QuestionInfoVO;

@Controller
public class QuestionSearchAction implements Action,ModelDriven<QuestionInfoVO>{
	@Resource(name="questionInfoServiceImpl")
	private QuestionInfoService questionInfoServiceImpl;
	private String questionMessage;
	
	public String getQuestionMessage() {
		return questionMessage;
	}

	public void setQuestionMessage(String questionMessage) {
		this.questionMessage = questionMessage;
	}

	QuestionInfoVO vo = new QuestionInfoVO();
	@Override
	public QuestionInfoVO getModel() {
		// TODO Auto-generated method stub
		return vo;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if("".equals(questionMessage)){
			ActionContext.getContext().put("error", "搜索内容不能为空！");
			return "fail";
		}
		else if(null==questionInfoServiceImpl.search(questionMessage)||questionInfoServiceImpl.search(questionMessage).size()==0){
			ActionContext.getContext().put("error", "没有找到你想要搜索的相关信息!");
			return "error";
		}
		else{
			ActionContext.getContext().put("list", questionInfoServiceImpl.search(questionMessage));
			return "success";
		}
	}

}
