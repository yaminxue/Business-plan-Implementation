package com.StrutsAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.SSH.Beans.Guide_Info;
import com.SSH.Forms.GuideDisplayerForm;
import com.SSH.ServiceBeans.GuideManager;
import com.opensymphony.xwork2.ActionSupport;
import com.utils.uploadFileUtil;

public class AjaxGuideSelector extends ActionSupport{
	private GuideManager guideManager;

	/**
	 * 
	 */
	private static final long serialVersionUID = 3411930578863967637L;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String root = ServletActionContext.getRequest().getRealPath("/");
		String path= root+"GuideInfo/";
		List list=guideManager.GetGuideList();
		List<GuideDisplayerForm> displayList=new ArrayList<GuideDisplayerForm>();
		for(Object i:list){
			Guide_Info info=(Guide_Info)i;
			String content=null;
			content=uploadFileUtil.readFromTXT("tips", path , String.valueOf(info.getGuide_ID()));
			String filepath="GuideInfo/"+String.valueOf(info.getGuide_ID())+"/"+info.getHeadicon();
			GuideDisplayerForm form=new GuideDisplayerForm(info.getName(),content,filepath);
			form.setId(info.getGuide_ID());
			displayList.add(form);
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		   request.setAttribute("guideList", displayList);
		
		return null;
	}

	public GuideManager getGuideManager() {
		return guideManager;
	}

	public void setGuideManager(GuideManager guideManager) {
		this.guideManager = guideManager;
	}
	
	
	

}
