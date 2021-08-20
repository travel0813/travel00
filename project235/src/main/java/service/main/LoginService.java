package service.main;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import Model.AuthInfoDTO;
import command.LogInCommand;
import repository.LogInRepository;

public class LoginService {
	@Autowired
	LogInRepository logInRepository;

	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	
	public void logIn1(LogInCommand logInCommand, Errors errors, HttpSession session, HttpServletResponse response) {
		
		String userId = logInCommand.getUserId();
		AuthInfoDTO authInfo = logInRepository.logIn(userId);
		
		session.setAttribute("authInfo", authInfo); 
	
	
	

}
}