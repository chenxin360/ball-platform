package com.zshnb.ballplatform.request;

public class ListBillRequest extends PageRequest {
	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
