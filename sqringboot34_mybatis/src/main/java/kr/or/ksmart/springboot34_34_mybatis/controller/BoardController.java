package kr.or.ksmart.springboot34_34_mybatis.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.springboot34_34_mybatis.service.BoardService;

@Controller
public class BoardController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/boardList")
	public String boardList(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,Model model) {
		logger.info("currentPage",currentPage);
		System.out.println("SYSOUTcurrentPage::"+currentPage);
		Map<String,Object> map = boardService.boardList(currentPage);
		model.addAttribute("boardList", map.get("boardList"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("startPageNum", map.get("startPageNum"));
		model.addAttribute("endPageNum", map.get("endPageNum"));
		System.out.println("startPageNum"+map.get("startPageNum"));
		
		return "board/boardList";
	}
}
