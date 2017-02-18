package com.tutu.vo;

public class TestResultVO {
private long testNo;
private long userNo;
private long examNo;
private int examScore;
private String testResult;
public TestResultVO() {
	super();
}
public TestResultVO(long testNo, long userNo, long examNo, int examScore,
		String testResult) {
	super();
	this.testNo = testNo;
	this.userNo = userNo;
	this.examNo = examNo;
	this.examScore = examScore;
	this.testResult = testResult;
}
public long getTestNo() {
	return testNo;
}
public void setTestNo(long testNo) {
	this.testNo = testNo;
}
public long getUserNo() {
	return userNo;
}
public void setUserNo(long userNo) {
	this.userNo = userNo;
}
public long getExamNo() {
	return examNo;
}
public void setExamNo(long examNo) {
	this.examNo = examNo;
}
public int getExamScore() {
	return examScore;
}
public void setExamScore(int examScore) {
	this.examScore = examScore;
}
public String getTestResult() {
	return testResult;
}
public void setTestResult(String testResult) {
	this.testResult = testResult;
}
@Override
public String toString() {
	return "{\"testNo\":\"" + testNo + "\",\"userNo\":\"" + userNo
			+ "\",\"examNo\":\"" + examNo + "\",\"examScore\":\"" + examScore
			+ "\",\"testResult\":\"" + testResult + "\"}";
}

}
