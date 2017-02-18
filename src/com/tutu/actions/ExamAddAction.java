package com.tutu.actions;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.ExamInfoService;
import com.tutu.vo.ExamInfoVO;
@Controller
public class ExamAddAction implements Action,ModelDriven<ExamInfoVO>{
	@Resource(name="examInfoServiceImpl")
	private ExamInfoService examInfoServiceImpl;
	
	ExamInfoVO vo = new ExamInfoVO();
	@Override
	public ExamInfoVO getModel() {
		// TODO Auto-generated method stub
		return vo;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//System.out.println(vo);
		examInfoServiceImpl.add(vo);
		return "success";
	}

}
