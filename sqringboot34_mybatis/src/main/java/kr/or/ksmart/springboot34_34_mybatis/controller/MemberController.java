package kr.or.ksmart.springboot34_34_mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ksmart.springboot34_34_mybatis.domain.Member;
import kr.or.ksmart.springboot34_34_mybatis.service.MemberService;

@Controller
public class MemberController {

		@Autowired
		private MemberService MemberService;
		
		@GetMapping("/login")
		public String login() {
			return "login/login";
		}
		
		@PostMapping("/login")
		public String login(@RequestParam(value="mId",required=false)String mId
							,@RequestParam(value="mPw",required=false)String mPw
							,Model model
							,HttpSession session) {
			System.out.println(mId+"<-mId");
			System.out.println(mPw+"<-mPw");
			
			Member member = MemberService.selectForUpdate(mId);
			if(member!=null&&mPw!=null&&!"".equals(mPw)&&member.getmPw().equals(mPw)) {
				System.out.println("ok");
				session.setAttribute("SID", member.getmId());
				session.setAttribute("SNAME", member.getmName());
				session.setAttribute("SLEVEL", member.getmLevel());
				return "redirect:/";
			}else {
				System.out.println("x");
				model.addAttribute("result", "등록된 회원이 아닙니다");
				return "login/login";
			}
		}
		
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "login/login";
		}
		
		@PostMapping("/memberList")
		public String memberList(@RequestParam(value="sk")String sk
								,@RequestParam(value="sv",required = false)String sv
								,Model model) {
			System.out.println("binding test sk: "+sk);
			System.out.println("binding test sv: "+sv);
			if("".equals(sv)) {
				model.addAttribute("memberList", MemberService.getMemberList());
			}else {
				List<Member> list = MemberService.getSelectList(sk, sv);
				model.addAttribute("memberList", list);
			}	
			return "mlist/memberList";
		}
		
		@GetMapping("/mDelete")
		public String mDelete(@RequestParam(value="mId")String mId, Model model) {
			model.addAttribute("mId", mId);			
			return "mDelete/mDelete";
		}
		@PostMapping("/mDelete")
		public String mDelete(@RequestParam(value="mId",required=false) String mId,
				@RequestParam(value="mPw",required=false) String mPw
								,Model model
								,RedirectAttributes redirectA) {
			
			Member member = MemberService.selectForUpdate(mId);
			String pw = member.getmPw();
			
			if(mPw.equals(pw)) {
				System.out.println("mPw==pw");
				MemberService.mDelete(mId);
				return "redirect:/memberList";
			}else {
				System.out.println("mPw!=pw");
				redirectA.addAttribute("mId", mId);
				return "redirect:/mDelete";	
				/*
				model.addAttribute("mId", mId);
				return "mDelete/mDelete";//foward方式で送る。今回はredirectが合う。
				*/
			}
		}
		
		@GetMapping("/memberList")
		public String getMemberList(Model model) {
			model.addAttribute("memberList", MemberService.getMemberList());
			System.out.println(MemberService.getMemberList().toString());
			return "mlist/memberList";
		}
		
		@GetMapping("/mUpdate")
		public String mUpdate(@RequestParam(value="mId",required=false) String mId,Model model) {
			System.out.println("binding test: "+mId);
			System.out.println("binding test2: "+MemberService.selectForUpdate(mId));
			model.addAttribute("Member", MemberService.selectForUpdate(mId));
			return "mUpdate/mUpdate";
		}
		@PostMapping("/mUpdate")
		public String mUpdate(Member member) {
			System.out.println(member.toString());
			int result = MemberService.mUpdate(member);
			if(result>0) {
				return "redirect:/memberList";
			}
			return "redirect:/mUpdate";
		}
		
		@GetMapping("/mInsert")
		public String mInsert() {
			
			return "mInsert/mInsert";
		}
		/*
		@PostMapping("/mInsert")
		public String mInsert(@RequestParam(value="mId",required=false) String mId) {
			System.out.println("binding test: "+mId);
			return "redirect:/mInsert";
		}
		*/
		
		@PostMapping("/mInsert")
		public String mInsert(Member member) {
			System.out.println(member.toString());
			int result = MemberService.mInsert(member);
			if(result>0) {
				return "redirect:/memberList";
			}
			return "redirect:/mInsert";
		}
		
		
}
