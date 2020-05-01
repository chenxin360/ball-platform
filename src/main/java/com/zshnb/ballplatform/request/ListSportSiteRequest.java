package com.zshnb.ballplatform.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class ListSportSiteRequest extends PageRequest {

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private LocalDateTime startAt = LocalDateTime.MIN;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private LocalDateTime endAt = LocalDateTime.now();
	private String name = "";
	private int minPersonCount = 0;
	private int maxPersonCount = Integer.MAX_VALUE;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinPersonCount() {
		return minPersonCount;
	}

	public void setMinPersonCount(int minPersonCount) {
		this.minPersonCount = minPersonCount;
	}

	public int getMaxPersonCount() {
		return maxPersonCount;
	}

	public void setMaxPersonCount(int maxPersonCount) {
		this.maxPersonCount = maxPersonCount;
	}
}
