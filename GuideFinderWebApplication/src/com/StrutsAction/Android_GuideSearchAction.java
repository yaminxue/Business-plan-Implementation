package com.StrutsAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SSH.Beans.Guide;
import com.SSH.Beans.Guide_Info;
import com.SSH.ServiceBeans.GuideManager;
import com.opensymphony.xwork2.ActionSupport;
import com.utils.uploadFileUtil;

@SuppressWarnings("serial")
public class Android_GuideSearchAction extends ActionSupport
				implements ServletRequestAware, ServletResponseAware{
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private String city;
	private String guide_ID;
	private GuideManager manager;
	private List<Guide_Info> guideList;
	private Map<String,Object> dataMap;
	

	public Android_GuideSearchAction() {
		super();
		guideList=new ArrayList<Guide_Info>();
		dataMap=new HashMap<String,Object>();
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		response=arg0;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request=arg0;
		
	}

	
	public String searchGuideList() throws Exception {
		// TODO Auto-generated method stub
		this.dataMap.clear();
		this.guideList.clear();
		String root = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"+"GuideInfo/";
		List<Guide_Info> list=new ArrayList<Guide_Info>();
		for(Object o:this.manager.GetGuideList()){
			Guide_Info guide=(Guide_Info)o;
			if(guide.getCity().equalsIgnoreCase(city)){
				guide.setHeadicon(root+Integer.valueOf(guide.getGuide_ID())+"/"+guide.getHeadicon());
				this.guideList.add(guide);
			}
		}
		if(this.guideList.isEmpty()){
			dataMap.put("isEmpty", true);
		}else{
			dataMap.put("isEmpty", false);
			dataMap.put("guidelist", this.guideList);
		}
		return SUCCESS;
	}
	public String searchGuideDetail(){
		this.dataMap.clear();
		String root = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"+"GuideInfo/";
		String path = ServletActionContext.getRequest().getRealPath("/")+"GuideInfo/";
		List list=this.manager.GetGuideList();
		for(Object o:list){
			Guide_Info guide=(Guide_Info)o;
			if(guide.getGuide_ID()==Integer.valueOf(guide_ID)){
				guide.setHeadicon(root+guide_ID+"/"+guide.getHeadicon());
				
				String content=null;
				try{
					content=uploadFileUtil.readFromTXT("tips", path , String.valueOf(guide.getGuide_ID()));
				}catch(Exception e){
					content="  ";
				}
				guide.setTips(content);
				dataMap.put("guide", guide);
			}
		}
		
		List<String> photoList=uploadFileUtil.getAllFileName(path+guide_ID+"/"+"photos", 
				root+guide_ID+"/"+"photos/");
		dataMap.put("photosList", photoList);
		
		return SUCCESS;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public GuideManager getManager() {
		return manager;
	}

	public void setManager(GuideManager manager) {
		this.manager = manager;
	}

	public List<Guide_Info> getGuideList() {
		return guideList;
	}

	public void setGuideList(List<Guide_Info> guideList) {
		this.guideList = guideList;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String getGuide_ID() {
		return guide_ID;
	}

	public void setGuide_ID(String guide_ID) {
		this.guide_ID = guide_ID;
	}
	
	
	
	
	
	

}
