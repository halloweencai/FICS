package com.team12.web.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.team12.web.model.AdvancedGroup;
import com.team12.web.model.AdvancedGroupId;
import com.team12.web.model.AdvancedPerson;

public interface AdvancedGroupService {
	public JSONObject add(AdvancedGroup advancedGroup);

	public JSONObject update(AdvancedGroup advancedGroup);
	
	public JSONObject delete(AdvancedGroupId id);
	
	public AdvancedGroup findByAdvancedGroupId(AdvancedGroupId id);
	
	public List<AdvancedGroup> findAll();
}

