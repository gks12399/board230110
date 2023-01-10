package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/login.do")
	public String loginView() {
		return "user/login";
	}
	
	@PostMapping(value="/login.dox")
	public ModelAndView login(Model model, UserModel user) {
		
		ModelAndView mv = new ModelAndView();
		UserModel info = userService.login(user);
		
		if(info == null) {
			mv.addObject("check", "ID or PW Error");
			mv.setViewName("user/login");
		}
		
		else {
			session.setAttribute("UserId", info.getId());
			mv.addObject("check", "Success Login");
			mv.setViewName("main");
		}
		return mv;
	}
	
	@GetMapping("/logout.do")
	public ModelAndView logout() {
		ModelAndView mv = new ModelAndView();
		session.invalidate();
		mv.addObject("check", "Success Logout");
		mv.setViewName("main");
		return mv;
	}
	
}
