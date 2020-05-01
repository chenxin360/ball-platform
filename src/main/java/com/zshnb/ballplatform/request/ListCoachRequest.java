package com.zshnb.ballplatform.request;

public class ListCoachRequest extends PageRequest {
	private String name = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
