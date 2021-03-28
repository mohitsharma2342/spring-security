package com.spring.security.config;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class FailureHandler implements AuthenticationFailureHandler {

	private static final ObjectMapper mapper = new ObjectMapper();
	
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
			List<Object> object = new ArrayList<Object>();
			object.add("fail");
			
			try {
				response=sendErrorResponse(object,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			/*Setting standard unauthorized status for unauthorized access*/
			//response.sendRedirect("/login/login.html");
		}
		
		
	public HttpServletResponse sendErrorResponse(List<Object> object, HttpServletResponse response) throws Exception {
		
		
		response.setContentType("application/json;charset=UTF-8");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			
			PrintWriter writer = response.getWriter(); 
			writer.write(mapper.writeValueAsString(object)); 
	       
	        writer.flush();
	        writer.close();
			
	        return response;
			
		}
}