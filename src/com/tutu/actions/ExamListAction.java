package com.tutu.actions;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.ExamInfoService;
import com.tutu.vo.ExamInfoVO;
@Controller
public class ExamListAction implements Action,ModelDriven<ExamInfoVO>{
	@Resource(name="examInfoServiceImpl")
	private ExamInfoService examInfoServiceImpl;
	private String page;
	public void setPage(String page) {
		this.page = page;
	}

	public String getPage() {
		return page;
	}
	ExamInfoVO vo = new ExamInfoVO();
	@Override
	public ExamInfoVO getModel() {
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

		ActionContext.getContext().put("pageVO", examInfoServiceImpl.pageAll(page1, 5));
		return "success";
	}

}
