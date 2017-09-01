package com.team12.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.team12.web.dao.AdvancedGroupDAO;
import com.team12.web.dao.AdvancedGroupDAO;
import com.team12.web.model.AdvancedGroup;
import com.team12.web.model.AdvancedGroupId;
import com.team12.web.model.AdvancedPerson;
import com.team12.web.service.AdvancedGroupService;
/**

* 先进集体服务

* @author 黄鼎中

* @Time 2017-07-24 19:34:01

*/
@Service

public class AdvancedGroupServiceImpl implements AdvancedGroupService {

	@Resource
	private AdvancedGroupDAO advancedGroupDAO ;
	
	@Override
	public JSONObject add(AdvancedGroup advancedGroup) {
		JSONObject jsonObject = new JSONObject();
		try{
			advancedGroupDAO.save(advancedGroup);
			jsonObject.put("msg", "先进集体信息申报成功");
		}catch(Exception e){
			jsonObject.put("msg", "先进集体信息申报失败");
		}
		return jsonObject;
	}
	
	@Override
	public JSONObject update(AdvancedGroup advancedGroup) {
		JSONObject jsonObject = new JSONObject();
		AdvancedGroup persistentGroup = advancedGroupDAO.findById(advancedGroup.getId());
		if(persistentGroup==null){
			jsonObject.put("msg", "该集体不是先进集体！");
		}else {
			BeanUtils.copyProperties(advancedGroup, persistentGroup);
			advancedGroupDAO.attachDirty(persistentGroup);
			jsonObject.put("msg", "先进集体信息更新成功！");
		}
		return jsonObject;
	}
	
	@Override
	public JSONObject delete(AdvancedGroupId id){
		JSONObject jsonObject = new JSONObject();
		AdvancedGroup persistentGroup = advancedGroupDAO.findById(id);
		if(persistentGroup==null){
			jsonObject.put("msg", "该集体不是先进集体！");
		}else {
				advancedGroupDAO.delete(persistentGroup);
				jsonObject.put("msg", "该先进集体已删除！");
		}
		return jsonObject;
	}
	
	@Override
	public List<AdvancedGroup> findAll() {
		return advancedGroupDAO.findAll();
	}

	@Override
	public AdvancedGroup findByAdvancedGroupId(AdvancedGroupId id) {
		// TODO Auto-generated method stub
		return advancedGroupDAO.findById(id);
	}
}
