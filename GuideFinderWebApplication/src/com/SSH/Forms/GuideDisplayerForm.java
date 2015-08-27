package com.SSH.Forms;

public class GuideDisplayerForm {
	private int id;
	private String name;
	private String details;
	private String filepath;
	
	
	public GuideDisplayerForm(String name, String details, String filepath) {
		super();
		this.name = name;
		this.details = details;
		this.filepath = filepath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
