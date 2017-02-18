package com.tutu.action.proscenium;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.tutu.service.BookInfoService;
@Controller
public class BookAction implements Action{
	@Resource(name="bookInfoServiceImpl")
	private BookInfoService bookInfoServiceImpl;
	private String page;
	private String bookMessage;
	
	
	public String getBookMessage() {
		return bookMessage;
	}
	public void setBookMessage(String bookMessage) {
		this.bookMessage = bookMessage;
	}
	public void setPage(String page) {
		this.page = page;
	}

	public String getPage() {
		return page;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		int page1 = 1;
		try {
			page1 = Integer.valueOf(page);
		} catch (Exception e) {
		}
		ActionContext.getContext().put("bookList",bookInfoServiceImpl.pageAll(page1, 6));
		//ActionContext.getContext().put("list",bookInfoServiceImpl.findAll());
		return "success";
	}
	 public String search() throws Exception{
		 if("".equals(bookMessage)){
				ActionContext.getContext().put("error", "搜索内容不能为空！┗( T﹏T )┛");
				return "fail";
			}
			else if(null==bookInfoServiceImpl.search(bookMessage)||bookInfoServiceImpl.search(bookMessage).size()==0){
				ActionContext.getContext().put("error", "没有找到你想要搜索的相关信息!(づ｡◕‿‿◕｡)づ");
				return "error";
			}
			else{
				ActionContext.getContext().put("list", bookInfoServiceImpl.search(bookMessage));
				return "success";
			}
	 }
}
