package com.tutu.vo;

public class UserInfoVO {
	private long userNo;
	private String userName;
	private String userPwd;
	private String userRealName;
	private boolean userSex;
	private int num;
	private int userAge;
	private long userTel;
	private boolean userRole;
	private boolean userLock;
	public UserInfoVO() {
		super();
	}
	public UserInfoVO(long userNo, String userName, String userPwd,
			String userRealName,boolean userSex, int num, int userAge, long userTel,
			boolean userRole, boolean userLock) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userRealName = userRealName;
		this.userSex = userSex;
		this.num = num;
		this.userAge = userAge;
		this.userTel = userTel;
		this.userRole = userRole;
		this.userLock = userLock;
	}
	public long getUserNo() {
		return userNo;
	}
	public void setUserNo(long userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	
	public boolean isUserSex() {
		return userSex;
	}
	public void setUserSex(boolean userSex) {
		this.userSex = userSex;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public long getUserTel() {
		return userTel;
	}
	public void setUserTel(long userTel) {
		this.userTel = userTel;
	}
	public boolean isUserRole() {
		return userRole;
	}
	public void setUserRole(boolean userRole) {
		this.userRole = userRole;
	}
	public boolean isUserLock() {
		return userLock;
	}
	public void setUserLock(boolean userLock) {
		this.userLock = userLock;
	}
	@Override
	public String toString() {
		return "UserInfo [userNo=" + userNo + ", userName=" + userName
				+ ", userPwd=" + userPwd + ", userRealName=" + userRealName
				+",userSex="+userSex+ ", num=" + num + ", userAge=" + userAge
				+ ", userTel="+ userTel + ", userRole=" + userRole + ", userLock="
				+ userLock+ "]";
	}
	
	
}
