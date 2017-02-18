package com.tutu.vo;

public class BookInfoVO {
private long bookNo;
private int  num;
private String bookName;
private String bookAuthor;
private int bookAge1;
private int bookAge2;
private String bookIntrd;
private String bookGrade;
private String bookPic;
public BookInfoVO() {
	super();
}

public BookInfoVO(long bookNo, int num, String bookName, String bookAuthor,
		int bookAge1, int bookAge2, String bookIntrd, String bookGrade,
		String bookPic) {
	super();
	this.bookNo = bookNo;
	this.num = num;
	this.bookName = bookName;
	this.bookAuthor = bookAuthor;
	this.bookAge1 = bookAge1;
	this.bookAge2 = bookAge2;
	this.bookIntrd = bookIntrd;
	this.bookGrade = bookGrade;
	this.bookPic = bookPic;
}

public long getBookNo() {
	return bookNo;
}
public void setBookNo(long bookNo) {
	this.bookNo = bookNo;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public String getBookAuthor() {
	return bookAuthor;
}
public void setBookAuthor(String bookAuthor) {
	this.bookAuthor = bookAuthor;
}
public int getBookAge1() {
	return bookAge1;
}
public void setBookAge1(int bookAge1) {
	this.bookAge1 = bookAge1;
}
public int getBookAge2() {
	return bookAge2;
}
public void setBookAge2(int bookAge2) {
	this.bookAge2 = bookAge2;
}
public String getBookIntrd() {
	return bookIntrd;
}
public void setBookIntrd(String bookIntrd) {
	this.bookIntrd = bookIntrd;
}
public String getBookGrade() {
	return bookGrade;
}
public void setBookGrade(String bookGrade) {
	this.bookGrade = bookGrade;
}
public String getBookPic() {
	return bookPic;
}
public void setBookPic(String bookPic) {
	this.bookPic = bookPic;
}

@Override
public String toString() {
	return "BookInfoVO [bookNo=" + bookNo + ", num=" + num + ", bookName="
			+ bookName + ", bookAuthor=" + bookAuthor + ", bookAge1="
			+ bookAge1 + ", bookAge2=" + bookAge2 + ", bookIntrd=" + bookIntrd
			+ ", bookGrade=" + bookGrade + ", bookPic=" + bookPic + "]";
}

}
