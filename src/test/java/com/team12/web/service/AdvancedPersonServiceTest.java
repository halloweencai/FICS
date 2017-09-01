package com.team12.web.service;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.team12.web.dao.AdvancedPersonDAO;
import com.team12.web.model.AdvancedPerson;

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

public class AdvancedPersonServiceTest {

	@Resource
	private AdvancedPersonDAO advancedpersonDAO;
	@Resource
	private AdvancedPersonService advancedpersonService;
	
	@Test
	public void testAdd() throws Exception {
		AdvancedPerson advancedPerson = new AdvancedPerson("1", "jun", "man", "China", new Date(), "tuanyuan", "404", "13726808882", "huadi", "manong", "5", "1000", "404", "no", "404", "404", "404", "404", "404", null);
		advancedpersonService.add(advancedPerson);
	}
	
	@Test
	public void testFindById() throws Exception {
		System.out.println(advancedpersonService.findById("12345").getName());
	}
}
