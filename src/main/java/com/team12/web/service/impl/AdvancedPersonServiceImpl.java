package com.team12.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.team12.web.dao.AdvancedPersonDAO;
import com.team12.web.model.AdvancedPerson;
import com.team12.web.service.AdvancedPersonService;

/**
 * 
 * 先进个人服务
 * 
 * @author 李俊
 * 
 * @Time 2017-07-24 12:58:01
 * 
 */
@Service
public class AdvancedPersonServiceImpl implements AdvancedPersonService {

	@Resource
	private AdvancedPersonDAO advancedPersonDAO;

	@Override
	public JSONObject add(AdvancedPerson advancedPerson) {
		JSONObject jsonObject = new JSONObject();
		try {
			advancedPersonDAO.save(advancedPerson);
			jsonObject.put("msg", "先进个人信息申报成功");
		} catch (Exception e) {
			jsonObject.put("msg", "先进个人信息申报失败");
		}
		return jsonObject;
	}

	@Override
	public JSONObject update(AdvancedPerson advancedPerson) {
		JSONObject jsonObject = new JSONObject();
		AdvancedPerson persistentPerson = advancedPersonDAO.findById(advancedPerson.getIdnumber());
		if (persistentPerson == null) {
			jsonObject.put("msg", "先进个人信息不存在！");
		} else {
			if (persistentPerson.getModelWorkerStatus().equals("新上报")) {
				BeanUtils.copyProperties(advancedPerson, persistentPerson);
				advancedPersonDAO.attachDirty(persistentPerson);
				jsonObject.put("msg", "先进个人信息修改成功！");
			} else {
				jsonObject.put("msg", "已被认定的劳模信息不允许修改！");
			}
		}
		return jsonObject;
	}

	@Override
	public JSONObject delete(String id) {
		JSONObject jsonObject = new JSONObject();
		AdvancedPerson persistentPerson = advancedPersonDAO.findById(id);
		if (persistentPerson == null) {
			jsonObject.put("msg", "先进个人信息不存在！");
		} else {
			advancedPersonDAO.delete(persistentPerson);
			jsonObject.put("msg", "先进个人信息已删除！");
		}
		return jsonObject;
	}

	@Override
	public AdvancedPerson findById(String id) {
		return advancedPersonDAO.findById(id);
	}
	
	@Override
	public List<AdvancedPerson> findAll() {
		return advancedPersonDAO.findAll();
	}

}
