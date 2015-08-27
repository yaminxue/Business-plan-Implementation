package com.StrutsAction;

import java.io.File;
import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.utils.uploadFileUtil;

@SuppressWarnings("serial")
public class GuidePhotsUploadAction extends ActionSupport{
	private String photosUploadFileName;
	private File photosUpload;
	
	public String upload(){
		String root = ServletActionContext.getRequest().getRealPath("/");
		String path= root+"GuideInfo/";
		int id=(int)ActionContext.getContext().getSession().get("id");
		try{
			uploadFileUtil.upload(this.photosUpload,this.photosUploadFileName, path, String.valueOf(id),"photos");
			return SUCCESS;
		}catch(IOException e){
			return  ERROR;
		}
	}
	
	public String getPhotosUploadFileName() {
		return photosUploadFileName;
	}

	public void setPhotosUploadFileName(String photosUploadFileName) {
		this.photosUploadFileName = photosUploadFileName;
	}

	public File getPhotosUpload() {
		return photosUpload;
	}
	public void setPhotosUpload(File photosUpload) {
		this.photosUpload = photosUpload;
	}
	

}
