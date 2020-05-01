package com.zshnb.ballplatform.request.backend;

import com.zshnb.ballplatform.request.PageRequest;

public class ListSportItemRequest extends PageRequest {
	private String name = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
