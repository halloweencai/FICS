package com.team12.web.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.team12.web.model.*;

public interface HonorService {
	
	public void insertTestData();
	
	public JSONArray findAll();
	
	/**
	 * 完全匹配
	 * 仅搜索AdvancedPerson中类型为String的属性
	 */
	public JSONArray findByAdvancedPerson(String string);
	
	public JSONArray findByHonoraryTitle(String honoraryTitle);
	
	public JSONArray findByJob(String job);
	
	public JSONArray findByModelWorkerStatus(String modelWorkerStatus);
	
	public JSONArray findByTreatment(String treatment);

	public JSONArray findByAdvancedPersonWithAssert(String advancedPerson,String _assert);
	
	public JSONArray findByHonoraryTitleWithAssert(String honoraryTitle,String _assert);
	
	public JSONArray findByJobWithAssert(String job,String _assert);
	
	public JSONArray findByModelWorkerStatusWithAssert(String modelWorkerStatus,String _assert);
	
	public JSONArray findByTreatmentWithAssert(String treatment,String _assert);
	
	public JSONArray findByAdvancedPersons(List<AdvancedPerson> advancedPersons);
	
	public JSONObject update(Honor honor);
	
	/**********************************************************************************************/

	public JSONArray findByName(String name);//for test
	
	public JSONArray findByRecord(String record);//for test
	
	public AdvancedPerson findByPersonID(String ID);//for test
}
