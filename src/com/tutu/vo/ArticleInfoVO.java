package com.tutu.vo;

public class ArticleInfoVO {
private long articleNo;
private int num;
private String articleTitle;
private String articleAuthor;
private String articleContent;
private String articleDate;
private String articlePic;
public ArticleInfoVO() {
	super();
}
public ArticleInfoVO(long articleNo, int num, String articleTitle,
		String articleAuthor, String articleContent, String articleDate,
		String articlePic) {
	super();
	this.articleNo = articleNo;
	this.num = num;
	this.articleTitle = articleTitle;
	this.articleAuthor = articleAuthor;
	this.articleContent = articleContent;
	this.articleDate = articleDate;
	this.articlePic = articlePic;
}
public long getArticleNo() {
	return articleNo;
}
public void setArticleNo(long articleNo) {
	this.articleNo = articleNo;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public String getArticleTitle() {
	return articleTitle;
}
public void setArticleTitle(String articleTitle) {
	this.articleTitle = articleTitle;
}
public String getArticleAuthor() {
	return articleAuthor;
}
public void setArticleAuthor(String articleAuthor) {
	this.articleAuthor = articleAuthor;
}
public String getArticleContent() {
	return articleContent;
}
public void setArticleContent(String articleContent) {
	this.articleContent = articleContent;
}
public String getArticleDate() {
	return articleDate;
}
public void setArticleDate(String articleDate) {
	this.articleDate = articleDate;
}
public String getArticlePic() {
	return articlePic;
}
public void setArticlePic(String articlePic) {
	this.articlePic = articlePic;
}
@Override
public String toString() {
	return "ArticleInfoVO [articleNo=" + articleNo + ", num=" + num
			+ ", articleTitle=" + articleTitle + ", articleAuthor="
			+ articleAuthor + ", articleContent=" + articleContent
			+ ", articleDate=" + articleDate + ", articlePic=" + articlePic
			+ "]";
}

}
