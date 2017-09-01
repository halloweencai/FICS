package com.team12.web.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.team12.web.dao.UserDAO;
import com.team12.web.model.User;
import com.team12.web.service.UserService;

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

public class UserServiceTest {

	@Resource
	private UserDAO userDao;
	@Resource
	private UserService userService;
	private User user = new User();
	
	@Test
	public void testAdd() throws Exception {
		user.setUsername("hana");
		userService.add(user);
	}
	
}
