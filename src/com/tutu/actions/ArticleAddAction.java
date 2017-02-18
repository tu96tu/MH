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
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.commons.FileUtil;
import com.tutu.service.ArticleInfoService;
import com.tutu.vo.ArticleInfoVO;

@Controller
public class ArticleAddAction implements Action,ModelDriven<ArticleInfoVO>{
	@Resource(name="articleInfoServiceImpl")
	private ArticleInfoService articleInfoServiceImpl;
	ArticleInfoVO vo = new ArticleInfoVO();
	private File p2;
	private String p2FileName;
	String uri;
	
	public File getP2() {
		return p2;
	}
	public void setP2(File p2) {
		this.p2 = p2;
	}
	public void setP2FileName(String p2FileName) {
		this.p2FileName = p2FileName;
	}
	@Override
	public ArticleInfoVO getModel() {
		// TODO Auto-generated method stub
		return vo;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(null==p2FileName)
			uri=null;
		else{
			uri = "201608/"+new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
			String path=ServletActionContext.getServletContext().getRealPath("/");
			File f=new File(path+uri);
			f.mkdirs();
			String ext = FileUtil.getFileExt(p2FileName);
			
			uri+=UUID.randomUUID().toString()+"."+ext;
			
			FileUtil.saveFile(new FileInputStream(p2), new File(path+uri));
		}
		
		vo.setArticlePic(uri);
		
		articleInfoServiceImpl.add(vo);
		return "success";
	}

}
