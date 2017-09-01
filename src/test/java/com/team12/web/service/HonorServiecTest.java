package com.team12.web.service;

import com.alibaba.fastjson.JSONArray;
import com.team12.web.dao.AdvancedPersonDAO;
import com.team12.web.dao.HonorDAO;
import com.team12.web.model.*;
import com.team12.web.service.impl.HonorServiceImpl;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * 单元测试
 * @author developer
 */
// 告诉spring怎样执行
@RunWith(SpringJUnit4ClassRunner.class)
//  标明是web应用测试
@WebAppConfiguration(value = "src/main/webapp") //可以不填，默认此目录
// 配置文件地址ַ
@ContextConfiguration(locations = { "file:src/main/resources/applicationContext.xml", "file:src/main/resources/spring-hibernate.xml","file:src/main/resources/springMVC-servlet.xml"})

public class HonorServiecTest {
	
	@Resource
	private HonorService honorService;
	
	@Resource
	private AdvancedPersonService advancedPersonService;
	
	@Test
	public void test() throws Exception{
		
		StringBuffer sb = new StringBuffer();
		//honorService.insertTestData();
		JSONArray list = honorService.findAll();
		
		System.out.println(list);
		
		for(Object honor : list){
			sb.append(((Honor)honor).getFileNo()+" "+((Honor)honor).getFileName()+" "+((Honor)honor).getOutstandingDeeds()+" "+'\n');
			//System.out.println(((Honor)honor).getFileNo()+" "+((Honor)honor).getFileName()+" "+((Honor)honor).getOutstandingDeeds()+" ");
			sb.append(((Honor)honor).getAdvancedPerson().getIdnumber()+" "+'\n');
			//System.out.println(((Honor)honor).getAdvancedPerson().getIdnumber()+" ");
			
			AdvancedPerson advancedPerson = advancedPersonService.findById(((Honor)honor).getAdvancedPerson().getIdnumber());
			sb.append(advancedPerson.getName()+" "
					+advancedPerson.getHonoraryTitle()+" "+'\n');
			//System.out.println(advancedPerson.getName()+" "
				//				+advancedPerson.getHonoraryTitle()+" ");
		}
		System.out.println(sb);
		System.out.println("finished");
		
	}
	
	private void printList(List<Honor> list){
		try{
			FileOutputStream fileOS = new FileOutputStream(new File("D:\\abccc.txt"));
			for(Honor honor : list){
				System.out.println(honor.getAdvancedPerson().getIdnumber());
				fileOS.write(honor.getAdvancedPerson().toString().getBytes());
			}
			fileOS.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
