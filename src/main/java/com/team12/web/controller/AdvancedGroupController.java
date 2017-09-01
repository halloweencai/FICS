package com.team12.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.team12.web.model.AdvancedGroup;
import com.team12.web.model.AdvancedGroupId;
import com.team12.web.service.AdvancedGroupService;


/**
 * 
 * 先进集体控制器
 * 
 * @author 黄鼎中
 * 
 * @Time 2017-07-25 09:13:01
 * 
 */

@Controller
@RequestMapping("advancedgroup")
public class AdvancedGroupController {

	@Resource
	private AdvancedGroupService advancedGroupService;

	/**
	 * 先进集体申报
	 */
	@RequestMapping("/add")
	public void addAdvanceGroup(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String unitName = request.getParameter("unitName");
		String cityOwnedIndutries = request.getParameter("cityOwnedIndutries");
		String personInCharge = request.getParameter("personInCharge");
		String honoraryTitle = request.getParameter("honoraryTitle");
		
		long telephoneNumber = Long.parseLong(request.getParameter("telephoneNumber"));
		String outstandingDeeds = request.getParameter("outstandingDeeds");
	
		AdvancedGroupId id = new AdvancedGroupId(unitName,cityOwnedIndutries);
		AdvancedGroup advancedGroup = new AdvancedGroup(id,personInCharge,telephoneNumber,outstandingDeeds,honoraryTitle);
		
		PrintWriter out = response.getWriter();
        out.println(advancedGroupService.add(advancedGroup));
        out.flush();
        out.close();
	}
	
	/**
	 * 先进集体修改
	 */
	@RequestMapping("/update")
	//主键的两个字段是不能被修改的
	//如果有些项没有修改，前台默认返回原来的值
	//这样做个人觉得不太合理
	public void updateAdvanceGroup(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String unitName = request.getParameter("unitName");
		String cityOwnedIndutries = request.getParameter("cityOwnedIndutries");
		String personInCharge = request.getParameter("personInCharge");
	    long telephoneNumber = Long.parseLong(request.getParameter("telephoneNumber"));
		String outstandingDeeds = request.getParameter("outstandingDeeds");
		String honoraryTitle = request.getParameter("honoraryTitle");
	
        AdvancedGroupId id = new AdvancedGroupId(unitName,cityOwnedIndutries);
		AdvancedGroup advancedGroup = new AdvancedGroup(id,personInCharge,telephoneNumber,outstandingDeeds,honoraryTitle);
		//advancedGroup.setOutstandingDeeds(outstandingDeeds);
		PrintWriter out = response.getWriter();
        out.println(advancedGroupService.update(advancedGroup));
        out.flush();
        out.close();
	}
	
	/**
	 * 先进集体删除
	 */
	@RequestMapping("/delete")
	public void deleteAdvanceGroup(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String unitName = request.getParameter("unitName");
		String cityOwnedIndutries = request.getParameter("cityOwnedIndutries");
		AdvancedGroupId id = new AdvancedGroupId(unitName,cityOwnedIndutries);
		
		PrintWriter out = response.getWriter();
        out.println(advancedGroupService.delete(id));
        out.flush();
        out.close();
	}
	
	/**
	 * 先进个人查询
	 */
	@RequestMapping("/find")
	public void findByAdvancedGroupId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String unitName = request.getParameter("unitName");
		String cityOwnedIndutries = request.getParameter("cityOwnedIndutries");
		AdvancedGroupId id = new AdvancedGroupId(unitName , cityOwnedIndutries);
		
		PrintWriter out = response.getWriter();
		System.out.println(JSONObject.toJSONString(advancedGroupService.findByAdvancedGroupId(id)));
		JSONArray resultJsonArray = new JSONArray();
		JSONObject resultJsonObject  = new JSONObject();
		resultJsonArray.add(advancedGroupService.findByAdvancedGroupId(id));
		resultJsonObject.put("msg", "获取成功");
		resultJsonObject.put("rel", true);
		resultJsonObject.put("list", resultJsonArray);
		resultJsonObject.put("count", 5);
        out.println(resultJsonObject);
        out.flush();
        out.close();
	}
	
	/**
	 * 先进集体查询
	 */
	@RequestMapping("/find2")
	public void findByAdvancedGroupId2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String unitName = request.getParameter("unitName");
		String cityOwnedIndutries = request.getParameter("cityOwnedIndutries");
		
		PrintWriter out = response.getWriter();
		AdvancedGroupId id = new AdvancedGroupId(unitName , cityOwnedIndutries);
		//System.out.println(JSONObject.toJSONString(advancedPersonService.findById(id)));
        out.println(JSONObject.toJSONString(advancedGroupService.findByAdvancedGroupId(id)));
        out.flush();
        out.close();
	}
	/**
	 * 先进集体获取
	 */
	@RequestMapping("/getAll")
	public void getAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		JSONObject resultJsonObject  = new JSONObject();
		JSONArray resultJsonArray = new JSONArray();
		resultJsonArray.addAll(advancedGroupService.findAll());
		resultJsonObject.put("msg", "获取成功");
		resultJsonObject.put("rel", true);
		resultJsonObject.put("list", resultJsonArray);
		resultJsonObject.put("count", 5);
		out.println(resultJsonObject);
        out.flush();
        out.close();
	}
}
