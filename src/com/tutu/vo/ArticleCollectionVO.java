package com.tutu.vo;

public class ArticleCollectionVO {
private long collNo;
private long articleNo;
private long userNo;
private String collDate;

public ArticleCollectionVO() {
	super();
}
public ArticleCollectionVO(long collNo, long articleNo, long userNo,
		String collDate) {
	super();
	this.collNo = collNo;
	this.articleNo = articleNo;
	this.userNo = userNo;
	this.collDate = collDate;
}
public long getCollNo() {
	return collNo;
}
public void setCollNo(long collNo) {
	this.collNo = collNo;
}
public long getArticleNo() {
	return articleNo;
}
public void setArticleNo(long articleNo) {
	this.articleNo = articleNo;
}
public long getUserNo() {
	return userNo;
}
public void setUserNo(long userNo) {
	this.userNo = userNo;
}
public String getCollDate() {
	return collDate;
}
public void setCollDate(String collDate) {
	this.collDate = collDate;
}
@Override
public String toString() {
	return "ArticleCollectionVO [collNo=" + collNo + ", articleNo=" + articleNo
			+ ", userNo=" + userNo + ", collDate=" + collDate + "]";
}

}
