package com.team12.web.controller;

import java.io.PrintWriter;
import java.lang.reflect.Field;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.team12.web.model.AdvancedPerson;
import com.team12.web.model.Honor;
import com.team12.web.service.AdvancedPersonService;
import com.team12.web.service.HonorService;

@Controller
@RequestMapping("/honor")
public class HonorController {

	@Resource
	HonorService honorService;
	
	@Resource
	AdvancedPersonService advancedPersonService;
	
	@RequestMapping("/search")
	public void searchPeople(HttpServletRequest request,HttpServletResponse response){
		//searchRequirement2--已认定，未认定，未选定则值为null
		boolean isSearchWithAssert = request.getParameter("searchRequirement2") == null;
		JSONArray jArray = new JSONArray();
		switch (request.getParameter("searchRequirement1")){
			case "基本情况" :
				if(isSearchWithAssert)
					jArray=honorService.findByAdvancedPerson(request.getParameter("searchContent"));
				else
					jArray=honorService.findByAdvancedPersonWithAssert(request.getParameter("searchContent"),
																						request.getParameter("searchRequirement2"));
				break;
			case "荣誉称号":
				if(isSearchWithAssert)
					jArray=honorService.findByHonoraryTitle(request.getParameter("searchContent"));
				else
					jArray=honorService.findByHonoraryTitleWithAssert(request.getParameter("searchContent"),
																					request.getParameter("searchRequirement2"));
				break;
			case "社会属性":
				if(isSearchWithAssert)
					jArray=honorService.findByJob(request.getParameter("searchContent"));
				else
					jArray=honorService.findByJobWithAssert(request.getParameter("searchContent"),
																		request.getParameter("searchRequirement2"));
				break;
			case "状态"://调动状态\死亡状况\认定状况，三种搜索情况合并为一讨论，因为是对同一个属性的搜索
				if(isSearchWithAssert)
					jArray=honorService.findByModelWorkerStatus(request.getParameter("searchContent"));
				else
					jArray=honorService.findByModelWorkerStatusWithAssert(request.getParameter("searchContent"),
																							request.getParameter("searchRequirement2"));
				break;
			case "待遇等级":
				if(isSearchWithAssert)
					jArray=honorService.findByTreatment(request.getParameter("searchContent"));
				else
					jArray=honorService.findByTreatmentWithAssert(request.getParameter("searchContent"),
																				request.getParameter("searchRequirement2"));
				break;
		}
		try {
			PrintWriter out = response.getWriter();
			JSONObject resultJsonObject  = new JSONObject();
			resultJsonObject.put("msg", "获取成功");
			resultJsonObject.put("rel", true);
			resultJsonObject.put("list", jArray);
			resultJsonObject.put("count", 7);
	        out.flush();
	        out.close();
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/determination")
	public void honorDetermination(HttpServletRequest request,HttpServletResponse response){
		Class<?> clazz = Honor.class;
		JSONObject resultJsonObject  = new JSONObject();
		try{
			Object honor = clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			
			//枚举Honor类的所有属性，从request获取，然后在实例中设置
			for(Field field : fields){
				field.setAccessible(true);
				if(field.getName() != "AdvancedPerson")
					field.set(honor, request.getParameter(field.getName()));
				else{//单独处理AdvancedPerson，从数据库中获取，再写入
					AdvancedPerson advancedPerson = 
							advancedPersonService.findById(request.getParameter("advancedPersonID"));
					field.set(honor, advancedPerson);
				}
				field.setAccessible(false);
			}
		
			
			
			honorService.update((Honor)honor);

			resultJsonObject.put("msg", "认定成功");
	        
		}catch(Exception e){
			resultJsonObject.put("msg", "认定失败");
			e.printStackTrace();
		}
		
		try{
			PrintWriter out = response.getWriter();
	        out.println(resultJsonObject);
	        out.flush();
	        out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}