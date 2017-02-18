package com.tutu.actions;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.BookInfoService;
import com.tutu.vo.BookInfoVO;
@Controller
public class BookDeleteAction implements Action,ModelDriven<BookInfoVO>{
	@Resource(name="bookInfoServiceImpl")
	private BookInfoService bookInfoServiceImpl;
	BookInfoVO vo  = new BookInfoVO();
	@Override
	public BookInfoVO getModel() {
		// TODO Auto-generated method stub
		return vo;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		bookInfoServiceImpl.delete(vo);
		return "success";
	}
}
