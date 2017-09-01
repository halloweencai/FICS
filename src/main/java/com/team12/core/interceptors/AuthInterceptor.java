package com.team12.core.interceptors;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthInterceptor implements HandlerInterceptor{
	
    private List<String> excludeUrls;// 不需要拦截的资源
    
    public List<String> getExcludeUrls() {
        return excludeUrls;
    }
    public void setExcludeUrls(List<String> excludeUrls) {
        this.excludeUrls = excludeUrls;
    }

    /** 
     * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，
     * SpringMVC中的Interceptor拦截器是链式的，可以同时存在多个Interceptor，
     * 然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在Controller方法调用之前调用。
     * SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返 
     * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。 
     */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestURI.substring(contextPath.length()+1);
        
        // 测试用
        if (true) {
            return true;
        }

        // 如果要访问的资源是不需要验证的
        if (excludeUrls.contains(url)) {
            return true;
        }

        // 获取用户 信息 验证 然后判断  TODO

        return false;
	}
	
    /**
     * 在Controller的方法调用之后执行
     */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	
    /**
     * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。
     */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
	
	
	public void before(){
		System.out.println("method start"); 
	}
	
//	private Object target = new Object(); 
//	
//	public Object getTarget() {
//		return target;
//	}
//	
//	public void setTarget(Object target) {
//		this.target = target;
//	}

//	@Override
//	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//		beforeMethod();
//		method.invoke(target, args);
//		return null;
//	}
	
}
