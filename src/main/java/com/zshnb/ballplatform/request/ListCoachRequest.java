package com.zshnb.ballplatform.request;

public class ListCoachRequest extends PageRequest{
	private int sportItemId = 0;
	private String sportLevel = "";
	private double minPrice = Double.MIN_VALUE;
	private double maxPrice = Double.MAX_VALUE;

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

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
}
