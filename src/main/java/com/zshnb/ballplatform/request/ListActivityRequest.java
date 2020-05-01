package com.zshnb.ballplatform.request;

public class ListActivityRequest extends PageRequest {
	private int sportItemId = 0;

	public int getSportItemId() {
		return sportItemId;
	}

	public void setSportItemId(int sportItemId) {
		this.sportItemId = sportItemId;
	}
}
