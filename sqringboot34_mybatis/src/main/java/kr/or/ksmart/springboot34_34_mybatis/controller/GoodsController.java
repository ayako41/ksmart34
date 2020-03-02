package kr.or.ksmart.springboot34_34_mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ksmart.springboot34_34_mybatis.domain.Goods;
import kr.or.ksmart.springboot34_34_mybatis.domain.Member;
import kr.or.ksmart.springboot34_34_mybatis.service.GoodsService;
import kr.or.ksmart.springboot34_34_mybatis.service.MemberService;


@Controller
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private MemberService MemberService;
	
	@GetMapping("/gInsert")
	public String goodsInsertForm() {
		return "goods/gInsert";
	}
	@PostMapping("/gInsert")
	public String goodsInsert(Goods goods) {
		System.out.println(goods.toString());
		if(goodsService.goodsInsert(goods)>=1) {
			return "redirect:/gList";
		}
		return "goods/gInsert";
	}
	
	@GetMapping("/gList")
	public String goodsList(Model model){
		List<Goods> list = goodsService.goodslist();
		System.out.println(list.get(0).toString());
		model.addAttribute("gList", list);
		return "goods/gList";
	}
	@PostMapping("/gSearchList")
	public String goodsSearch(String sk,String sv,Model model) {
		System.out.println(sk+"<-sk");
		System.out.println(sv+"<-sv");
		
		if("".equals(sv)||sv==null) {
			return "redirect:/gList";
		}
		List<Goods> list = goodsService.goodsSearchlist(sk, sv);
		System.out.println(list.get(0).toString());
		model.addAttribute("gList", list);
		return "goods/gList";
	}
	
	@GetMapping("/gUpdate")
	public String goodsUpdate(String gCode,Model model) {
		Goods goods =goodsService.goodsUpdateForm(gCode);
		model.addAttribute("goods", goods);
		return "goods/gUpdate";
	}
	
	@PostMapping("/gUpdate")
	public String goodsUpdate(Goods goods,RedirectAttributes redirectA) {
		System.out.println(goods+"<-@PostMapping(\"/gUpdate\")");
		int result = goodsService.goodsUpdate(goods);
		if(result>=1) {
			return "redirect:/gList";
		}
		redirectA.addAttribute("gCode", goods.getgCode());
		return "redirect:/gUpdate";
	}
	
	@GetMapping("/gDelete")
	public String goodsDeleteCheck(String gCode,String mId,Model model) {
		model.addAttribute("gCode", gCode);
		model.addAttribute("mId", mId);
		return "goods/gDelete";
	}
	@PostMapping("/gDelete")
	public String goodsDelete(String gCode,String mId,String mPw,Model model) {
		Member member = MemberService.selectForUpdate(mId);
		if(member.getmPw().equals(mPw)) {
			if(goodsService.goodsDelete(gCode)>=1) {
				return "redirect:/gList";
			}
		}
		model.addAttribute("gCode", gCode);
		model.addAttribute("mId", mId);
		return "goods/gDelete";
	}
}
