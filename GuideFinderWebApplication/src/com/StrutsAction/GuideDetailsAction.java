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
public class GuideDetailsAction extends ActionSupport{
	private GuideManager guideManager;
	private String ID=null;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String root = ServletActionContext.getRequest().getRealPath("/");
		String path= root+"GuideInfo/";
		List list=guideManager.GetGuideList();
		//List<Guide_Info> guideDetailList=new ArrayList<Guide_Info>();
		int i=(int)ActionContext.getContext().getSession().get("id");
		if(ID!=null){
			i=Integer.valueOf(ID);
			ActionContext.getContext().getSession().put("temporaryGuide", i);
		}
		Guide_Info info=new Guide_Info();
		for(Object o:list){
			info=(Guide_Info)o;
			if(info.getGuide_ID()==i){
				String content=null;
				content=uploadFileUtil.readFromTXT("tips", path , String.valueOf(info.getGuide_ID()));
				String filepath="GuideInfo/"+String.valueOf(info.getGuide_ID())+"/"+info.getHeadicon();
				info.setHeadicon(filepath);
				info.setTips(content);
				break;
				//guideDetailList.add(info);
			}
		}
		List<String> photoList=new ArrayList<String>();
		photoList=uploadFileUtil.getAllFileName(root+"GuideInfo/"+String.valueOf(i)+"/"+"photos","GuideInfo/"+String.valueOf(i)+"/"+"photos/");
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		//System.out.println(info.getHeadicon());
		request.setAttribute("guideDetails", info);
		request.setAttribute("photolist", photoList);
		ID=null;
		return null;
	}

	public GuideManager getGuideManager() {
		return guideManager;
	}

	public void setGuideManager(GuideManager guideManager) {
		this.guideManager = guideManager;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	
	

}
