package controller.main;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import command.LogInCommand;

@Controller
public class MainController {
	@GetMapping("main")
	public String mainPage(@ModelAttribute LogInCommand logInCommand) {
		return "main/main";
	}
}
