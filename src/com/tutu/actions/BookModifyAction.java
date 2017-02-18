package com.tutu.actions;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.commons.FileUtil;
import com.tutu.service.BookInfoService;
import com.tutu.vo.BookInfoVO;
@Controller
public class BookModifyAction implements Action,ModelDriven<BookInfoVO>{
	@Resource(name="bookInfoServiceImpl")
	private BookInfoService bookInfoServiceImpl;
	BookInfoVO vo  = new BookInfoVO();
	private File p1;
	private String p1FileName;
	private String uri;
	public File getP1() {
		return p1;
	}

	public void setP1(File p1) {
		this.p1 = p1;
	}

	public void setP1FileName(String p1FileName) {
		this.p1FileName = p1FileName;
	}
	@Override
	public BookInfoVO getModel() {
		// TODO Auto-generated method stub
		return vo;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext.getContext().put("vo", bookInfoServiceImpl.findByNo(vo));
		return "success";
	}
	
	public String modify() throws Exception{
		if(null==p1FileName){
			uri=bookInfoServiceImpl.findByNo(vo).getBookPic();
		}else{
			uri = "201608/"+new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
			String path=ServletActionContext.getServletContext().getRealPath("/");
			File f=new File(path+uri);
			f.mkdirs();
			String ext = FileUtil.getFileExt(p1FileName);
			
			uri+=UUID.randomUUID().toString()+"."+ext;
			
			FileUtil.saveFile(new FileInputStream(p1), new File(path+uri));
		}
		vo.setBookPic(uri);
		
		bookInfoServiceImpl.modify(vo);
		// if(stdNum)
		ActionContext.getContext().put("bookInfoVO", vo);
		return "success";
	}

}
