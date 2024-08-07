package com.poscodx.jblog.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.poscodx.jblog.service.UserService;
import com.poscodx.jblog.vo.UserVo;

public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	private UserService userService;
	

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("dodododo");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println("id2= " + id +" password2 = " + password); 
		UserVo authUser = userService.getUser(id,password);
		System.out.println(authUser);
		
		
		if(authUser == null) {
			request.setAttribute("id", id);
			request.setAttribute("result", "fail");
			request
				.getRequestDispatcher("/WEB-INF/views/user/login.jsp")
				.forward(request, response);
			return false;
		}
		
		/* login 처리 */
		System.out.println(authUser);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", authUser);
		response.sendRedirect(request.getContextPath());

		return false;
	}
}