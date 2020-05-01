package com.zshnb.ballplatform.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class AddSportSiteOrderRequest {
	private int sportSiteId = 0;
	private double price = 0.0;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private LocalDateTime startAt;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private LocalDateTime endAt;

	public int getSportSiteId() {
		return sportSiteId;
	}

	public void setSportSiteId(int sportSiteId) {
		this.sportSiteId = sportSiteId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
