package com.SSH.Forms;

public class OrderForm {
	
	private String startTime;
	private String endTime;
	private String city;
	private int number;
	private String comment;
	private int guide_ID;
	private int traveler_ID;
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getGuide_ID() {
		return guide_ID;
	}
	public void setGuide_ID(int guide_ID) {
		this.guide_ID = guide_ID;
	}
	public int getTraveler_ID() {
		return traveler_ID;
	}
	public void setTraveler_ID(int traveler_ID) {
		this.traveler_ID = traveler_ID;
	}
	

}
