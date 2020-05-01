package com.zshnb.ballplatform.request.backend;

import com.zshnb.ballplatform.request.PageRequest;

public class ListActivityRequest extends PageRequest {
	private String theme = "";

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
}
