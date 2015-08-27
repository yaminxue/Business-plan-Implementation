package com.StrutsAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.SSH.Beans.Guide_Info;
import com.SSH.ServiceBeans.GuideManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.utils.uploadFileUtil;

@SuppressWarnings("serial")
public class GuideSearchAction extends ActionSupport {
	private GuideManager guideManager;
	private String kn;
	private String ts;
	private String te;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String root = ServletActionContext.getRequest().getRealPath("/");
		String path= root+"GuideInfo/";
		List list=guideManager.GetGuideList();
		List<Guide_Info> guideDetailList=new ArrayList<Guide_Info>();
		
		Guide_Info info=new Guide_Info();
		for(Object o:list){
			info=(Guide_Info)o;
			if(info.getCity().equalsIgnoreCase(kn)){
			//if(kn.startsWith(info.getCity())){
				String content=null;
				content=uploadFileUtil.readFromTXT("tips", path , String.valueOf(info.getGuide_ID()));
				String filepath="GuideInfo/"+String.valueOf(info.getGuide_ID())+"/"+info.getHeadicon();
				info.setHeadicon(filepath);
				//System.out.println(filepath);
				info.setTips(content);
				
				guideDetailList.add(info);
			}
		}
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("SearchedGuideList", guideDetailList);
//		System.out.println(guideDetailList.size());
//		int counter=0;
//		while(guideDetailList.size()!=0){
//			counter++;
//			List<Guide_Info> bufferedList=new ArrayList<Guide_Info>();
//			for(int i=0;i<3;i++){
//				if(guideDetailList.size()>0){
//					bufferedList.add(guideDetailList.get(0));
//					guideDetailList.remove(0);
//				}
//			}
//			request.setAttribute("searchedGuides"+String.valueOf(counter), bufferedList);
//		}
		request.setAttribute("SearchedPlace", kn);
		
		
		return SUCCESS;
	}

	public GuideManager getGuideManager() {
		return guideManager;
	}

	public void setGuideManager(GuideManager guideManager) {
		this.guideManager = guideManager;
	}

	public String getKn() {
		return kn;
	}

	public void setKn(String kn) {
		this.kn = kn;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getTe() {
		return te;
	}

	public void setTe(String te) {
		this.te = te;
	}
	

}
