package com.team12.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.team12.web.model.AdvancedPerson;
import com.team12.web.service.AdvancedPersonService;
import com.team12.web.service.HonorService;

/**
 * 
 * 先进个人控制器
 * 
 * @author 李俊
 * 
 * @Time 2017-07-25 09:10:01
 * 
 */

@Controller
@RequestMapping("advancedperson")
public class AdvancedPersonController {

	@Resource
	private AdvancedPersonService advancedPersonService;

	/**
	 * 先进个人申报
	 */
	@RequestMapping("/add")
	public void addAdvancePerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("idnumber");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String nation = request.getParameter("nation");
		String birthday = request.getParameter("birthday");
		String politicalStatus = request.getParameter("politicalStatus");
		String degreeOfEducation = request.getParameter("degreeOfEducation");
		String telephoneNumber = request.getParameter("telephoneNumber");
		String workplace = request.getParameter("workplace");
		String job = request.getParameter("job");
		String healthStatus = request.getParameter("healthStatus");
		String cityOwnedIndutries = request.getParameter("cityOwnedIndutries");
		String employmentStatus = request.getParameter("employmentStatus");
		String familyTrouble = request.getParameter("familyTrouble");
		String outstandingDeeds = request.getParameter("outstandingDeeds");
		String honoraryTitle = request.getParameter("honoraryTitle");
		String treament = request.getParameter("treament");
		String modelWorkerStatus = request.getParameter("modelWorkerStatus");
		String modelWorkerTitle = request.getParameter("modelWorkerTitle");
		
		Date birthdayDate = new Date(Long.parseLong(birthday));

		AdvancedPerson advancedPerson = new AdvancedPerson(id, name, sex, nation, birthdayDate, politicalStatus,
				degreeOfEducation, telephoneNumber, workplace, job, healthStatus, cityOwnedIndutries, employmentStatus,
				familyTrouble, outstandingDeeds, honoraryTitle, treament, modelWorkerStatus, modelWorkerTitle, null);
		
		PrintWriter out = response.getWriter();
        out.println(advancedPersonService.add(advancedPerson));
        out.flush();
        out.close();
	}
	
	/**
	 * 先进个人修改
	 */
	@RequestMapping("/update")
	public void updateAdvancePerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("idnumber");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String nation = request.getParameter("nation");
		String birthday = request.getParameter("birthday");
		String politicalStatus = request.getParameter("politicalStatus");
		String degreeOfEducation = request.getParameter("degreeOfEducation");
		String telephoneNumber = request.getParameter("telephoneNumber");
		String workplace = request.getParameter("workplace");
		String job = request.getParameter("job");
		String healthStatus = request.getParameter("healthStatus");
		String cityOwnedIndutries = request.getParameter("cityOwnedIndutries");
		String employmentStatus = request.getParameter("employmentStatus");
		String familyTrouble = request.getParameter("familyTrouble");
		String outstandingDeeds = request.getParameter("outstandingDeeds");
		String honoraryTitle = request.getParameter("honoraryTitle");
		String treament = request.getParameter("treament");
		String modelWorkerStatus = request.getParameter("modelWorkerStatus");
		String modelWorkerTitle = request.getParameter("modelWorkerTitle");
		
		Date birthdayDate = new Date(Long.parseLong(birthday));


		AdvancedPerson advancedPerson = new AdvancedPerson(id, name, sex, nation, birthdayDate, politicalStatus,
				degreeOfEducation, telephoneNumber, workplace, job, healthStatus, cityOwnedIndutries, employmentStatus,
				familyTrouble, outstandingDeeds, honoraryTitle, treament, modelWorkerStatus, modelWorkerTitle, null);
		
		PrintWriter out = response.getWriter();
        out.println(advancedPersonService.update(advancedPerson));
        out.flush();
        out.close();
	}
	
	/**
	 * 先进个人删除
	 */
	@RequestMapping("/delete")
	public void deleteAdvancePerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("idnumber");
		PrintWriter out = response.getWriter();
        out.println(advancedPersonService.delete(id));
        out.flush();
        out.close();
	}
	
	/**
	 * 先进个人查询
	 */
	@RequestMapping("/find")
	public void findById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("idnumber");
		
		PrintWriter out = response.getWriter();
		System.out.println(JSONObject.toJSONString(advancedPersonService.findById(id)));
		JSONArray resultJsonArray = new JSONArray();
		JSONObject resultJsonObject  = new JSONObject();
		resultJsonArray.add(advancedPersonService.findById(id));
		resultJsonObject.put("msg", "获取成功");
		resultJsonObject.put("rel", true);
		resultJsonObject.put("list", resultJsonArray);
		resultJsonObject.put("count", 5);
        out.println(resultJsonObject);
        out.flush();
        out.close();
	}
	
	/**
	 * 先进个人查询
	 */
	@RequestMapping("/find2")
	public void findById2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("idnumber");
		
		PrintWriter out = response.getWriter();
		//System.out.println(JSONObject.toJSONString(advancedPersonService.findById(id)));
        out.println(JSONObject.toJSONString(advancedPersonService.findById(id)));
        out.flush();
        out.close();
	}
	
	/**
	 * 先进个人获取
	 */
	@RequestMapping("/getAll")
	public void getAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		JSONObject resultJsonObject  = new JSONObject();
		JSONArray resultJsonArray = new JSONArray();
		resultJsonArray.addAll(advancedPersonService.findAll());
		resultJsonObject.put("msg", "获取成功");
		resultJsonObject.put("rel", true);
		resultJsonObject.put("list", resultJsonArray);
		resultJsonObject.put("count", 5);
		out.println(resultJsonObject);
        out.flush();
        out.close();
	}
	
}
