package com.zshnb.ballplatform.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class ListCompanionRequest extends PageRequest{
	private int userId;
	private int sportItemId = 0;
	private String sportLevel = "";
	private String sex = "";
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private LocalDateTime startAt = LocalDateTime.MIN;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private LocalDateTime endAt = LocalDateTime.MAX;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public LocalDateTime getStartAt() {
		return startAt;
	}

	public void setStartAt(LocalDateTime startAt) {
		this.startAt = startAt;
	}

	public LocalDateTime getEndAt() {
		return endAt;
	}

	public void setEndAt(LocalDateTime endAt) {
		this.endAt = endAt;
	}
}
