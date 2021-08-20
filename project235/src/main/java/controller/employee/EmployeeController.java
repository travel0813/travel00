package controller.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.EmployeeCommand;
import service.employee.EmployeeJoinService;
import service.employee.EmployeeListService;
import service.employee.EmployeeNumService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	EmployeeNumService employeeNumService;
	@Autowired
	EmployeeJoinService employeeJoinService;
	@Autowired
	EmployeeListService employeeListService;
	
	
	


	//직원리스트 List
	@RequestMapping(value="/empList", method = RequestMethod.GET)
	public String empList(Model model,
			@RequestParam(value="page" , defaultValue = "1")Integer page) {
		employeeListService.empList(model, page);
		return "employee/employeeList";	
	}
	
	
	//직원등록, empNo 페이지
	@RequestMapping(value = "empRegist", method = RequestMethod.GET)
	public String empRegist(Model model, EmployeeCommand employeeCommand) {
		employeeNumService.empNo(model, employeeCommand);
		return "employee/employeeForm";
	}
	
	//직원등록 ->직원리스트로이동
	@RequestMapping("empJoin")
	public String empJoin(Model model, EmployeeCommand employeeCommand) {
		employeeJoinService.empInsert(employeeCommand);
		return "redirect:empList";
	}
	

	

	

}
