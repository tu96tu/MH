package com.tutu.vo;

public class ExamInfoVO {
private Long examNo;
private int Num;
private String examTitle;
private String examIntrd;
private String examResult1;
private String examResult2;
private String examResult3;
private String examResult4;
public ExamInfoVO() {
	super();
}
public ExamInfoVO(Long examNo, int num, String examTitle,String examIntrd, String examResult1,
		String examResult2, String examResult3, String examResult4) {
	super();
	this.examNo = examNo;
	Num = num;
	this.examTitle = examTitle;
	this.examIntrd = examIntrd;
	this.examResult1 = examResult1;
	this.examResult2 = examResult2;
	this.examResult3 = examResult3;
	this.examResult4 = examResult4;
}
public Long getExamNo() {
	return examNo;
}
public void setExamNo(Long examNo) {
	this.examNo = examNo;
}
public int getNum() {
	return Num;
}
public void setNum(int num) {
	Num = num;
}
public String getExamTitle() {
	return examTitle;
}

public String getExamIntrd() {
	return examIntrd;
}
public void setExamIntrd(String examIntrd) {
	this.examIntrd = examIntrd;
}
public void setExamTitle(String examTitle) {
	this.examTitle = examTitle;
}
public String getExamResult1() {
	return examResult1;
}
public void setExamResult1(String examResult1) {
	this.examResult1 = examResult1;
}
public String getExamResult2() {
	return examResult2;
}
public void setExamResult2(String examResult2) {
	this.examResult2 = examResult2;
}
public String getExamResult3() {
	return examResult3;
}
public void setExamResult3(String examResult3) {
	this.examResult3 = examResult3;
}
public String getExamResult4() {
	return examResult4;
}
public void setExamResult4(String examResult4) {
	this.examResult4 = examResult4;
}
@Override
public String toString() {
	return "ExamInfoVO [examNo=" + examNo + ", Num=" + Num + ", examTitle="
			+ examTitle + ", examIntrd=" + examIntrd + ", examResult1=" 
			+ examResult1 + ", examResult2="+ examResult2 + ", examResult3="
			+ examResult3 + ", examResult4="+ examResult4 + "]";
}

}
