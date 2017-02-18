package com.tutu.vo;

public class QuestionInfoVO {
private long quNo;
private long examNo;
private String quTitle;
private String quOption1;
private String quOption2;
private String quOption3;
private String quOption4;
private int quOption1Score;
private int quOption2Score;
private int quOption3Score;
private int quOption4Score;
private String page;
private int length;



public int getLength() {
	return length;
}
public void setLength(int length) {
	this.length = length;
}
public String getPage() {
	return page;
}
public void setPage(String page) {
	this.page = page;
}
public QuestionInfoVO() {
	super();
}
public QuestionInfoVO(long quNo, long examNo,String quTitle, String quOption1,
		String quOption2, String quOption3, String quOption4,
		int quOption1Score, int quOption2Score, int quOption3Score,
		int quOption4Score) {
	super();
	this.quNo = quNo;
	this.examNo = examNo;
	this.quTitle = quTitle;
	this.quOption1 = quOption1;
	this.quOption2 = quOption2;
	this.quOption3 = quOption3;
	this.quOption4 = quOption4;
	this.quOption1Score = quOption1Score;
	this.quOption2Score = quOption2Score;
	this.quOption3Score = quOption3Score;
	this.quOption4Score = quOption4Score;
}
public long getQuNo() {
	return quNo;
}
public void setQuNo(long quNo) {
	this.quNo = quNo;
}
public long getExamNo() {
	return examNo;
}
public void setExamNo(long examNo) {
	this.examNo = examNo;
}

public String getQuTitle() {
	return quTitle;
}
public void setQuTitle(String quTitle) {
	this.quTitle = quTitle;
}
public String getQuOption1() {
	return quOption1;
}
public void setQuOption1(String quOption1) {
	this.quOption1 = quOption1;
}
public String getQuOption2() {
	return quOption2;
}
public void setQuOption2(String quOption2) {
	this.quOption2 = quOption2;
}
public String getQuOption3() {
	return quOption3;
}
public void setQuOption3(String quOption3) {
	this.quOption3 = quOption3;
}
public String getQuOption4() {
	return quOption4;
}
public void setQuOption4(String quOption4) {
	this.quOption4 = quOption4;
}
public int getQuOption1Score() {
	return quOption1Score;
}
public void setQuOption1Score(int quOption1Score) {
	this.quOption1Score = quOption1Score;
}
public int getQuOption2Score() {
	return quOption2Score;
}
public void setQuOption2Score(int quOption2Score) {
	this.quOption2Score = quOption2Score;
}
public int getQuOption3Score() {
	return quOption3Score;
}
public void setQuOption3Score(int quOption3Score) {
	this.quOption3Score = quOption3Score;
}
public int getQuOption4Score() {
	return quOption4Score;
}
public void setQuOption4Score(int quOption4Score) {
	this.quOption4Score = quOption4Score;
}
@Override
public String toString() {
	return "{\"quNo\":\"" + quNo + "\",\"examNo\":\"" + examNo+ "\",\"quTitle\":\"" + quTitle 
			+ "\",\"quOption1\":\"" + quOption1 + "\", \"quOption2\":\"" + quOption2
			+ "\",\"quOption3\":\"" + quOption3 + "\", \"quOption4\":\"" + quOption4
			+ "\",\"quOption1Score\":\"" + quOption1Score + "\",\"quOption2Score\":\""
			+ quOption2Score + "\",\"quOption3Score\":\"" + quOption3Score
			+ "\",\"quOption4Score\":\"" + quOption4Score + "\",\"page\":\""+page+"\",\"length\":\""+length+"\"}";
}

}
