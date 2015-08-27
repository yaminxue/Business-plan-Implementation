package com.StrutsAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.SSH.ServiceBeanImpls.SearchRemindItem;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AjaxSearchReminder extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5539146444636195014L;
	private String q;
	
	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		list=Arrays.asList(SearchRemindItem.getSearchItem());
		
		String keyword=this.q;
		//System.out.println(keyword);
		//keyword="D";
		List<String> selectedList=new ArrayList<String>();
		for(String s:list){
			boolean match=true;
			for(int i=0;i<keyword.length();i++){
				if(keyword.charAt(i)==s.charAt(i)||keyword.charAt(i)+32==s.charAt(i)||
						keyword.charAt(i)-32==s.charAt(i)){
					
				}
				else{
					match=false;
				}
				
			}
			if(match==true){
				selectedList.add(s);
			}
		}
		JSONArray jsonArray=JSONArray.fromObject(selectedList);
		HttpServletResponse response=(HttpServletResponse)ActionContext.getContext().get(
				ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonArray);
		return null;
		
	}
	

}
