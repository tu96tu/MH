package com.tutu.actions;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.BookInfoService;
import com.tutu.vo.BookInfoVO;
@Controller
public class BookListAction implements Action,ModelDriven<BookInfoVO>{
	@Resource(name="bookInfoServiceImpl")
	private BookInfoService bookInfoServiceImpl;
	private String page;
	public void setPage(String page) {
		this.page = page;
	}

	public String getPage() {
		return page;
	}
	BookInfoVO vo = new BookInfoVO();
	@Override
	public BookInfoVO getModel() {
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

		ActionContext.getContext().put("pageVO", bookInfoServiceImpl.pageAll(page1, 5));
		return "success";
	}

}
