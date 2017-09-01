package com.team12.web.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team12.web.model.User;
import com.team12.web.service.UserService;

//直接返回字符串重定向到jsp页面

/**

* URL跳转控制器

* @author 李俊

* @Time 2017-07-24 12:58:01

*/
@Controller  
public class URLController {  
	
	@Resource
    private UserService userService;
	
	@RequestMapping(value = "/login")
	public String login() {  
        return "login";  
    }  

    @RequestMapping(value = "/welcome/{id:[\\d]+}")
	public String getuser(HttpServletRequest request, HttpServletResponse response, @PathVariable final int id, Model model)
			throws IOException{
        User user = userService.find(id);
    	model.addAttribute("username",user.getUsername());
        return "welcome";
    }
    
    @RequestMapping(value = "/welcome")
   	public String welcome(HttpServletRequest request, HttpServletResponse response, int id, Model model)
   			throws IOException{
        User user = userService.find(id);
       	model.addAttribute("username",user.getUsername());
        return "welcome";
    }
    
    @RequestMapping(value = "/err")
   	public String err(HttpServletRequest request, HttpServletResponse response, int id, Model model)
   			throws IOException{
        return "err";
    }
	
}  