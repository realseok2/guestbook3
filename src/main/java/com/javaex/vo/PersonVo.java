package com.javaex.vo;

public class PersonVo {

//------------------------------------------------------------------------------------		필드

	private int no; // 게시물 코드
	private String name; // 작성자 이름
	private String pw; // 작성글 패스워드
	private String content; // 작성글 내용
	private String regDate; // 작성글 날짜

//------------------------------------------------------------------------------------		생성자

	public PersonVo() {

	}

	public PersonVo(int no, String pw) {
		this.no = no;
		this.pw = pw;
	}

	public PersonVo(String name, String pw, String content) {
		this.name = name;
		this.pw = pw;
		this.content = content;
	}

	public PersonVo(int no, String name, String pw, String content) {
		this.no = no;
		this.name = name;
		this.pw = pw;
		this.content = content;
	}

	public PersonVo(int no, String name, String pw, String content, String regDate) {
		this.no = no;
		this.name = name;
		this.pw = pw;
		this.content = content;
		this.regDate = regDate;
	}

//------------------------------------------------------------------------------------		getter, setter

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

//------------------------------------------------------------------------------------		일반 메소드

//------------------------------------------------------------------------------------		toString()

	@Override
	public String toString() {
		return "PersonVo [no=" + no + ", name=" + name + ", pw=" + pw + ", content=" + content + ", regDate=" + regDate
				+ "]";
	}

}