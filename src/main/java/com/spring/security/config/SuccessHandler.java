package com.spring.security.config;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler{

	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		String date = sdf.format(new Date());
		
		
		Map<String, Object> user = new HashMap<>();
		user.put("code","200");
		user.put("username",authentication.getName());
		user.put("role",authentication.getAuthorities());
		
		
		List<Object> object = new ArrayList<Object>();
		object.add("success");
		object.add(authentication.getName());
		object.add(date);
		
		try {
			response= setSuccessResponse(user,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public HttpServletResponse setSuccessResponse(Map<String, Object> user , HttpServletResponse response) throws Exception {
		
		response.setContentType("application/json;charset=UTF-8");
		response.setStatus(HttpServletResponse.SC_OK);
		
		PrintWriter writer = response.getWriter(); 
		writer.write(mapper.writeValueAsString(user)); 
       
        writer.flush();
        writer.close();
		
		return response;
			
	}

}