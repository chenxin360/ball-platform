package com.zshnb.ballplatform.dto;

public class ActivityDto {
	private Integer id;

	private String theme;

	private String content;

	private String phone;

	private Integer personCount;

	private String excel;

	private String sportItemName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPersonCount() {
		return personCount;
	}

	public void setPersonCount(Integer personCount) {
		this.personCount = personCount;
	}

	public String getExcel() {
		return excel;
	}

	public void setExcel(String excel) {
		this.excel = excel;
	}

	public String getSportItemName() {
		return sportItemName;
	}

	public void setSportItemName(String sportItemName) {
		this.sportItemName = sportItemName;
	}
}
