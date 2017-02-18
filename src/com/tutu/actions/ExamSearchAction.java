package com.tutu.actions;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.ExamInfoService;
import com.tutu.vo.ExamInfoVO;

@Controller
public class ExamSearchAction implements Action,ModelDriven<ExamInfoVO>{
	@Resource(name="examInfoServiceImpl")
	private ExamInfoService examInfoServiceImpl;
	private String examMessage;
	
	public String getExamMessage() {
		return examMessage;
	}

	public void setExamMessage(String examMessage) {
		this.examMessage = examMessage;
	}
	
	ExamInfoVO vo  = new ExamInfoVO();

	@Override
	public ExamInfoVO getModel() {
		// TODO Auto-generated method stub
		return vo;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if("".equals(examMessage)){
			ActionContext.getContext().put("error", "搜索内容不能为空！");
			return "fail";
		}
		else if(null==examInfoServiceImpl.search(examMessage)||examInfoServiceImpl.search(examMessage).size()==0){
			ActionContext.getContext().put("error", "没有找到你想要搜索的相关信息!");
			return "error";
		}
		else{
			ActionContext.getContext().put("list", examInfoServiceImpl.search(examMessage));
			return "success";
		}
	}

}
