package com.example.demo.user;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/login.do")
	public ModelAndView loginView() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/login");
		return mv;
	}
	
	@PostMapping(value="/login.dox")
	public ModelAndView login(Model model, UserModel user) throws Exception{
		
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
	public ModelAndView logout() throws Exception{
		ModelAndView mv = new ModelAndView();
		session.invalidate();
		mv.addObject("check", "Success Logout");
		mv.setViewName("main");
		return mv;
	}
	
	@GetMapping("userAdd.do")
	public ModelAndView userAddView() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/userAdd");
		return mv;
	}
	
	@PostMapping(value="/findId.dox")
	@ResponseBody
	public int findId(@RequestParam String id) throws Exception{
		int cnt = userService.findId(id);
		return cnt;
	}
	
	@PostMapping(value="/userAdd.dox")
	@ResponseBody
	public ModelAndView userAdd(@RequestParam HashMap<String, Object> map) throws Exception{
		ModelAndView mv = new ModelAndView();
		userService.userAdd(map);
		mv.setViewName("redirect:/login.do");
		return mv;
	}
	
}
