package com.tutu.actions;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.BookInfoService;
import com.tutu.vo.BookInfoVO;
@Controller
public class BookSearchAction implements Action,ModelDriven<BookInfoVO>{
	@Resource(name="bookInfoServiceImpl")
	private BookInfoService bookInfoServiceImpl;
	BookInfoVO vo  = new BookInfoVO();
	private String bookMessage;
	
	
	public String getBookMessage() {
		return bookMessage;
	}
	public void setBookMessage(String bookMessage) {
		this.bookMessage = bookMessage;
	}
	@Override
	public BookInfoVO getModel() {
		// TODO Auto-generated method stub
		return vo;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if("".equals(bookMessage)){
			ActionContext.getContext().put("error", "搜索内容不能为空！");
			return "fail";
		}
		else if(null==bookInfoServiceImpl.search(bookMessage)||bookInfoServiceImpl.search(bookMessage).size()==0){
			ActionContext.getContext().put("error", "没有找到你想要搜索的相关信息!");
			return "error";
		}
		else{
			ActionContext.getContext().put("list", bookInfoServiceImpl.search(bookMessage));
			return "success";
		}
	}
	
}
