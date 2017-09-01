package com.team12.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.team12.web.model.User;
import com.team12.web.service.UserService;

/**

* 用户控制器

* @author 李俊

* @Time 2017-07-24 12:58:01

*/
@Controller
@RequestMapping("user")

//在controller调用一个或多个service方法，在service方法中实现复杂的业务逻辑，将结果用out.println返回前端

public class UserController {

    @Resource
    private UserService userService;

    /**
     * 获取用户列表
     */
    @RequestMapping("/getUserList")
    public void getJson(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        List<User> list = userService.getAllUser();
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(JSON.toJSONString(list));
        out.flush();
        out.close();
    }
    
    /**
     * 用户登录
     */
    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
    	String account = request.getParameter("username");
    	String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		
		List<User> checkUsers = userService.findByUsername(account);

		if(checkUsers.size() > 0){
			if(password.equals(checkUsers.get(0).getPassword())){
				JSONObject loginSuccessJSON = new JSONObject();
				loginSuccessJSON.put("hasError", false);
				loginSuccessJSON.put("msg", "登录成功");
				loginSuccessJSON.put("username", checkUsers.get(0).getUsername());
				
				out.println(loginSuccessJSON.toJSONString());
			}else {
				JSONObject loginSuccessJSON = new JSONObject();
				loginSuccessJSON.put("hasError", false);
				loginSuccessJSON.put("msg", "密码错误");
				
				out.println(loginSuccessJSON.toJSONString());
			}
		}else {
			JSONObject loginSuccessJSON = new JSONObject();
			loginSuccessJSON.put("hasError", false);
			loginSuccessJSON.put("msg", "用户名不存在");
		}
    }
}
