package edu.mum.interceptor;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class VolunteerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// test interceptor Order
		System.out.println("INTERCEPTOR PREHANDLE");

		return true;

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String userMessage = "Hi There! Please Become a Community Member!!!";

		Principal principal = request.getUserPrincipal();

		if (principal != null) {
			if (request.isUserInRole("ROLE_ADMIN"))
				userMessage = "Hello, " + principal.getName() + "!!! Enjoy your work!!! ";
			else
				userMessage = "Hello, " + principal.getName() + "!!! You are doing great ";
		}

		System.out.println("Calling postHandle");
		modelAndView.getModelMap().addAttribute("GreetingMessage", userMessage);

		return;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("Calling afterCompletion");
		return;
	}

}
