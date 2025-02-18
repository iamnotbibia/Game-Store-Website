package com.example.demo.utill;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.example.demo.model.UserDtls;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class CommonUtil {

	
	
	@Autowired
	private UserService userService;


	public static String generateUrl(HttpServletRequest request) {

		String siteUrl = request.getRequestURL().toString();

		return siteUrl.replace(request.getServletPath(), "");
	}
	
	String msg=null;;
	
	
	public UserDtls getLoggedInUserDetails(Principal p) {
		String email = p.getName();
		UserDtls userDtls = userService.getUserByEmail(email);
		return userDtls;
	}
	

}
