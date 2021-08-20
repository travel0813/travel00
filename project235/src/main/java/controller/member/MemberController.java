package controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Model.AuthInfoDTO;
import command.MemberCommand;
import service.main.LoginService;
import service.member.MemberJoinService;
import validator.MemberCommandValidator;

@Controller
@RequestMapping("/register")
public class MemberController {
	@Autowired
	MemberJoinService memberJoinService;
	@Autowired
	LoginService loginService;
	
	
	//회원가입 페이지 이동
	@RequestMapping("agree")
	public String agree() {
		return "member/agree";
	}
	
	//동의 후 넘어가기
	@RequestMapping(value="memRegist", method = RequestMethod.POST)
	public String memRegist(
			@RequestParam(value="agree", defaultValue = "false")
			Boolean agree,
			@ModelAttribute(value = "memberCommand") 
					MemberCommand memberCommand, Model model) {
		if(!agree) { 
			model.addAttribute("err", "동의에 체크해주세요.");
			return "member/agree";
		}
		return "member/memberForm";
	}
	
	//회원등록 --> 메인으로 이동
	@RequestMapping(value="memJoin",method = RequestMethod.POST )
	public String memJoin(MemberCommand memberCommand,Errors errors) {
		new MemberCommandValidator().validate(memberCommand, errors);
		if(errors.hasErrors()) {
			return "member/memberForm";
		}
		
		memberJoinService.memJoin(memberCommand);
		return "member/success";
	}

}
