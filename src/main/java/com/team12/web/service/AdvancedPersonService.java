package com.team12.web.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.team12.web.model.AdvancedPerson;

public interface AdvancedPersonService {
	public JSONObject add(AdvancedPerson advancedPerson);

	public JSONObject update(AdvancedPerson advancedPerson);
	
	public JSONObject delete(String id);
	
	public AdvancedPerson findById(String id);
	
	public List<AdvancedPerson> findAll();
}
