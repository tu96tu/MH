package com.tutu.action.proscenium;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tutu.service.ExamInfoService;
import com.tutu.service.QuestionInfoService;
import com.tutu.service.TestResultService;
import com.tutu.service.UserInfoService;
import com.tutu.vo.ExamInfoVO;
import com.tutu.vo.QuestionInfoVO;
import com.tutu.vo.TestResultVO;
import com.tutu.vo.UserInfoVO;

@Controller
public class TestAction extends ActionSupport implements Action,ModelDriven<QuestionInfoVO>{
	@Resource(name="examInfoServiceImpl")
	private ExamInfoService examInfoServiceImpl;
	@Resource(name="questionInfoServiceImpl")
	private QuestionInfoService questionInfoServiceImpl;
	@Resource(name="testResultServiceImpl")
	private TestResultService testResultServiceImpl;
	@Resource(name="userInfoServiceImpl")
	private UserInfoService userInfoServiceImpl;
	QuestionInfoVO vo = new QuestionInfoVO();
	private String page;
	private String testScore;
	private String testResult;
	
	public String getTestResult() {
		return testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	public String getTestScore() {
		return testScore;
	}

	public void setTestScore(String testScore) {
		this.testScore = testScore;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getPage() {
		return page;
	}
	@Override
	public QuestionInfoVO getModel() {
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
		ActionContext.getContext().put("examList",examInfoServiceImpl.pageAll(page1, 3));
		return "success";
	}
	
	public String questionList() throws Exception{
		ExamInfoVO exam = new ExamInfoVO();
		exam.setExamNo(vo.getExamNo());
		//System.out.println(1);
		//System.out.println(questionInfoServiceImpl.findByExamNo(vo).get(0));
		//HttpServletResponse response = ServletActionContext.getResponse();
		//Cookie cookie = new Cookie("page","1");
		//response.addCookie(cookie);
		ActionContext.getContext().getSession().put("examNo", vo.getExamNo());
		ActionContext.getContext().getSession().put("page", 1);
		ActionContext.getContext().put("examTitle", examInfoServiceImpl.findByNo(exam).getExamTitle());
		ActionContext.getContext().put("questionList", questionInfoServiceImpl.pageAll(vo, 1, 1));
		ActionContext.getContext().put("list", questionInfoServiceImpl.findByExamNo(vo));
		//System.out.println(questionInfoServiceImpl.pageAll(vo, page2, 1).getRows());
		return "success";
	}

	public String questionSwitch() throws Exception{
		//System.out.println(vo.getPage());
		vo.setExamNo((Long)ActionContext.getContext().getSession().get("examNo"));
		ExamInfoVO exam = new ExamInfoVO();
		exam.setExamNo(vo.getExamNo());
		int page3 = Integer.parseInt(vo.getPage())+1;
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");	
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		//Cookie cookie = new Cookie("page",page3+"");
		//response.addCookie(cookie);
		QuestionInfoVO question = questionInfoServiceImpl.pageAll(vo, page3, 1).getRows().get(0);
		question.setPage(String.valueOf(page3));
		question.setLength(questionInfoServiceImpl.findByExamNo(vo).size());
		//ActionContext.getContext().put("list", questionInfoServiceImpl.findByExamNo(vo));
		ActionContext.getContext().getSession().put("page", page3);
		//System.out.println(question.toString());
		out.write(question.toString());
		out.close();
		return null;
	}
	
	public String testSubmit() throws Exception{
		
		vo.setExamNo((Long)ActionContext.getContext().getSession().get("examNo"));
		TestResultVO test = new TestResultVO();
		UserInfoVO user = (UserInfoVO)ActionContext.getContext().getSession().get("user1");
		ExamInfoVO exam = new ExamInfoVO();
		exam.setExamNo(vo.getExamNo());
		ExamInfoVO exam1 = examInfoServiceImpl.findByNo(exam);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");	
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		//StringBuffer sBuffer = new StringBuffer("");
		test.setExamNo(vo.getExamNo());
		if(user==null)
			test.setUserNo(0);
		else
			test.setUserNo(user.getUserNo());
		if(Integer.valueOf(testScore)<20){
			//sBuffer.append("{").append("\"result\":\"").append(exam1.getExamResult1())
			//.append("\",\"examNo\":").append(vo.getExamNo()).append(",\"userNo\":")
			//.append(user.getUserNo()).append("}");
			test.setTestResult(exam1.getExamResult1());
		}else if(Integer.valueOf(testScore)<30){
			//sBuffer.append("{").append("\"result\":\"").append(exam1.getExamResult2())
			//.append("\",\"examNo\":").append(vo.getExamNo()).append(",\"userNo\":")
			//.append(user.getUserNo()).append("}");
			test.setTestResult(exam1.getExamResult2());
		}else if(Integer.valueOf(testScore)<50){
			//sBuffer.append("{").append("\"result\":\"").append(exam1.getExamResult3())
			//.append("\",\"examNo\":").append(vo.getExamNo()).append(",\"userNo\":")
			//.append(user.getUserNo()).append("}");
			test.setTestResult(exam1.getExamResult3());
		}else{
			//sBuffer.append("{").append("\"result\":\"").append(exam1.getExamResult4())
			//.append("\",\"examNo\":").append(vo.getExamNo()).append(",\"userNo\":")
			//.append(user.getUserNo()).append("}");
			test.setTestResult(exam1.getExamResult4());
		}
		out.write(test.toString());
		//System.out.println(test.toString());
		out.close();
		return null;
	}
	
	public String resultSave() throws Exception{
		UserInfoVO user = (UserInfoVO)ActionContext.getContext().getSession().get("user1");
		ExamInfoVO exam = new ExamInfoVO();
		exam.setExamNo(vo.getExamNo());
		ExamInfoVO exam1 = examInfoServiceImpl.findByNo(exam);
		user.setNum(exam1.getNum());
		userInfoServiceImpl.modify(user);
		TestResultVO test = new TestResultVO();
		test.setUserNo(user.getUserNo());
		test.setExamNo(vo.getExamNo());
		test.setTestResult(testResult);
		//System.out.println(Integer.valueOf(testScore));
		test.setExamScore(Integer.valueOf(testScore));
		if(null==testResultServiceImpl.find(test))
			testResultServiceImpl.add(test);
		else{
			TestResultVO test1 = testResultServiceImpl.find(test);
			test1.setTestResult(testResult);
			test1.setExamScore(Integer.valueOf(testScore));
			testResultServiceImpl.modify(test1);
		}
		return "success";
	}
}
