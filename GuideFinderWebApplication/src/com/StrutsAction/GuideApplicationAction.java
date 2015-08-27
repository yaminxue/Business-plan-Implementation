package com.StrutsAction;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.SSH.Forms.GuideForm;
import com.SSH.ServiceBeans.GuideManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.utils.uploadFileUtil;



public class GuideApplicationAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 610529979998580359L;
	
	private String name;
	private String age;
	private String nation;
	private String city;
	private String gender;
	private String duration;
	private String occupation;
	private String hometown;
	private String exp;
	private String language;
	private String car;
	private String cartype;
	private String tips;
	private String detail;
	private File img;
	private GuideForm guide;
	private String imgFileName;
	private String imgContentType;
	private String dataUrl;
	private GuideManager guideManager;
	

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		setGuide();
		this.guideManager.Register(guide);
		String root = ServletActionContext.getRequest().getRealPath("/");
		System.out.println(root);
		String path= root+"GuideInfo/";
		int id=(int)ActionContext.getContext().getSession().get("id");
		
		uploadFileUtil.upload(this.img,this.imgFileName, path, String.valueOf(id));
		
		uploadFileUtil.upload(this.detail, "tips", path, String.valueOf(id));
		//System.out.println(fileFileName);
		return SUCCESS;
	}


//	public File getFile() {
//		return upload;
//	}
//
//
//	public void setFile(File file) {
//		this.upload = file;
//	}

	private void setGuide(){
		this.guide=new GuideForm();
		this.guide.setAge(Integer.valueOf(this.age));
		this.guide.setCar(this.car);
		this.guide.setCartype(this.cartype);
		this.guide.setCity(this.city);
		this.guide.setDuration(this.duration);
		this.guide.setExp(this.exp);
		this.guide.setGender(this.gender);
		this.guide.setHometown(this.hometown);
		this.guide.setHeadicon(this.imgFileName);
		
		this.guide.setLanguage(this.language);
		this.guide.setName(this.name);
		this.guide.setNation(this.nation);
		this.guide.setOccupation(this.occupation);
		this.guide.setTips(this.tips);
		this.guide.setguide_ID((int)ActionContext.getContext().getSession().get("id"));
		//System.out.println(this.guide.getguide_ID());
		
	}
	public String getFileFileName() {
		return imgFileName;
	}


	public GuideForm getGuide() {
		return guide;
	}


	public void setGuide(GuideForm guide) {
		this.guide = guide;
	}


	public void setFileFileName(String fileFileName) {
		this.imgFileName = fileFileName;
	}


	public String getFileContentType() {
		return imgContentType;
	}


	public void setFileContentType(String fileContentType) {
		this.imgContentType = fileContentType;
	}


	public String getDataUrl() {
		return dataUrl;
	}


	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getNation() {
		return nation;
	}


	public void setNation(String nation) {
		this.nation = nation;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public String getOccupation() {
		return occupation;
	}


	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}


	public String getHometown() {
		return hometown;
	}


	public void setHometown(String hometown) {
		this.hometown = hometown;
	}


	public String getExp() {
		return exp;
	}


	public void setExp(String exp) {
		this.exp = exp;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getCar() {
		return car;
	}


	public void setCar(String car) {
		this.car = car;
	}


	public String getCartype() {
		return cartype;
	}


	public void setCartype(String cartype) {
		this.cartype = cartype;
	}


	public String getTips() {
		return tips;
	}


	public void setTips(String tips) {
		this.tips = tips;
	}


	public File getImg() {
		return img;
	}


	public void setImg(File img) {
		this.img = img;
	}


	public String getImgFileName() {
		return imgFileName;
	}


	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}


	public String getImgContentType() {
		return imgContentType;
	}


	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public GuideManager getguideManager() {
		return guideManager;
	}


	public void setguideManager(GuideManager guideManager) {
		this.guideManager = guideManager;
	}
	

}
