package kr.or.ksmart.springboot34_34_mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ksmart.springboot34_34_mybatis.service.MService;

@Controller
public class MController {
	
	@Autowired
	private MService mservice;
	
	/*
	 * @GetMapping public String mlist(Model model) { model.addAttribute("list",
	 * mservice.getlist()); return "mlist/memberList"; }
	 */
	
}
