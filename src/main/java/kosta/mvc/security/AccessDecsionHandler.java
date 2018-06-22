package kosta.mvc.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class AccessDecsionHandler implements AccessDeniedHandler {

	public static final Logger logger = LoggerFactory.getLogger(AccessDecsionHandler.class);
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException ade) throws IOException, ServletException {

		logger.info("Exceiption : {}",ade);
		 logger.info("LocalizedMessage : {}",ade.getLocalizedMessage());
		 logger.info("Message : {}",ade.getMessage());
		 logger.info("StackTrace : {}",ade.getStackTrace());

		 request.setAttribute("errorMessage",ade.getMessage());
		 request.getRequestDispatcher("/WEB-INF/views/sign/sellerAuth.jsp").forward(request, response);
		
	}
}
