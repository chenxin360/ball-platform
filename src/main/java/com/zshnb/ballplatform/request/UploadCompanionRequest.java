package com.zshnb.ballplatform.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class UploadCompanionRequest {
	private int sportItemId = 0;

	private String sportLevel = "";

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private LocalDateTime time;

	private int sportSiteId = 0;

	private String sex = "";

	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getSportItemId() {
		return sportItemId;
	}

	public void setSportItemId(int sportItemId) {
		this.sportItemId = sportItemId;
	}

	public String getSportLevel() {
		return sportLevel;
	}

	public void setSportLevel(String sportLevel) {
		this.sportLevel = sportLevel;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public int getSportSiteId() {
		return sportSiteId;
	}

	public void setSportSiteId(int sportSiteId) {
		this.sportSiteId = sportSiteId;
	}
}
