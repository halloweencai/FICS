package com.team12.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.team12.web.dao.AdvancedPersonDAO;
import com.team12.web.dao.HonorDAO;
import com.team12.web.model.AdvancedPerson;
import com.team12.web.model.Honor;
import com.team12.web.service.HonorService;

import java.lang.reflect.*;

@Service
public class HonorServiceImpl implements HonorService {

	@Resource
	private AdvancedPersonDAO advancedPersonDAO;
	
	@Resource
	private HonorDAO honorDAO;

	@Override
	public JSONArray findAll() {
		return this.listToJSONObject(honorDAO.findAll());
	}
	
	@Override
	public void insertTestData(){
		for(int i=0;i<100;i++){
			Honor honor = new Honor();
			AdvancedPerson advancedPerson = new AdvancedPerson();
			advancedPerson.setIdnumber("1234567"+i);
			advancedPerson.setName("ahhhh"+i);
			advancedPerson.setSex("ox");
			advancedPerson.setNation("汉");
			advancedPerson.setBirthday(new Date(22,22,2));
			advancedPerson.setPoliticalStatus("politicalStatus");
			advancedPerson.setDegreeOfEducation("degreeOfEducation");
			advancedPerson.setTelephoneNumber("110");
			advancedPerson.setWorkplace("workplace");
			advancedPerson.setJob("job");
			advancedPerson.setHealthStatus("healthState");
			advancedPerson.setCityOwnedIndutries("cityOwnedIndutries");
			advancedPerson.setEmploymentStatus("Status");
			advancedPerson.setFamilyTrouble("familyTrouble");
			advancedPerson.setOutstandingDeeds("outstandingDeeds");
			advancedPerson.setHonoraryTitle("honoraryTitle");
			advancedPerson.setTreament("treament");
			advancedPerson.setModelWorkerStatus("Status");
			advancedPerson.setModelWorkerTitle("modelWorkerTitle");
			
			
			honor.setHonorContent("honorContent");
			honor.setGrantUnit("grantUnit");
			honor.setGrantTime(new Date(33,3,3));
			honor.setDispatchUnit("dispatchUnit");
			honor.setDispatchTime(new Date(33,4,3));
			honor.setRecord("record");
			honor.setHonorTitleTreatment("honorTitleTreatment");
			honor.setOutstandingDeeds("outstandingDeeds");
			honor.setBasisOfAsserting("basisOfAsserting");
			honor.setAdvice("advice");
			
			advancedPersonDAO.attachDirty(advancedPerson);
			honor.setFileNo(20+i);
			honor.setFileName("bhahaha"+i);
			honor.setDispatchTime(new Date());
			honor.setAdvancedPerson(advancedPerson);
			honorDAO.attachDirty(honor);
		}

		/*AdvancedPerson advancedPerson2 = new AdvancedPerson();
		//advancedPerson2 = advancedPerson;
		BeanUtils.copyProperties(advancedPerson2, advancedPerson);
		Honor honor2 = new Honor();
		//honor2 = honor;
		BeanUtils.copyProperties(honor2, honor);
		advancedPerson2.setIdnumber("123456");
		advancedPersonDAO.attachDirty(advancedPerson2);
		honor2.setFileNo(2);
		honor2.setFileName("bhahaha");
		honor2.setDispatchTime(new Date());
		honor2.setAdvancedPerson(advancedPerson2);
		honorDAO.attachDirty(honor2);*/
		
		/*AdvancedPerson advancedPerson3 = new AdvancedPerson();
		//advancedPerson3= advancedPerson;
		BeanUtils.copyProperties(advancedPerson3, advancedPerson);
		Honor honor3 = new Honor();
		//honor3 = honor;
		BeanUtils.copyProperties(honor3, honor);
		advancedPerson3.setIdnumber("1234567");
		advancedPersonDAO.attachDirty(advancedPerson3);
		honor3.setFileNo(3);
		honor3.setFileName("chahaha");
		honor3.setDispatchTime(new Date());
		honor3.setAdvancedPerson(advancedPerson3);
		honorDAO.attachDirty(honor3);*/
	}
	
	@Override
	public JSONArray findByAdvancedPerson(String string) {
		List<Honor> honors = new ArrayList<Honor>();
		List<AdvancedPerson> advancedPersons;
		honors.clear();
		
		Class clazz = AdvancedPerson.class;
		Field[] fields = clazz.getDeclaredFields();
		String propertyName = new String();
		
		//通过反射枚举所有属性
		for(Field field : fields){
			propertyName = field.getName();
			Object object = field.getType();
			
			//如果该属性是String类型，则进行查找，如果用String对非String类型查找会报错
			if(object.toString().equals("class java.lang.String")){
				
				advancedPersons = advancedPersonDAO.findByProperty(propertyName,string);
				for(AdvancedPerson advancedPerson : advancedPersons){
					//advancedPerson中包含对应的Honor，获取出来即可，不用再次查询数据库
					for(Honor tmpHonor : advancedPerson.getHonors()){
						//避免重复加入，先判定不存在数组中，再加入
						if(honors.contains(tmpHonor)==false)honors.add(tmpHonor);
					}
				}
				
			} 		}
		
		return this.listToJSONObject(honors);
	}
	
	@Override
	public JSONArray findByHonoraryTitle(String honoraryTitle) {
		List<AdvancedPerson> advancedPersons = advancedPersonDAO.findByHonoraryTitle(honoraryTitle);
		return this.findByAdvancedPersons(advancedPersons);
	}

	@Override
	public JSONArray findByJob(String job) {
		List<AdvancedPerson> advancedPersons = advancedPersonDAO.findByJob(job);
		return this.findByAdvancedPersons(advancedPersons);
	}

	@Override
	public JSONArray findByModelWorkerStatus(String modelWorkerStatus) {
		List<AdvancedPerson> advancedPersons = advancedPersonDAO.findByModelWorkerStatus(modelWorkerStatus);
		return this.findByAdvancedPersons(advancedPersons);
	}

	@Override
	public JSONArray findByTreatment(String treatment) {
		List<AdvancedPerson> advancedPersons = advancedPersonDAO.findByTreament(treatment);
		return this.findByAdvancedPersons(advancedPersons);
	}

	@Override
	public JSONArray findByAdvancedPersonWithAssert(String advancedPerson,String _assert) {
		return getSameItems(
					this.findByAdvancedPerson(advancedPerson),
					this.findByModelWorkerStatus(_assert));
	}

	@Override
	public JSONArray findByHonoraryTitleWithAssert(String honoraryTitle,String _assert) {
		return getSameItems(
					this.findByHonoraryTitle(honoraryTitle),
					this.findByModelWorkerStatus(_assert));
	}

	@Override
	public JSONArray findByJobWithAssert(String job,String _assert) {
		return getSameItems(
					this.findByJob(job),
					this.findByModelWorkerStatus(_assert));
	}

	@Override
	public JSONArray findByModelWorkerStatusWithAssert(String modelWorkerStatus,String _assert) {
		return getSameItems(
					this.findByModelWorkerStatus(modelWorkerStatus),
					this.findByModelWorkerStatus(_assert));
	}

	@Override
	public JSONArray findByTreatmentWithAssert(String treatment,String _assert) {
		return getSameItems(
					this.findByTreatment(treatment),
					this.findByModelWorkerStatus(_assert));
	}
	
	@Override
	public JSONObject update(Honor honor){
		JSONObject jsonObject = new JSONObject();
		jsonObject.clear();
		List<Honor> honors = honorDAO.findByProperty("fileNo", honor.getFileNo());
		if(honors.size()==0){
			jsonObject.put("msg", "找不到荣誉，荣誉更新失败");
		}
		else {
			honorDAO.attachDirty(honor);
			jsonObject.put("msg", "荣誉更新成功");
		}
		
		return jsonObject;
	}
	
	@Override
	public JSONArray findByName(String name){
		List<AdvancedPerson> advancedPersons = advancedPersonDAO.findByName(name);
		return this.findByAdvancedPersons(advancedPersons);
	}
	
	@Override
	public JSONArray findByRecord(String record){
		List<Honor> honors = honorDAO.findByRecord(record);
		return this.listToJSONObject(honors);
	}
	
	@Override
	public AdvancedPerson findByPersonID(String ID){
		return advancedPersonDAO.findById(ID);
	}
	
	/**
	 * 提取出公用步骤，从advancedPerson中提出Honor。
	 */
	@Override
	public JSONArray findByAdvancedPersons(List<AdvancedPerson> advancedPersons){
		List<Honor> honors = new ArrayList<Honor>();
		honors.clear();
		
		for(AdvancedPerson advancedPerson : advancedPersons){
			for(Honor tmpHonor : advancedPerson.getHonors()){
				if(honors.contains(tmpHonor)==false)honors.add(tmpHonor);
			}
		}
		
		return this.listToJSONObject(honors);
	}
	
	
	
	public JSONArray listToJSONObject(List<Honor> list){
		JSONArray ja = new JSONArray();
		ja.addAll(list);
		return ja;
	}
	
	/**
	 * 提出两个List类中共同的部分
	 * @param listA
	 * @param listB
	 * @return
	 */
	public JSONArray getSameItems(JSONArray listA,JSONArray listB){
		JSONArray honors = new JSONArray();
		honors.clear();
		
		for(Object honor : listA){
			if(listB.contains(honor))honors.add(honor);
		}
		
		return honors;
	}
}
