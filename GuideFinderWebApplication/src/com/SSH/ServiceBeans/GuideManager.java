package com.SSH.ServiceBeans;

import java.util.List;

import com.SSH.Forms.GuideForm;

public interface GuideManager {
	public void Register(GuideForm form);
	public List GetGuideList();
}
